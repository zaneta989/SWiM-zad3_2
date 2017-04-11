package com.example.zaneta.zad3_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaProsta extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String[] lista ;
    List <Osoba>listaO = new ArrayList<Osoba>();
    String nazwa_pliku = "daneOs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prosta);

        odczytajZPliku(nazwa_pliku);
        zapiszDoListy();
        ListView lista1 = (ListView) findViewById(R.id.listView2);
        lista1.setOnItemClickListener(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        lista1.setAdapter(adapter2);
    }
    private void odczytajZPliku(String nazwa)
    {
        FileInputStream daneZapisane;
        try {
            daneZapisane = openFileInput(nazwa);
            byte[] input = new byte[daneZapisane.available()];
            while (daneZapisane.read(input) != -1) {

                listaO.add(new Osoba(new String(input)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void zapiszDoListy()
    {
        lista=new String[listaO.size()];
        Osoba os;
        for (int i=0; i<listaO.size(); i++)
        {
            os=listaO.get(i);
            lista[i]=os.getImieN()+", "+os.getWiek()+" lat";
        }
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //Toast.makeText(this.getApplicationContext(), lista[position], Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, PelneDane.class);
        i.putExtras(pobierzDane(listaO.get(position)));
        startActivityForResult(i, 123);
    }
    public Bundle pobierzDane(Osoba os)
    {
        Bundle dane = new Bundle();
        dane.putString("czyKobieta", os.getPlec());
        dane.putString("imieN",  os.getImieN());
        dane.putString("masaCiala",  os.getMasaCiala());
        dane.putString("wiek", os.getWiek());
        dane.putString("wzrost",  os.getWzrost());
        dane.putString("aktywnoscFizyczna", os.getAktywnoscFizyczna());
        dane.putString("planuje",  os.getPlanuje());
        return dane;
    }
}
