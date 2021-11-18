package info.androidhive.sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import info.androidhive.sqlite.model.Alumno;
import info.androidhive.sqlite.model.Tareas;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "AppAgenda";

    // Table Names
    private static final String TABLE_ALMACEN = "ProductosAlmacen";
    private static final String TABLE_ALUMNOS = "Alumnos";
    private static final String TABLE_PROFESOR = "Profesores";
    private static final String TABLE_TAREAS = "Tareas";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_IDFOTO_NAME = "IDFoto";
    private static final String KEY_NOMBRE = "Nombre";

    // ALMACEN Table - column names
        private static final String KEY_CANTIDAD_NAME = "Cantidad";
        private static final String KEY_DESCRIPCION_NAME = "Descripcion";

    // ALUMNOS Table - column names
        private static final String KEY_TARCOMP_NAME = "TareasCompletas";
        private static final String KEY_TARSINH_NAME = "TareasSinHacer";
        private static final String KEY_TARENTR_NAME = "TareasEntregadas";
        private static final String KEY_GOTAS_NAME = "GotasRegar";
        private static final String KEY_STATUSM_NAME = "EstadoMaceta";
    // TAREAS Table - column names
        private static final String KEY_IDPR = "idProfesor";
        private static final String KEY_IDAL = "idAlumno";
        private static final String KEY_IDOB = "idObjeto";
        private static final String KEY_HORAE = "HoraEntrega";
        private static final String KEY_COMENT = "Comentario";
        private static final String KEY_CANTOBJ = "Cantidad";
        private static final String KEY_CONFAL = "ConfirmacionAlumno";
        private static final String KEY_CONFPR = "ConfirmacionProfesor";
        private static final String KEY_STATUS = "EstadoTarea";

    private static final String CREATE_TABLE_ALMACEN = "CREATE TABLE "
            + TABLE_ALMACEN + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NOMBRE + " TEXT,"
            + KEY_IDFOTO_NAME + " TEXT,"
            + KEY_CANTIDAD_NAME + " INTEGER,"
            + KEY_DESCRIPCION_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    private static final String CREATE_TABLE_ALUMNO = "CREATE TABLE "
            + TABLE_ALUMNOS + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NOMBRE + " TEXT,"
            + KEY_IDFOTO_NAME + " TEXT,"
            + KEY_TARCOMP_NAME + " INTEGER,"
            + KEY_TARSINH_NAME + " INTEGER,"
            + KEY_TARENTR_NAME + " INTEGER,"
            + KEY_GOTAS_NAME + " INTEGER,"
            + KEY_STATUSM_NAME + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    private static final String CREATE_TABLE_PROFESOR = "CREATE TABLE "
            + TABLE_PROFESOR + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NOMBRE + " TEXT,"
            + KEY_IDFOTO_NAME + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";
    private static final String CREATE_TABLE_TAREAS = "CREATE TABLE "
            + TABLE_TAREAS + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_IDFOTO_NAME + " TEXT,"
            + KEY_IDAL + " INTEGER,"
            + KEY_IDPR + " INTEGER,"
            + KEY_IDOB + " INTEGER,"
            + KEY_HORAE + " INTEGER,"
            + KEY_COMENT + "TEXT,"
            + KEY_CANTOBJ + " INTEGER,"
            + KEY_CONFAL + " INTEGER,"
            + KEY_CONFPR + " INTEGER,"
            + KEY_STATUS + " INTEGER,"
            + KEY_CREATED_AT  + " DATETIME" + ")";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALMACEN);
        db.execSQL(CREATE_TABLE_ALUMNO);
        db.execSQL(CREATE_TABLE_PROFESOR);
        db.execSQL(CREATE_TABLE_TAREAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALMACEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALUMNOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFESOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAREAS);

        // create new tables
        onCreate(db);
    }

    public ArrayList<String> getTareasAlumno (String idAlumno) {

        ArrayList<String> result = new ArrayList<String>();
        SQLiteDatabase BaseDeDatabase = this.getWritableDatabase();
        String IdA = "";

        Cursor idal = BaseDeDatabase.rawQuery
                ("select id from Tareas where idAlumno =" + idAlumno, null);
        try {
            if (idal.moveToFirst()) { // must check the result to prevent exception
                do {
                    for (int idx = 0; idx < idal.getColumnCount(); idx++) {
                        result.add(idal.getString(idx));
                    }
                } while (idal.moveToNext());
            }
        } finally {
            idal.close();
        }

        BaseDeDatabase.close();
        return result;
    }

     public String getNombreAlumno(String IdAlumno){
         SQLiteDatabase BaseDeDatabase = this.getWritableDatabase();
         String Nombre = "";

         Cursor profeCursor = BaseDeDatabase.rawQuery
                 ("select Nombre from Profesores where id=" + IdAlumno, null);
         try {
             if (profeCursor.moveToFirst())  // must check the result to prevent exception
                 Nombre =  profeCursor.getString(profeCursor.getColumnIndex(KEY_NOMBRE));
         } finally {
             profeCursor.close();
         }
         return Nombre;

     }

    public ArrayList<String> getListAlumnos() {

        ArrayList<String> result = new ArrayList<String>();
        SQLiteDatabase BaseDeDatabase = this.getWritableDatabase();
        Cursor fila = BaseDeDatabase.rawQuery
                ("select Nombre from Alumnos", null);


        if (fila.moveToFirst()) { // must check the result to prevent exception
            do {
                for (int idx = 0; idx < fila.getColumnCount(); idx++) {
                    result.add(fila.getString(idx));
                }
            } while (fila.moveToNext());
        }
        BaseDeDatabase.close();
        return result;
    }

    public Tareas getTarea (String idTarea){
        Tareas t = new Tareas();
        SQLiteDatabase BaseDeDatabase = this.getWritableDatabase();

        Cursor TareaCursor = BaseDeDatabase.rawQuery
                ("select * from Tareas where id= " + idTarea, null);
        try {
            if (TareaCursor.moveToFirst()) { // must check the result to prevent exception
                Boolean confal = false,
                confprof = false;
                if(TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_CONFAL)) == 1)
                    confal = true;
                if(TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_CONFPR)) == 1)
                    confprof = true;
                t = new Tareas(
                        TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_IDFOTO_NAME)),
                        TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_IDAL)),
                        TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_IDPR)),
                        TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_IDOB)),
                        TareaCursor.getString(TareaCursor.getColumnIndex(KEY_HORAE)),
                        TareaCursor.getString(TareaCursor.getColumnIndex(KEY_COMENT)),
                        TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_CANTOBJ)),
                        confal,
                        confprof,
                        TareaCursor.getInt(TareaCursor.getColumnIndex(KEY_STATUS))
                );
            }
        } finally {
           TareaCursor.close();
        }
        BaseDeDatabase.close();
        return t;
    }
    public void setTareaEntregada(Tareas t,String idTarea){
        SQLiteDatabase BaseDeDatabase = this.getWritableDatabase();

        ContentValues cv = createContentValues(t,2, true, t.isConfirmaProfesor());
        BaseDeDatabase.update(TABLE_TAREAS, cv, KEY_ID + " = ? " ,
                new String[]{String.valueOf(idTarea)});
    }

    public ContentValues createContentValues(Tareas t, int status,boolean al, boolean pr){
        ContentValues cv = new ContentValues();
        cv.put(KEY_IDFOTO_NAME,t.getIdFoto());
        cv.put(KEY_IDAL,t.getIdAlumno());
        cv.put(KEY_IDPR,t.getIdProfe());
        cv.put(KEY_IDOB,t.getIdObjeto() );
        cv.put(KEY_HORAE,t.getHoraEntrega());
        cv.put(KEY_COMENT,t.getComentario());
        cv.put(KEY_CANTOBJ,t.getCantidadObjeto());
        cv.put(KEY_CONFAL,al);
        cv.put(KEY_CONFPR,pr);
        cv.put(KEY_STATUS,status);

        return cv;
    }
}
