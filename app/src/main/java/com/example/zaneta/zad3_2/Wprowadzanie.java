package com.example.zaneta.zad3_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Wprowadzanie extends AppCompatActivity {

    String nazwa_pliku = "daneOs.txt";
    FileOutputStream daneZapisane;
    SharedPreferences dane;
    String nazwa_plikuS="ustawienia";
    Writer out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprowadzanie);

        dane=getSharedPreferences(nazwa_plikuS, MODE_PRIVATE);
    }
    public void zapisz1( View view)
    {
        ToggleButton czyKobieta = (ToggleButton) findViewById(R.id.toggleButton);
        EditText imieN = (EditText) findViewById(R.id.editText30);
        EditText masaCiala = (EditText) findViewById(R.id.editText11);
        EditText wiek = (EditText) findViewById(R.id.editText2);
        EditText wzrost = (EditText) findViewById(R.id.editText);
        SeekBar aktywnoscFizyczna = (SeekBar) findViewById(R.id.seekBar);
        RadioGroup planuje = (RadioGroup) findViewById(R.id.radioGroup);


        String czyKobieta_string = czyKobieta.getText().toString();
        String imieN_string = imieN.getText().toString();
        String masaCiala_string = masaCiala.getText().toString();
        String wiek_string = wiek.getText().toString();
        String wzrost_string = wzrost.getText().toString();
        String aktF_string = (String) (Integer.toString(aktywnoscFizyczna.getProgress())+"/4");
        String planuje_string = (String) ((RadioButton) findViewById(planuje.getCheckedRadioButtonId())).getText();
       Osoba os= new Osoba(czyKobieta_string, imieN_string, masaCiala_string, wiek_string, wzrost_string, aktF_string, planuje_string);
        //String od=czyKobieta_string+imieN_string+ masaCiala_string+ wiek_string+wzrost_string+ aktywnoscFizyczna+planuje_string;
        try {
            daneZapisane = openFileOutput(nazwa_pliku, Context.MODE_PRIVATE);
            daneZapisane.write(os.toString().getBytes());
            daneZapisane.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void powrot(View view) { onBackPressed();}

}
