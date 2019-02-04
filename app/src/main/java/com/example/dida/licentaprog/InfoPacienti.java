package com.example.dida.licentaprog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class InfoPacienti extends AppCompatActivity {

    private String Nnume;
    private String Nprenume;
    private String Nvarsta;
    private String Nsex;
    private String Ninaltime;
    private String Ngreutate;
    private String Ntelefon;
    private String Nmail;



    public InfoPacienti(){

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public String getNume() {
        return Nnume;
    }

    public void setNume(String nume) {
        this.Nnume = Nnume;
    }

    public String getPrenume() {
        return Nprenume;
    }

    public void setPrenume(String prenume) {
        this.Nprenume = Nprenume;
    }

    public String getVarsta() {
        return Nvarsta;
    }

    public void setVarsta(String varsta) {
        this.Nvarsta = Nvarsta;
    }

    public String getSex() {
        return Nsex;
    }

    public void setSex(String sex) {
        this.Nsex = Nsex;
    }

    public String getInaltime() {
        return Ninaltime;
    }

    public void setInaltime(String inaltime) {
        this.Ninaltime = Ninaltime;
    }

    public String getGreutate() {
        return Ngreutate;
    }

    public void setGreutate(String greutate) {
        this.Ngreutate = Ngreutate;
    }

    public String getTelefon() {return Ntelefon;}

    public void setTelefoane(String telefoane) {
        this.Ntelefon = Ntelefon;
    }

    public String getMail() {return Nmail;}

    public void setMail(String mail) {
        this.Nmail = Nmail;
    }



}
