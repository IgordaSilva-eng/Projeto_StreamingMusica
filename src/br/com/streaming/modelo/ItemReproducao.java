package br.com.streaming.modelo;

import br.com.streaming.servico.Reproduzivel;

public abstract class ItemReproducao implements Reproduzivel {
    protected String titulo;
    protected int totalCurtidas;

    public ItemReproducao(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() { return titulo; }
    public void curtir() { this.totalCurtidas++; }
    public int getTotalCurtidas() { return totalCurtidas; }
}