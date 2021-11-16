package com.dani.listacanciones.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        cancionesList.add(new Cancion("Walls", "Que bien te quedaba", "https://cdn.alfabetajuega.com/wp-content/uploads/2020/03/bulbasaur-pok%C3%A9mon.png", R.raw.sinmas));
        cancionesList.add(new Cancion("Gines", "Que bien te quedaba", "https://images.genius.com/55eb8f1811436cccc179582019d33241.1000x1000x1.jpg", R.raw.sinmas));

        adaptador = new CancionListAdapter(getActivity(),cancionesList,R.id.item);

        lvCanciones.setAdapter(adaptador);


        return view;
    }
}