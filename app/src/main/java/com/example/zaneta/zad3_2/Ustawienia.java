package com.example.zaneta.zad3_2;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Ustawienia extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    SharedPreferences dane;
    String nazwa_pliku="ustawienia";
    String[] tP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);

       dane=getSharedPreferences(nazwa_pliku, MODE_PRIVATE);

        Spinner opcje = (Spinner) findViewById(R.id.opcje_tekstu_p);
        Resources res = getResources();
        tP = res.getStringArray(R.array.opcje_wyboru);
        opcje.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this, R.array.opcje_wyboru, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opcje.setAdapter(adap);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        SharedPreferences.Editor edytor = dane.edit();
        edytor.putString("tekst_powitalny", tP[position]);
        edytor.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void zapisz( View view)
    {
        EditText wielkosc = (EditText) findViewById(R.id.editText3);

        SharedPreferences.Editor edytor = dane.edit();
        edytor.putInt("wielkosc", Integer.valueOf(wielkosc.getText().toString()));
        edytor.commit();

        TextView tekst = (TextView) findViewById(R.id.textView16);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView13);
        tekst.setTextSize(dane.getInt("wielkosc",12));
    }
    protected void onStart()
    {
        super.onStart();
        TextView tekst = (TextView) findViewById(R.id.textView16);
        tekst.setTextSize(dane.getInt("wielkosc",12));
        tekst = (TextView) findViewById(R.id.textView13);
        tekst.setTextSize(dane.getInt("wielkosc",12));
    }
    }
