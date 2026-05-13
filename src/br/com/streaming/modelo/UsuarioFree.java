package br.com.streaming.modelo;

public class UsuarioFree extends Usuario {
    public static int totalAnunciosGlobais = 0;

    public UsuarioFree(String nome, String email) { super(nome, email); }

    @Override
    public void reproduzirMusica(Musica musica) {

        if (totalReproducoes > 0 && totalReproducoes % 3 == 0) {
            System.out.println("\n📢 [ANÚNCIO] Assine o Premium para pular anúncios!");
            totalAnunciosGlobais++;
        }
        super.reproduzirMusica(musica);
    }
}