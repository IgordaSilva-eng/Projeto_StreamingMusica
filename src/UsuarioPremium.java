import java.util.ArrayList;

public class UsuarioPremium extends Usuario {
    private String plano;
    private ArrayList<Musica> musicasBaixadas = new ArrayList<>();
    public UsuarioPremium(String nome, String email, String plano) {
        super(nome, email);
        this.plano = plano;
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        // Polimorfismo adicionado
        System.out.println("🎵 Reproduzindo em ALTA QUALIDADE: " + musica.getTitulo());
        historicoReproducao.add(musica);
    }

    public void baixarMusica(Musica musica) {
        musicasBaixadas.add(musica);
        System.out.println("⬇️ Música baixada: " + musica.getTitulo());
    }
}


