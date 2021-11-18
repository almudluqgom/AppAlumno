package com.example.CodPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.sqlite.helper.DatabaseHelper;
import info.androidhive.sqlite.model.Alumno;
import info.androidhive.sqlite.model.Tareas;

public class VerListaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String IdAlumno = "";
    DatabaseHelper admin = new DatabaseHelper(this, "administracion", null, 1);
    ArrayList<String> tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);
        IdAlumno = getIntent().getStringExtra("IdAlumno");
        tareas = admin.getTareasAlumno(IdAlumno);

        Spinner spin = (Spinner) findViewById(R.id.SpinnerTareas);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,tareas);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    public void Volver(View view){
        Intent Volver = new Intent(this, MainActivity.class);
        Volver.putExtra("IdAlumno",IdAlumno);
        startActivity(Volver);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Intent IrATarea = new Intent(this, TareaActivity.class);
        String IdTarea = tareas.get(position);
        IrATarea.putExtra("IdTarea",IdTarea);
        IrATarea.putExtra("IdAlumno",IdAlumno);
        startActivity(IrATarea);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}