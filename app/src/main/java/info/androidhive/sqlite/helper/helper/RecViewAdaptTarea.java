
package info.androidhive.sqlite.helper.helper;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.CodPrincipal.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import info.androidhive.sqlite.helper.model.Alumno;
import info.androidhive.sqlite.helper.model.Tareas;

public class RecViewAdaptTarea extends RecyclerView.Adapter<RecViewAdaptTarea.ViewHolder> implements View.OnClickListener{

    public List<Tareas> TareasLista;
    private View.OnClickListener listener;
    String nombre= "";

    public List<Tareas> getProfesLista() {
        return TareasLista;
    }
    public void setTareasLista(List<Tareas> tareasLista) {
        TareasLista = tareasLista;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null) {
            listener.onClick(v);
        }
    }
    public RecViewAdaptTarea(List<Tareas> tareasLista) {
        Log.d("ListAdapter", "");
        this.TareasLista = tareasLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("onCreateView", "");
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea,parent,false);
        view.setOnClickListener(this);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("onBindView", "");
        Tareas t=TareasLista.get(position);
        String nombre = t.getNombreObjeto() + " " + "x" + t.getCantidadObjeto();
        holder.nombreObjeto.setText(nombre);//String NombreObjeto
        holder.horaE.setText(t.getHoraEntrega());
        //holder.fotoTarea.setImageResource(t.getIdFoto());//int idFoto,

        Resources res = holder.itemView.getContext().getResources();
        String variableValue = t.getIdFoto();
        holder.fotoTarea.setImageResource(res.getIdentifier(variableValue, "drawable", holder.itemView.getContext().getPackageName()));

        switch (t.getStatus()){
            case 0:
                holder.estadoT.setText("Estado: Empezada");
                break;
            case 1:
                holder.estadoT.setText("Estado: Entregada");
                break;
            case 2:
                holder.estadoT.setText("Entregada y Validada");
                break;
            case 3:
                holder.estadoT.setText("No entregada a Tiempo");
                break;
            case 4:
                holder.estadoT.setText("Finalizada");
        }

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Log.d("onAttached", "");
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public int getItemCount() {
        Log.d("getItemCount", "");
        return TareasLista.size();     }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    //-----------------------------------------------------------------------------------------
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombreObjeto,horaE,estadoT;
        ImageView fotoTarea;
        CardView cardtarea;

        public ViewHolder(View itemView){
            super(itemView);
            Log.d("PostViewHolder", "");
            nombreObjeto=(TextView)itemView.findViewById(R.id.nombreObj);
            fotoTarea=(ImageView)itemView.findViewById(R.id.imgObjeto);
            horaE=(TextView)itemView.findViewById(R.id.HoraEntregaTarea);
            estadoT=(TextView)itemView.findViewById(R.id.EstadoTarea);
            cardtarea=itemView.findViewById(R.id.carta);
        }
    }
//-----------------------------------------------------------------------------------------

    public void obtenerNombreAl(int idAlumno, Context c){
        RequestQueue requestQueue = Volley.newRequestQueue(c);

        String url="http://192.168.1.14:80/android_mysql/selectAlumno.php?id=" + idAlumno;
        StringRequest stringRequest = new StringRequest (Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray itemArray = new JSONArray(response);
                            nombre = itemArray.getJSONObject(0).getString("nombre");
                            //}
                        }
                        catch (JSONException e) {
                            Toast.makeText(c, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(c, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) ;
        int socketTimeout = 30000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        requestQueue.add(stringRequest);
    }
}