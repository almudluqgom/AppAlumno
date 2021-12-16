package com.example.CodPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import info.androidhive.sqlite.helper.model.Alumno;

public class ProgresoActivity extends AppCompatActivity {
    Alumno AlumnoActual;
    TextView tvR, tvPython, tvCPP;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progreso);

        if(getIntent().getExtras() != null) {
            AlumnoActual = (Alumno) getIntent().getSerializableExtra("alumno");
        }

        // Link those objects with their respective
        // id's that we have given in .XML file
        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        pieChart = findViewById(R.id.piechart);

        // Set the percentage of language used
        tvR.setText(String.valueOf(AlumnoActual.getTareasEntregadas()));
        tvPython.setText(String.valueOf(AlumnoActual.getTareasCompletas()));
        tvCPP.setText(String.valueOf(AlumnoActual.getTareasSinHacer()));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Entregadas",
                        Integer.parseInt(tvR.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Finalizadas",
                        Integer.parseInt(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Sin Hacer",
                        Integer.parseInt(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));

        // To animate the pie chart
        pieChart.startAnimation();

    }
    public void Volver(View view){
        Intent Volver = new Intent(this, MainActivity.class);
        Volver.putExtra("alumno", AlumnoActual);
        startActivity(Volver);
    }
}