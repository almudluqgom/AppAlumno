package com.example.CodPrincipal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import info.androidhive.sqlite.helper.DatabaseHelper;
import info.androidhive.sqlite.model.Alumno;

public class MainActivity extends AppCompatActivity {
    // Database Helper
    DatabaseHelper db;
    private TextView textAl;
    private String IdAlumno = "";
    //private Alumno alumnoregistrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAl = (TextView)findViewById(R.id.TextoSaludoAlumno);
        IdAlumno = getIntent().getStringExtra("IdAlumno");

        if(IdAlumno == ""){
            textAl.setText("<- Inicia sesión pulsando el icono");
        }
        else{
            //if(alumnoregistrado == null)       alumnoregistrado =db.getAlumno(IdAlumno);
            textAl.setText("Hola, " + db.getNombreAlumno(IdAlumno));
        }
    }

    //Boton a la activity VerListaActivity Tareas
    public void AccedeTareas(View view){
        Intent LisTareas = new Intent(this, VerListaActivity.class);
        LisTareas.putExtra("IdAlumno",IdAlumno);
        startActivity(LisTareas);
    }
    //Boton Login
    public void seleccionaUsuario(View view){
        //alumnoregistrado = new Alumno();    //borramos los datos del alumno anterior
        IdAlumno = "";                      //tanto usuario como ID
        Intent LoginAct = new Intent(this, LoginActivity.class);
        startActivity(LoginAct);
    }
    //Boton Progreso
    public void AccedeProgreso(View view){
        Intent Progreso = new Intent(this, ProgresoActivity.class);
        Progreso.putExtra("IdAlumno",IdAlumno);
        startActivity(Progreso);
    }
    public void AccedeMaceta(View view){
        Intent Maceta = new Intent(this, MacetaActivity.class);
        Maceta.putExtra("IdAlumno",IdAlumno);
        startActivity(Maceta);
    }
}