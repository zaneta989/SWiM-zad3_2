package com.example.zaneta.zad3_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import java.io.FileOutputStream;

public class Wprowadzanie extends AppCompatActivity {

    String nazwa_pliku = "daneOs";
    FileOutputStream daneZapisane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprowadzanie);
    }
    public void zapisz( View view)
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
        String aktF_string = Integer.toString(aktywnoscFizyczna.getProgress())+"/4";
        String planuje_string = (String) ((RadioButton) findViewById(planuje.getCheckedRadioButtonId())).getText();
       // Osoba os= new Osoba(czyKobieta_string, imieN_string, masaCiala_string, wiek_string, wzrost_string, aktywnoscFizyczna, planuje_string);
        String od=czyKobieta_string+imieN_string+ masaCiala_string+ wiek_string+wzrost_string+ aktywnoscFizyczna+planuje_string;
        try {
            daneZapisane = openFileOutput(nazwa_pliku, Context.MODE_PRIVATE);
            daneZapisane.write(od.getBytes());
            daneZapisane.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
