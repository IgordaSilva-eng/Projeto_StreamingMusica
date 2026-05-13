package br.com.streaming.modelo;

import br.com.streaming.util.FormatadorTempo;

public class Musica extends ItemReproducao {
    private String artista;
    private int duracaoSegundos;
    private String genero;

    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        super(titulo);
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.genero = genero;
    }

    @Override
    public void reproduzir() { System.out.println("▶ Reproduzindo: " + titulo + " - " + artista); }

    @Override
    public void pausar() { System.out.println("⏸ Música '" + titulo + "' pausada."); }

    @Override
    public void parar() { System.out.println("⏹ Reprodução de '" + titulo + "' encerrada."); }

    @Override
    public int getDuracaoTotal() { return duracaoSegundos; }

    public void exibir() {
        String tempo = FormatadorTempo.formatarSegundos(duracaoSegundos);
        System.out.printf("🎵 %s | Artista: %s | Duração: %s | Gênero: %s%n", titulo, artista, tempo, genero);
    }
}