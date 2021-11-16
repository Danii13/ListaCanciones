package com.dani.listacanciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dani.listacanciones.fragments.DetailFragment;
import com.dani.listacanciones.model.Cancion;
import com.dani.listacanciones.interfaces.iComunicaFragments;

public class MainActivity extends AppCompatActivity implements iComunicaFragments{
    DetailFragment detailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void enviarCancion(Cancion cancion){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.cancion_list_fragment);
        detailFragment.playSong(cancion.getSoundId());

    }
}