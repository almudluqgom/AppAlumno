package info.androidhive.sqlite.model;

public class Alumno {

    String NombreApell;
    String IDFoto;
    int TareasCompletas,TareasSinHacer,TareasEntregadas;
    int GotasAgua, EstatusMaceta;

    public Alumno(){};

    public Alumno(String nombreApell, String IDFoto, int tareasCompletas, int tareasSinHacer, int tareasEntregadas, int gotasAgua, int estatusMaceta) {

        NombreApell = nombreApell;
        this.IDFoto = IDFoto;
        TareasCompletas = tareasCompletas;
        TareasSinHacer = tareasSinHacer;
        TareasEntregadas = tareasEntregadas;
        GotasAgua = gotasAgua;
        EstatusMaceta = estatusMaceta;
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
