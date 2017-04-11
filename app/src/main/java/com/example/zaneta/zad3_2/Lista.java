package com.example.zaneta.zad3_2;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    String[] listaI ;
    String [] listaW;
    String [] pl;
    List <Osoba>listaO = new ArrayList<Osoba>();
    String nazwa_pliku = "daneOs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        odczytajZPliku(nazwa_pliku);
        zapiszDoListy();
        myAdapter adapter = new myAdapter();
        ListView lista3 = (ListView) findViewById(R.id.listView1);
        lista3.setAdapter(adapter);
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
        listaI=new String[listaO.size()];
        listaW=new String[listaO.size()];
        pl=new String[listaO.size()];
        Osoba os;
        for (int i=0; i<listaO.size(); i++)
        {
            os=listaO.get(i);
            listaI[i]=os.getImieN();
            listaW[i]=os.getWiek()+ " lat";
            pl[i]=os.getPlec();

        }
    }
    public class myAdapter extends BaseAdapter {
        private LayoutInflater inflater = null;
        public int getCount() {
            return listaI.length;
        }
        public Object getItem(int position) {
            return position;
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int poss, View cView, ViewGroup parent) {
            View mV;
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (cView == null) {
                cView = inflater.inflate(R.layout.list_row, null);
            }
            mV = cView;
            TextView tv1 = (TextView) mV.findViewById(R.id.row_tv1);
            tv1.setText(listaI[poss]);
            TextView tv2 = (TextView) mV.findViewById(R.id.row_tv2);
            tv2.setText(listaW[poss]);
            ImageView img = (ImageView) mV.findViewById(R.id.row_image);
            if (pl[poss].equals("Kobieta"))  img.setImageResource(R.drawable.img1);

            return mV;
        }
    }
}
