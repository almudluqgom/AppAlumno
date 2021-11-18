package com.example.CodPrincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidhive.sqlite.helper.DatabaseHelper;
import info.androidhive.sqlite.model.Tareas;

public class TareaActivity extends AppCompatActivity {

    DatabaseHelper admin = new DatabaseHelper(this, "administracion", null, 1);
    Tareas tarea;
    TextView textstatus,textcantidad,texthora_feedback;
    ImageView fotoProfe, fotoObjeto, fotoFeedback;
    View botonConfirma, botonAyuda;
    private String IdTarea = "";
    private String IdAlumno = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IdTarea = getIntent().getStringExtra("IdTarea");
        IdAlumno = getIntent().getStringExtra("IdAlumno");

        tarea = admin.getTarea(IdTarea);
        setViewTarea(tarea);

        setContentView(R.layout.activity_tarea);
    }

    public void Volver(View view){
        Intent Volver = new Intent(this, MainActivity.class);
        Volver.putExtra("IdAlumno",IdAlumno);
        startActivity(Volver);
    }

    public void setViewTarea(Tareas tarea){

        String status="",
        hora = "",
        cantidad = "";

        textstatus = (TextView)findViewById(R.id.statusTarea);
        textcantidad = (TextView)findViewById(R.id.CantidadObjeto);
        texthora_feedback= (TextView)findViewById(R.id.HoraentregaFeedback);
        fotoObjeto=(ImageView)findViewById(R.id.ImagenObjeto);
        fotoProfe=(ImageView)findViewById(R.id.imagenProfesorSolicitante);
        fotoFeedback=(ImageView)findViewById(R.id.PictogramaFeedback);
        botonAyuda= findViewById(R.id.BotonAyuda);
        botonConfirma= findViewById(R.id.BotonEntrega);

        //status de la tarea: 0 Sin empezar 1 Empezada, 2 Entregada, 3 Completa, 4 Sin Finalizar
        //según el estado de las tareas se muestran unos campos u otros
        switch(tarea.getStatus()) {
            case 1:
                status = "Empezada";
                fotoFeedback.setVisibility(View.INVISIBLE);
                break;
            case 2:
                status = "Entregada";
                fotoFeedback.setVisibility(View.INVISIBLE);
                botonConfirma.setVisibility(View.INVISIBLE);
                botonAyuda.setVisibility(View.INVISIBLE);
                texthora_feedback.setText("Tarea entregada. Esperando confirmación del profe...");
                break;
            case 3:
                status = "Completa";
                fotoFeedback.setVisibility(View.VISIBLE);
                botonConfirma.setVisibility(View.INVISIBLE);
                botonAyuda.setVisibility(View.INVISIBLE);
                texthora_feedback.setText(tarea.getComentario());
                break;
            case 4:
                status = "Sin finalizar";
                fotoFeedback.setVisibility(View.VISIBLE);
                botonConfirma.setVisibility(View.INVISIBLE);
                botonAyuda.setVisibility(View.INVISIBLE);
                break;

        }
        textstatus.setText("Status de la tarea= "+ status);
    }
    public void EntregarTarea(){
        admin.setTareaEntregada(tarea,IdTarea);
        Intent Volver = new Intent(this, MainActivity.class);
        Volver.putExtra("IdAlumno",IdAlumno);
        startActivity(Volver);
    }
}