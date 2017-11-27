package com.safe.sena.proyectovivedigital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.safe.sena.proyectovivedigital.adapters.ListaViveDigitalAdapter;
import com.safe.sena.proyectovivedigital.api.Api;
import com.safe.sena.proyectovivedigital.models.PuntoViveDigital;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {

    public static final String TAG = "PUNTO_VIVE_DIGITAL";
    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaViveDigitalAdapter listaPuntosViveDigital;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaPuntosViveDigital = new ListaViveDigitalAdapter(this);
        recyclerView.setAdapter(listaPuntosViveDigital);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
    }

    private void obtenerDatos() {
        Api service = retrofit.create(Api.class);
        Call<List<PuntoViveDigital>> generoRespuestaCall = service.obtenerListaGenero();

        generoRespuestaCall.enqueue(new Callback<List<PuntoViveDigital>>() {
            @Override
            public void onResponse(Call<List<PuntoViveDigital>> call, Response<List<PuntoViveDigital>> response) {
                if (response.isSuccessful()) {

                    ArrayList<PuntoViveDigital> puntosResultado = (ArrayList<PuntoViveDigital>) response.body();
                    listaPuntosViveDigital.adicionarListaPokemon(puntosResultado);

                } else {
                    Toast.makeText(getApplicationContext() , "Error cargando los datos", Toast.LENGTH_LONG);
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<PuntoViveDigital>> call, Throwable t) {
                Toast.makeText(getApplicationContext() , "Error cargando los datos: "+ t.getMessage(), Toast.LENGTH_LONG);
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }
}
