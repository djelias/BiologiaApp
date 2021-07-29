package com.example.biologiaapp.ui.taxonomia;

import com.google.gson.annotations.SerializedName;

public class Taxonomia {

    @SerializedName("nombreComun")
    private String nombreComun;

    @SerializedName("numVoucher")
    private String numVoucher;

    @SerializedName("colector")
    private String colector;

    @SerializedName("codigoEspecimen")
    private String codigoEspecimen;

    @SerializedName("caracteristicas")
    private String carcateristicas;

    @SerializedName("latitud")
    private String latitud;

    @SerializedName("longitud")
    private String longitud;

    @SerializedName("habitat")
    private String habitat;

    @SerializedName("nombreEspecie")
    private String nombreEspecie;

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNumVoucher() {
        return numVoucher;
    }

    public void setNumVoucher(String numVoucher) {
        this.numVoucher = numVoucher;
    }

    public String getColector() {
        return colector;
    }

    public void setColector(String colector) {
        this.colector = colector;
    }

    public String getCodigoEspecimen() {
        return codigoEspecimen;
    }

    public void setCodigoEspecimen(String codigoEspecimen) {
        this.codigoEspecimen = codigoEspecimen;
    }

    public String getCarcateristicas() {
        return carcateristicas;
    }

    public void setCarcateristicas(String carcateristicas) {
        this.carcateristicas = carcateristicas;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }
}
