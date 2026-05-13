package br.com.streaming.servico;

import br.com.streaming.modelo.Musica;
import br.com.streaming.modelo.Usuario;
import br.com.streaming.modelo.UsuarioPremium;
import java.util.ArrayList;

public class GeradorRecomendacoes {

    public void filtrar(Reproduzivel reproduzivel) {

        if (reproduzivel.getDuracaoTotal() > 300) {
            System.out.println("🎧 [DESTAQUE] Esta é uma das favoritas da crítica no momento!");
        } else {
            System.out.println("🎵 [SUGESTÃO] Ótima opção para ouvir agora!");
        }
    }

    public void recomendarPara(Usuario usuario, ArrayList<Musica> acervo) {
        System.out.println("\n [RECOMENDAÇÃO] Olá, " + usuario.getNome() + "!");
        if (usuario instanceof UsuarioPremium) {
            System.out.println(" Como você é Premium, aqui está uma seleção exclusiva.");
        }

        if (!acervo.isEmpty()) {
            System.out.println("Que tal ouvir: " + acervo.get(0).getTitulo() + "?");
        }
    }
}