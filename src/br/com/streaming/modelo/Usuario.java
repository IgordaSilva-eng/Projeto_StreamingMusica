package br.com.streaming.modelo;

import java.util.ArrayList;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected ArrayList<Playlist> playlists = new ArrayList<>();
    protected int totalReproducoes = 0;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void reproduzirMusica(Musica m) {
        m.exibir();
        m.reproduzir();
        totalReproducoes++;
    }

    public void criarPlaylist(String nome) { playlists.add(new Playlist(nome)); }
    public String getNome() { return nome; }
    public ArrayList<Playlist> getPlaylists() { return playlists; }
}