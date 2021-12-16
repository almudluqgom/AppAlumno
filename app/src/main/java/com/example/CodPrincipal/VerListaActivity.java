package com.example.CodPrincipal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.androidhive.sqlite.helper.helper.RecViewAdaptTarea;
import info.androidhive.sqlite.helper.model.Alumno;
import info.androidhive.sqlite.helper.model.Tareas;


public class VerListaActivity extends AppCompatActivity {
    protected RecyclerView recyclerViewTareas;
    private RecViewAdaptTarea adaptadorTarea;
    List<Tareas> listTareas;
    Alumno AlumnoActual;
    String IdAlumno ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        if(getIntent().getExtras() != null) {
            AlumnoActual = (Alumno) getIntent().getSerializableExtra("alumno");
            IdAlumno = AlumnoActual.getIdAlumno();
        }
        listTareas = new ArrayList<Tareas>();
        recyclerViewTareas= (RecyclerView) findViewById(R.id.recyclerMaterial);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewTareas.setLayoutManager(layoutManager);

        adaptadorTarea = new RecViewAdaptTarea(listTareas);
        adaptadorTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IrATarea = new Intent(getApplicationContext(), TareaActivity.class);
                Tareas t = new Tareas(listTareas.get(recyclerViewTareas.getChildAdapterPosition(v)));
                IrATarea.putExtra("alumno", AlumnoActual);
                startActivity(IrATarea);
            }
        });
        adaptadorTarea.notifyDataSetChanged();
        obtenerListaTareas();
    }

    public void Volver(View view){
        Intent Volver = new Intent(this, MainActivity.class);
        Volver.putExtra("alumno", AlumnoActual);
        startActivity(Volver);
    }

    public void obtenerListaTareas(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url="http://dgpsanrafael.000webhostapp.com/selectTareaAl.php?id="+ IdAlumno;
        StringRequest stringRequest = new StringRequest (Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray itemArray = new JSONArray(response);
                            for (int i = 0; i < itemArray.length(); i++) {
                                JSONObject T = itemArray.getJSONObject(i);
                                boolean al=false,pr=false;
                                if( T.getInt("ConfirmacionAlumno")==1) al = true;
                                if( T.getInt("ConfirmacionProfesor")==1) pr=true;
                                listTareas.add(new Tareas(
                                        T.getInt("id"),       //int id,
                                        T.getString("nombre"), //String NombreObjeto
                                        T.getInt("idFoto"),       //int idFoto,
                                        T.getInt("idProfesor"),//int idProfe,
                                        T.getInt("idAlumno"),//int idAlumno,
                                        T.getInt("idObjeto"),//int idObjeto,
                                        T.getString("HoraEntrega"),//String horaEntrega,
                                        T.getString("Comentario"),//String comentario,
                                        T.getInt("Cantidad"),//int cantidadObjeto,
                                        al,//boolean confirmaAlumno,
                                        pr,//boolean confirmaProfesor,
                                        T.getInt("EstadoTarea"),//int status
                                        T.getInt("idFeedback")
                                ));
                            }
                            recyclerViewTareas.setAdapter(adaptadorTarea);
                            adaptadorTarea.notifyDataSetChanged();
                        }
                        catch (JSONException e) {
                            Toast.makeText(VerListaActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(VerListaActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("id", IdAlumno);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}