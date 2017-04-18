package com.example.zaneta.zad3_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PelneDane extends AppCompatActivity {

    SharedPreferences dane;
    String nazwa_plikuS="ustawienia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelne_dane);
        dane=getSharedPreferences(nazwa_plikuS, MODE_PRIVATE);
        Intent i = getIntent();
        Bundle dane = i.getExtras();


        TextView czyKobieta = (TextView) findViewById(R.id.textView2);
        czyKobieta.setText(dane.getString("czyKobieta"));
        czyKobieta.setTextSize(dane.getInt("wielkosc",12));

        TextView imieN = (TextView) findViewById(R.id.textView5);
        imieN.setText(dane.getString("imieN"));
        imieN.setTextSize(dane.getInt("wielkosc",12));

        TextView masaC = (TextView) findViewById(R.id.textView9);
        masaC.setText(dane.getString("masaCiala"));
        masaC.setTextSize(dane.getInt("wielkosc",12));

        TextView wiek = (TextView) findViewById(R.id.textView7);
        wiek.setText(dane.getString("wiek"));
        wiek.setTextSize(dane.getInt("wielkosc",12));

        TextView wzrost = (TextView) findViewById(R.id.textView10);
        wzrost.setText(dane.getString("wzrost"));
        wzrost.setTextSize(dane.getInt("wielkosc",12));

        TextView akt = (TextView) findViewById(R.id.textView14);
        akt.setText(dane.getString("aktywnoscFizyczna"));
        akt.setTextSize(dane.getInt("wielkosc",12));

        TextView planuje = (TextView) findViewById(R.id.textView15);
        planuje.setText(dane.getString("planuje"));
        planuje.setTextSize(dane.getInt("wielkosc",12));


    }
    protected void onStart()
    {
        super.onStart();
        TextView tekst = (TextView) findViewById(R.id.textView6);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView40);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView30);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView11);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView3);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView8);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView12);
        tekst.setTextSize(dane.getInt("wielkosc",12));
    }
}
