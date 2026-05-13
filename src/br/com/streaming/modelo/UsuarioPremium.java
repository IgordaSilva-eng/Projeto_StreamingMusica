package br.com.streaming.modelo;

import br.com.streaming.servico.Baixavel;
import java.util.ArrayList;
import java.util.List;

public final class UsuarioPremium extends Usuario implements Baixavel {
    private String plano;
    private List<Musica> musicasBaixadas = new ArrayList<>();

    public UsuarioPremium(String nome, String email, String plano) {
        super(nome, email);
        this.plano = plano;
    }

    @Override
    public void baixar(Musica musica) {
        if (!estaBaixada(musica)) {
            musicasBaixadas.add(musica);
            System.out.println("⬇️ Música '" + musica.getTitulo() + "' baixada!");
        }
    }

    @Override
    public void removerDownload(Musica musica) { musicasBaixadas.remove(musica); }
    @Override
    public boolean estaBaixada(Musica musica) { return musicasBaixadas.contains(musica); }
    @Override
    public int getTamanhoBaixados() { return musicasBaixadas.size(); }

    @Override
    public void reproduzirMusica(Musica musica) {
        System.out.print("💎 [HIFI] ");
        super.reproduzirMusica(musica);
    }
}