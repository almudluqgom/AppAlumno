package info.androidhive.sqlite.helper.model;

import java.io.Serializable;

public class Tareas implements Serializable {

    String NombreObjeto;
    int idTarea,idProfe,idAlumno, idObjeto, idFoto;
    String HoraEntrega, Comentario;
    boolean ConfirmaAlumno, ConfirmaProfesor;
    int status, cantidadObjeto;
    int idFotoFeedback;

    public Tareas(Tareas tareas){
        this.idTarea=tareas.getIdTarea();
        this.NombreObjeto= tareas.getNombreObjeto();
        this.idFoto = tareas.getIdFoto();
        this.idAlumno = tareas.getIdAlumno();
        this.idProfe = tareas.getIdProfe();
        this.idObjeto = tareas.getIdObjeto();
        this.HoraEntrega = tareas.getHoraEntrega();
        this.Comentario = tareas.getComentario();
        this.cantidadObjeto = tareas.getCantidadObjeto();
        this.ConfirmaAlumno = tareas.isConfirmaAlumno();
        this.ConfirmaProfesor = tareas.isConfirmaProfesor();
        this.status = tareas.getStatus();
        this.idFotoFeedback = tareas.getIdFotoFeedback();
    }

    public Tareas( int idTarea,String nombreObjeto,int idFoto,int idProfe, int idAlumno, int idObjeto,  String horaEntrega,
                   String comentario, int cantidadObjeto, boolean confirmaAlumno, boolean confirmaProfesor, int status, int idF) {
        this.idTarea=idTarea;
        this.NombreObjeto= nombreObjeto;
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
        this.idFotoFeedback = idF;
    }


    public int getIdFotoFeedback() {
        return idFotoFeedback;
    }

    public void setIdFotoFeedback(int idFotoFeedback) {
        this.idFotoFeedback = idFotoFeedback;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreObjeto() {
        return NombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        NombreObjeto = nombreObjeto;
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
