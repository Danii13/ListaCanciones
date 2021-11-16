package com.dani.listacanciones.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dani.listacanciones.R;
import com.dani.listacanciones.model.Cancion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CancionListAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Cancion> musicList;
    private int layoutId;


    public CancionListAdapter(Context context, ArrayList<Cancion> musicList, int layoutId) {
        this.context = context;
        this.musicList = musicList;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return musicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Cancion cancion = (Cancion) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item, null);
        TextView cancionTituloTv = view.findViewById(R.id.textViewTitulo);
        ImageView cancionImage = view.findViewById(R.id.imageViewCancion);
        TextView cancionArtistaTv = view.findViewById(R.id.textViewArtista);

        //llenamos los elementos de la lista
        cancionArtistaTv.setText(cancion.getAutor());
        cancionTituloTv.setText(cancion.getTitulo());
        //Picasso.get().load(cancion.getImageUrl()).into(cancionImage);
        //cancionImage.setImageResource(R.drawable.quebien);
        Glide.with(view).load(cancion.getImageUrl()).into(cancionImage);




        return view;
    }



}