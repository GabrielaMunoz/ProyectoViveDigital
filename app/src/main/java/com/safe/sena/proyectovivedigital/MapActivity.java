package com.safe.sena.proyectovivedigital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.safe.sena.proyectovivedigital.api.Api;
import com.safe.sena.proyectovivedigital.models.PuntoViveDigital;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<PuntoViveDigital> puntos;
    private Retrofit retrofit;
    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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
                    puntos = new ArrayList<PuntoViveDigital>();
                    puntos.addAll(puntosResultado);

                    //mapFragment.getMapAsync(this);
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {

                            LatLng camera = null;
                            for (int i = 0 ; i < puntos.size() ; i ++) {
                                PuntoViveDigital p = puntos.get(i);
                                LatLng pos = new LatLng(new Double(p.getCoordenadas_pvd_validadas().getCoordinates().get(1)), new Double(p.getCoordenadas_pvd_validadas().getCoordinates().get(0)));
                                if(camera == null){
                                    camera = pos;
                                }
                                googleMap.addMarker(new MarkerOptions().title(p.getDirecci_n_pvd()).position(pos));
                            }
                            if(camera != null) {
                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(camera, 15));
                            }
                            googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext() , "Error cargando los datos", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<List<PuntoViveDigital>> call, Throwable t) {
                Toast.makeText(getApplicationContext() , "Error cargando los datos: "+ t.getMessage(), Toast.LENGTH_LONG);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
