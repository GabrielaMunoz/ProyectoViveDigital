package com.safe.sena.proyectovivedigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final ProgressBar pg = (ProgressBar)findViewById(R.id.progress_bar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int increment = 0;
                    while(increment <= 100 ) {
                        Thread.sleep(50);
                        increment++;
                        pg.setProgress(increment);
                    }
                    goTo();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void goTo(){
        Intent i = new Intent(this, Bienvenida.class);
        startActivity(i);
    }

}
