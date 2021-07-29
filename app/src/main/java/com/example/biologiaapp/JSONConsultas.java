package com.example.biologiaapp;

import com.example.biologiaapp.ui.coleccion.Coleccion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONConsultas {
    @GET("coleccion")
    Call<List<Coleccion>> getColeccion();
}
