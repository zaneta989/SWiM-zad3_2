package com.example.zaneta.zad3_2;

import android.widget.SeekBar;

/**
 * Created by zaneta on 10.04.2017.
 */

public class Osoba {
    String czyKobieta ;
    String imieN;
    String masaCiala;
    String wiek;
    String wzrost;
    String aktywnoscFizyczna;
    String planuje;
    public Osoba(String k, String i, String m, String w, String wz, String a, String p)
    {
        czyKobieta=k;
        imieN=i;
        masaCiala=m;
        wiek=w;
        wzrost=wz;
        aktywnoscFizyczna=a;
        planuje=p;
    }

    public String toString()
    {
        return czyKobieta+"$"+imieN+"$"+masaCiala+"$"+wiek+"$"+wzrost+"$"+aktywnoscFizyczna+"$"+planuje;
    }

}
