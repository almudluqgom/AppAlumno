package info.androidhive.sqlite.helper.model;

import java.io.Serializable;

public class Profesor implements Serializable {

    String idProfesor;
    String NombreApell;
    int IDFoto;


    boolean Admin;

    public Profesor(){}
    public Profesor(Profesor p){
        this.idProfesor = p.idProfesor;
        this.NombreApell = p.NombreApell;
        this.IDFoto = p.IDFoto;
        this.Admin = p.isAdmin();
    }
    public Profesor(String idProfesor, String nombreApell, int IDFoto, boolean admin) {
        this.idProfesor = idProfesor;
        this.NombreApell = nombreApell;
        this.IDFoto = IDFoto;
        this.Admin = admin;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }
    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreApell() {
        return NombreApell;
    }

    public void setNombreApell(String nombreApell) {
        NombreApell = nombreApell;
    }

    public int getIDFoto() {
        return IDFoto;
    }

    public void setIDFoto(int IDFoto) {
        this.IDFoto = IDFoto;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", NombreProf='" + NombreApell + '\'' +
                ", IDFoto='" + IDFoto + '\'' +
                '}';
    }
}
