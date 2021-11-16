package com.dani.listacanciones.interfaces;

import com.dani.listacanciones.model.Cancion;

public interface iComunicaFragments {
    public void enviarCancion(Cancion cancion);
    public void cambioLayout();
    public void volver();
}
