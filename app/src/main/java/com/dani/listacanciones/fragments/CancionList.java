package com.dani.listacanciones.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.dani.listacanciones.interfaces.iComunicaFragments;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dani.listacanciones.R;
import com.dani.listacanciones.adapter.CancionListAdapter;
import com.dani.listacanciones.model.Cancion;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CancionList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CancionList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    iComunicaFragments iMuscia;
    private ListView lvCanciones;
    private CancionListAdapter adaptador;
    private ArrayList<Cancion> cancionesList = new ArrayList<>();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CancionList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CancionList.
     */
    // TODO: Rename and change types and number of parameters
    public static CancionList newInstance(String param1, String param2) {
        CancionList fragment = new CancionList();
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

        View view = inflater.inflate(R.layout.fragment_cancion_list, container, false);
        // 2 - A partir de este view vamos a obtener todos los views del Fragment
        lvCanciones = view.findViewById(R.id.Cancion_listView);
        // 3 - Traemos el resto de codigo del MainActivity
        cancionesList.add(new Cancion("Walls", "Que bien te quedaba", "https://images.genius.com/55eb8f1811436cccc179582019d33241.1000x1000x1.jpg", R.raw.sinmas));
        cancionesList.add(new Cancion("Babi, Miranda", "Lo sabía", "https://images.genius.com/2c6775acc747cf8413b13d15d74483f0.1000x1000x1.jpg", R.raw.sinmas));

        cancionesList.add(new Cancion("One Republic", "Counting stars", "https://m.media-amazon.com/images/I/812bZtstsBL._SS500_.jpg", R.raw.sinmas));
        cancionesList.add(new Cancion("Passenger", "Let her go", "https://m.media-amazon.com/images/I/818mfPpYxdL._SS500_.jpg", R.raw.sinmas));

        cancionesList.add(new Cancion("Walls", "Complicao", "https://images.genius.com/a2755733709366c1896d3f807ca750ad.1000x1000x1.png", R.raw.sinmas));
        cancionesList.add(new Cancion("Nadal015", "Invictus", "https://i.scdn.co/image/ab67616d0000b2734743720c985d6156b6e336f7", R.raw.sinmas));

        cancionesList.add(new Cancion("Shawn Mendes", "Stitches", "https://i.scdn.co/image/ab67616d0000b273908f7df282edee5f2be63121", R.raw.sinmas));
        cancionesList.add(new Cancion("Alec Benjamin", "Swim", "https://i.scdn.co/image/ab67616d0000b273459d675aa0b6f3b211357370", R.raw.sinmas));

        cancionesList.add(new Cancion("Swit eme", "Breakdown", "https://lite-images-i.scdn.co/image/ab67616d0000b2739ec9601c5c3bd1b8dd03d3c5", R.raw.sinmas));
        cancionesList.add(new Cancion("Babi", "Cocaina", "https://i.scdn.co/image/ab67616d0000b273d8adae0a0e0e788506a0841b", R.raw.sinmas));

        adaptador = new CancionListAdapter(getActivity(),cancionesList,R.id.item);

        lvCanciones.setAdapter(adaptador);

        lvCanciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Cancion selectedCancion = (Cancion) adaptador.getItem(i);

                if (selectedCancion != null) {
                    if (iMuscia != null) {

                    iMuscia.enviarCancion(selectedCancion);
                    iMuscia.cambioLayout();
                    }

                }
            }


        });

        return view;



    }



}