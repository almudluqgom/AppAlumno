package com.example.CodPrincipal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import info.androidhive.sqlite.helper.helper.RecViewAdaptAlumno;
import info.androidhive.sqlite.helper.model.Alumno;

public class LoginActivity extends AppCompatActivity {
    protected RecyclerView recyclerViewAlumno;
    private RecViewAdaptAlumno adaptadorAlumno;
    List<Alumno> listAlumnos;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        listAlumnos = new ArrayList<Alumno>();
        recyclerViewAlumno = (RecyclerView) findViewById(R.id.recyclerMaterial);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewAlumno.setLayoutManager(layoutManager);

        adaptadorAlumno = new RecViewAdaptAlumno(listAlumnos);
        adaptadorAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Volver = new Intent(getApplicationContext(), MainActivity.class);
                Alumno alumno = new Alumno(listAlumnos.get(recyclerViewAlumno.getChildAdapterPosition(v)));
                Volver.putExtra("alumno",alumno);
                startActivity(Volver);
            }
        });
        adaptadorAlumno.notifyDataSetChanged();
        obtenerListaAlumnos();
    }

    public void obtenerListaAlumnos(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url="http://dgpsanrafael.000webhostapp.com/selectAlumnos.php";
        //url= http://url
        StringRequest stringRequest = new StringRequest (Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray itemArray = new JSONArray(response);
                            for (int i = 0; i < itemArray.length(); i++) {
                                JSONObject Alum = itemArray.getJSONObject(i);
                                listAlumnos.add(new Alumno(
                                        Alum.getString("id"),
                                        Alum.getString("nombre"),
                                        Alum.getString("idfoto"),
                                        Alum.getInt("tareasc"),
                                        Alum.getInt("tareass"),
                                        Alum.getInt("tarease"),
                                        Alum.getInt("gotas"),
                                        Alum.getInt("estadom")
                                ));
                            }
                            recyclerViewAlumno.setAdapter(adaptadorAlumno);
                            adaptadorAlumno.notifyDataSetChanged();
                        }
                        catch (JSONException e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        int socketTimeout = 30000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        requestQueue.add(stringRequest);

    }
}