package com.dani.listacanciones.model;

public class Cancion {

    private String autor;
    private String titulo;
    private String imageUrl;
    private int soundId;

    public Cancion(String autor, String titulo, String imageUrl, int soundId) {
        this.autor = autor;
        this.titulo = titulo;
        this.imageUrl = imageUrl;
        this.soundId = soundId;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }
}
