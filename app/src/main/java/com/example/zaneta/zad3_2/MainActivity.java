package com.example.zaneta.zad3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
