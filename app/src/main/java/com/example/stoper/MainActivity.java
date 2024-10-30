package com.example.stoper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewCzas;
    TextView textViewZapisanyCzas;
    Button buttonStart;
    Button buttonPauza;
    Button buttonReset;
    Button buttonZapisz;
    int sekundy = 0;
    String czasDoWyswietlenia;
    String zapisaneCzasy = "Zapisane czasy: ";
    boolean czyDziala = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCzas = findViewById(R.id.textViewCzas);
        textViewZapisanyCzas = findViewById(R.id.textView);
        buttonPauza = findViewById(R.id.button2);
        buttonReset = findViewById(R.id.button3);
        buttonStart = findViewById(R.id.button);
        buttonZapisz = findViewById(R.id.button4);
        idzieCzas();
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sekundy = 0;
                    }
                }
        );

        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDziala = true;
                    }
                }
        );
        buttonPauza.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDziala = false;
                    }
                }
        );
        buttonZapisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zapisaneCzasy = zapisaneCzasy+ czasDoWyswietlenia+"\n";
                        textViewZapisanyCzas.setText(zapisaneCzasy);
                    }
                }
        );

    }

    private void idzieCzas(){
        int s60, m60, h60;
        Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if(czyDziala) {
                            sekundy++;
                            int h = sekundy / 3600;
                            int s60 = sekundy % 60;
                            int m60 = (sekundy - h * 3600) / 60;
                            czasDoWyswietlenia = String.format("%02d:%02d:%02d", h, m60, s60);
                            textViewCzas.setText(String.valueOf(czasDoWyswietlenia));
                        }
                            handler.postDelayed(this, 1000);
                    }
                }
        );
    }


}