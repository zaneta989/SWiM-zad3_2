package com.example.zaneta.zad3_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences dane;
    String nazwa_pliku="ustawienia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dane=getSharedPreferences(nazwa_pliku, MODE_PRIVATE);
        //TextView tekst_powitalny= (TextView) findViewById(R.id.textView);
        //tekst_powitalny.setText(dane.getString("tekst_powitalny",""));

    }
    public void wlaczUstawienia(View view) {
        final Intent intencja2 = new Intent(this,Ustawienia.class);
        startActivity(intencja2);
    }
    public void wlaczWprowadzanie(View view) {
        final Intent intencja2 = new Intent(this,Wprowadzanie.class);
        startActivity(intencja2);
    }
    public void wlaczListe(View view) {
        final Intent intencja2 = new Intent(this,Lista.class);
        startActivity(intencja2);
    }
    public void wlaczListeP(View view) {
        final Intent intencja2 = new Intent(this,ListaProsta.class);
        startActivity(intencja2);
    }
    protected void onStart()
    {
        super.onStart();
        TextView tekst_powitalny= (TextView) findViewById(R.id.textView);
        tekst_powitalny.setText(dane.getString("tekst_powitalny",""));
        tekst_powitalny.setTextSize(dane.getInt("wielkosc",12));
    }


}
