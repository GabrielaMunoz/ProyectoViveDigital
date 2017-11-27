package com.safe.sena.proyectovivedigital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Bienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
    }

    public void calculoMasa(View view) {
        Intent i = new Intent(this, ViveDigitalMain.class );
        startActivity(i);
    }
}
