package com.safe.sena.proyectovivedigital.api;

import com.safe.sena.proyectovivedigital.models.PuntoViveDigital;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    public static final String URL_BASE = "https://www.datos.gov.co/resource/";

    @GET("eu8q-tixz.json")
    Call<List<PuntoViveDigital>> obtenerListaGenero();
}
