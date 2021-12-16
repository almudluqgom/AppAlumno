package com.example.CodPrincipal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import info.androidhive.sqlite.helper.model.Alumno;

public class MainActivity extends AppCompatActivity {
    // Database Helper
    private TextView textAl;
    private String IdAlumno = "";
    Alumno AlumnoActual;
    Button botonT, botonP;
    ImageButton botonA, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (ImageButton)findViewById(R.id.BotonLogin);
        login.setBackgroundResource(R.drawable.logo1);
        textAl = (TextView)findViewById(R.id.TextoSaludoAlumno);
        botonT = (Button)findViewById(R.id.BotonTarea);
        botonP = (Button)findViewById(R.id.BotonProgreso);
        botonA = (ImageButton) findViewById(R.id.BotonMaceta);

        if(getIntent().getExtras() != null) {
            AlumnoActual = (Alumno) getIntent().getSerializableExtra("alumno");
            login.setBackgroundResource(AlumnoActual.getIDFoto());
            IdAlumno =AlumnoActual.getIdAlumno();
        }

        if(!TextUtils.isEmpty(IdAlumno)){
            textAl.setText("Hola, " +AlumnoActual.getNombreApell());
            botonT.setEnabled(true);
            botonP.setEnabled(true);
        }
    }

    //Boton a la activity VerListaActivity Tareas
    public void AccedeTareas(View view){
        Intent LisTareas = new Intent(this, VerListaActivity.class);
        LisTareas.putExtra("alumno",AlumnoActual);
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
        Progreso.putExtra("alumno",AlumnoActual);
        startActivity(Progreso);
    }
    public void AccedeMaceta(View view){
        Intent Maceta = new Intent(this, MacetaActivity.class);
        Maceta.putExtra("alumno",AlumnoActual);
        startActivity(Maceta);
    }
}