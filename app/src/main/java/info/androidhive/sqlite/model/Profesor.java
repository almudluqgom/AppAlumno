package info.androidhive.sqlite.model;

public class Profesor {

    int idProfesor;
    String NombreApell;
    String IDFoto;

    public Profesor(){}
    public Profesor(int idProfesor, String nombreApell, String IDFoto) {
        this.idProfesor = idProfesor;
        NombreApell = nombreApell;
        this.IDFoto = IDFoto;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreApell() {
        return NombreApell;
    }

    public void setNombreApell(String nombreApell) {
        NombreApell = nombreApell;
    }

    public String getIDFoto() {
        return IDFoto;
    }

    public void setIDFoto(String IDFoto) {
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
