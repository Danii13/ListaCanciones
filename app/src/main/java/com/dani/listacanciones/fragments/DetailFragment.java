package com.dani.listacanciones.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.dani.listacanciones.interfaces.iComunicaFragments;
import com.bumptech.glide.Glide;
import com.dani.listacanciones.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageView detailImageView;

    iComunicaFragments iMuscia;

    private ImageView imagenDtl;
    private TextView tituloDtl;
    public TextView artistaDtl;
    private Button btnVolver;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iMuscia = (iComunicaFragments) context;
    }

    public void seAllThings(String imageUrl, String titulo, String artista){
        Glide.with(this).load(imageUrl).into(detailImageView);
        artistaDtl.setText(artista);
        tituloDtl.setText(titulo);

    }

    public void playSong(int SongID){
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), SongID);

        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        detailImageView = (ImageView) view.findViewById(R.id.imageViewDetail);


        imagenDtl = (ImageView) view.findViewById(R.id.imageViewDetail);
        artistaDtl = view.findViewById(R.id.tvArtistaDrl);
        tituloDtl = view.findViewById(R.id.tvTituloDrl);
        btnVolver = view.findViewById(R.id.btnBack);

        btnVolver.setOnClickListener(view1 -> {
            iMuscia.volver();
        });

        return view;





    }
}