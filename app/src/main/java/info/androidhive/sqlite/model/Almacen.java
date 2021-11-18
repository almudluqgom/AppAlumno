package info.androidhive.sqlite.model;

public class Almacen {
    int cantidad;
    String descripcion;
    String idFoto;

    Almacen(){}

    Almacen(int c, String d, String f){
        this.cantidad=c;
        this.descripcion=d;
        this.idFoto=f;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                ", cantidad=" + cantidad +
                ", descripcion='" + descripcion + '\'' +
                ", idFoto='" + idFoto + '\'' +
                '}';
    }
}
