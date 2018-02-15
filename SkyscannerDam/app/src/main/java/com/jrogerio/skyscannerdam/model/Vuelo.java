package com.jrogerio.skyscannerdam.model;

/**
 * Created by jrogerio on 15/02/18.
 */

public class Vuelo {

    private String origen;
    private String destino;
    private String horaSalida;
    private double duracion;
    private double precio;
    private String urlFoto;

    public Vuelo(String origen, String destino, String horaSalida, double duracion, double precio, String urlFoto) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
        this.precio = precio;
        this.urlFoto = urlFoto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vuelo vuelo = (Vuelo) o;

        if (Double.compare(vuelo.duracion, duracion) != 0) return false;
        if (Double.compare(vuelo.precio, precio) != 0) return false;
        if (origen != null ? !origen.equals(vuelo.origen) : vuelo.origen != null) return false;
        if (destino != null ? !destino.equals(vuelo.destino) : vuelo.destino != null) return false;
        if (horaSalida != null ? !horaSalida.equals(vuelo.horaSalida) : vuelo.horaSalida != null)
            return false;
        return urlFoto != null ? urlFoto.equals(vuelo.urlFoto) : vuelo.urlFoto == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = origen != null ? origen.hashCode() : 0;
        result = 31 * result + (destino != null ? destino.hashCode() : 0);
        result = 31 * result + (horaSalida != null ? horaSalida.hashCode() : 0);
        temp = Double.doubleToLongBits(duracion);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (urlFoto != null ? urlFoto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", duracion=" + duracion +
                ", precio=" + precio +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
