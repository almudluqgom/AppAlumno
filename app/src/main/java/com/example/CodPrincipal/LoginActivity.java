package com.example.CodPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import info.androidhive.sqlite.helper.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String NombreAlumno;
    DatabaseHelper admin = new DatabaseHelper(this, "administracion", null, 1);
    ArrayList<String> listAlumnos = admin.getListAlumnos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner spin = (Spinner) findViewById(R.id.SpinnerTareas);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, listAlumnos);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //crear intent con la tarea y pasar el ID de la tarea

        Intent Inicio = new Intent(this, MainActivity.class);
        Inicio.putExtra("IdAlumno", listAlumnos.get(position));
        startActivity(Inicio);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void Volver(View view){
        Intent Volver = new Intent(this, MainActivity.class);
        startActivity(Volver);
    }
}