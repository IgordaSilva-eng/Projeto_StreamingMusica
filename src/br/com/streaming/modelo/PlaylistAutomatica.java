package br.com.streaming.modelo;

import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {
    private String criterio;

    public PlaylistAutomatica(String nome, String criterio) {
        super(nome);
        this.criterio = criterio;
    }

    public void atualizar(ArrayList<Musica> todasMusicas) {
        musicas.clear();
        if (criterio.equals("top")) {
            todasMusicas.stream().limit(10).forEach(this::adicionarMusica);
        } else if (criterio.equals("recomendadas")) {
            todasMusicas.stream().limit(2).forEach(this::adicionarMusica);
        } else if (criterio.equals("recentes") && !todasMusicas.isEmpty()) {
            adicionarMusica(todasMusicas.get(todasMusicas.size() - 1));
        }
    }
}