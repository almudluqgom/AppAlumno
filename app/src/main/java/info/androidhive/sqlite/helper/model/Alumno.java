package info.androidhive.sqlite.helper.model;

import java.io.Serializable;

public class Alumno implements Serializable {

    String idAlumno;
    String NombreApell;
    int IDFoto;
    int TareasCompletas,TareasSinHacer,TareasEntregadas;
    int GotasAgua, EstatusMaceta;

    public Alumno(){}

    public Alumno(Alumno a){
        this.idAlumno = a.getIdAlumno();
        this.NombreApell = a.getNombreApell();
        this.IDFoto = a.getIDFoto();
        this.TareasCompletas = a.getTareasCompletas();
        this.TareasSinHacer = a.getTareasSinHacer();
        this.TareasEntregadas = a.getTareasEntregadas();
        this.GotasAgua = a.getGotasAgua();
        this.EstatusMaceta = a.getEstatusMaceta();
    }
    public Alumno(String idAl, String nombreApell, int IDFoto, int tareasCompletas, int tareasSinHacer,
                  int tareasEntregadas, int gotasAgua, int estatusMaceta) {
        this.idAlumno = idAl;
        this.NombreApell = nombreApell;
        this.IDFoto = IDFoto;
        this.TareasCompletas = tareasCompletas;
        this.TareasSinHacer = tareasSinHacer;
        this.TareasEntregadas = tareasEntregadas;
        this.GotasAgua = gotasAgua;
        this.EstatusMaceta = estatusMaceta;
    }
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
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

    public int getTareasCompletas() {
        return TareasCompletas;
    }

    public void setTareasCompletas(int tareasCompletas) {
        TareasCompletas = tareasCompletas;
    }

    public int getTareasSinHacer() {
        return TareasSinHacer;
    }

    public void setTareasSinHacer(int tareasSinHacer) {
        TareasSinHacer = tareasSinHacer;
    }

    public int getTareasEntregadas() {
        return TareasEntregadas;
    }

    public void setTareasEntregadas(int tareasEntregadas) {
        TareasEntregadas = tareasEntregadas;
    }

    public int getGotasAgua() {
        return GotasAgua;
    }

    public void setGotasAgua(int gotasAgua) {
        GotasAgua = gotasAgua;
    }

    public int getEstatusMaceta() {
        return EstatusMaceta;
    }

    public void setEstatusMaceta(int estatusMaceta) {
        EstatusMaceta = estatusMaceta;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                ", NombreProf='" + NombreApell + '\'' +
                ", IDFoto='" + IDFoto + '\'' +
                ", TareasCompletas=" + TareasCompletas +
                ", TareasSinHacer=" + TareasSinHacer +
                ", TareasEntregadas=" + TareasEntregadas +
                ", GotasAgua=" + GotasAgua +
                ", EstatusMaceta=" + EstatusMaceta +
                '}';
    }
}
