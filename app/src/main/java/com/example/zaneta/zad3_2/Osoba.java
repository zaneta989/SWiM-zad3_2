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
    public Osoba(String p)
    {
        String [] d=new String [7];
        if(p == null) return;
        int curr = p.indexOf('$');
        int i = 0;
        while (curr != -1)
        {
            d[i] = p.substring(0, curr);
            p = p.substring(curr+1);
            ++i;
            curr = p.indexOf('$');
        }
        czyKobieta=d[0];
        imieN=d[1];
        masaCiala=d[2];
        wiek=d[3];
        wzrost=d[4];
        aktywnoscFizyczna=d[5];
        planuje=d[6];
    }
    public String toString()
    {
        return czyKobieta+"$"+imieN+"$"+masaCiala+"$"+wiek+"$"+wzrost+"$"+aktywnoscFizyczna+"$"+planuje+"$";
    }
    public String getImieN()
    {
        return imieN;
    }
    public String getWiek()
    {
        return wiek;
    }
    public String getPlec()
    {
        return czyKobieta;
    }
    public String getMasaCiala()
    {
        return masaCiala;
    }
    public String getWzrost()
    {
        return wzrost;
    }
    public String getAktywnoscFizyczna()
    {
        return aktywnoscFizyczna;
    }
    public String getPlanuje()
    {
        return planuje;
    }

}
