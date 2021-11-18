package info.androidhive.sqlite.model;

import android.database.Cursor;

public class Tareas {
    int idProfe, idAlumno, idObjeto, idFoto;
    String HoraEntrega, Comentario;
    boolean ConfirmaAlumno, ConfirmaProfesor;
    int status, cantidadObjeto;

    public Tareas(){}

    public Tareas( int idFoto, int idAlumno,int idProfe, int idObjeto,  String horaEntrega, String comentario, int cantidadObjeto, boolean confirmaAlumno, boolean confirmaProfesor, int status) {
        this.idFoto = idFoto;
        this.idAlumno = idAlumno;
        this.idProfe = idProfe;
        this.idObjeto = idObjeto;
        this.HoraEntrega = horaEntrega;
        this.Comentario = comentario;
        this.cantidadObjeto = cantidadObjeto;
        this.ConfirmaAlumno = confirmaAlumno;
        this.ConfirmaProfesor = confirmaProfesor;
        this.status = status;
    }

    public int getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(int idProfe) {
        this.idProfe = idProfe;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getHoraEntrega() {
        return HoraEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        HoraEntrega = horaEntrega;
    }

    public boolean isConfirmaAlumno() {
        return ConfirmaAlumno;
    }

    public void setConfirmaAlumno(boolean confirmaAlumno) {
        ConfirmaAlumno = confirmaAlumno;
    }

    public boolean isConfirmaProfesor() {
        return ConfirmaProfesor;
    }

    public void setConfirmaProfesor(boolean confirmaProfesor) {
        ConfirmaProfesor = confirmaProfesor;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCantidadObjeto() {
        return cantidadObjeto;
    }

    public void setCantidadObjeto(int cantidadObjeto) {
        this.cantidadObjeto = cantidadObjeto;
    }

    public int getIdFoto() {        return idFoto;    }

    public void setIdFoto(int idFoto) {       this.idFoto = idFoto;    }

    @Override
    public String toString() {
        return "Tareas{" +
                "idProfe=" + idProfe +
                ", idAlumno=" + idAlumno +
                ", idObjeto=" + idObjeto +
                ", idFoto=" + idFoto +
                ", HoraEntrega='" + HoraEntrega + '\'' +
                ", Comentario='" + Comentario + '\'' +
                ", ConfirmaAlumno=" + ConfirmaAlumno +
                ", ConfirmaProfesor=" + ConfirmaProfesor +
                ", status=" + status +
                ", cantidadObjeto=" + cantidadObjeto +
                '}';
    }
}
