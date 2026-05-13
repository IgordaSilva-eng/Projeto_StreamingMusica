package br.com.streaming.modelo;

import java.util.ArrayList;

public class Playlist extends ItemReproducao {
    protected ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) { super(nome); }

    public void adicionarMusica(Musica m) { if (m != null) musicas.add(m); }
    public ArrayList<Musica> getMusicas() { return musicas; }

    @Override
    public void reproduzir() {
        System.out.println("🎵 Iniciando Playlist: " + titulo);
        musicas.forEach(Musica::reproduzir);
    }

    @Override
    public void pausar() { System.out.println("⏸ Playlist '" + titulo + "' em pausa."); }

    @Override
    public void parar() { System.out.println("⏹ Playlist '" + titulo + "' parada."); }

    @Override
    public int getDuracaoTotal() {
        return musicas.stream().mapToInt(Musica::getDuracaoTotal).sum();
    }
}