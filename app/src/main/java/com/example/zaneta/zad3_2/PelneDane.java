package com.example.zaneta.zad3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PelneDane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelne_dane);
        Intent i = getIntent();
        Bundle dane = i.getExtras();


        TextView czyKobieta = (TextView) findViewById(R.id.textView2);
        czyKobieta.setText(dane.getString("czyKobieta"));

        TextView imieN = (TextView) findViewById(R.id.textView5);
        imieN.setText(dane.getString("imieN"));

        TextView masaC = (TextView) findViewById(R.id.textView9);
        masaC.setText(dane.getString("masaCiala"));

        TextView wiek = (TextView) findViewById(R.id.textView7);
        wiek.setText(dane.getString("wiek"));

        TextView wzrost = (TextView) findViewById(R.id.textView10);
        wzrost.setText(dane.getString("wzrost"));

        TextView akt = (TextView) findViewById(R.id.textView14);
        akt.setText(dane.getString("aktywnoscFizyczna"));

        TextView planuje = (TextView) findViewById(R.id.textView15);
        planuje.setText(dane.getString("planuje"));


    }
}
