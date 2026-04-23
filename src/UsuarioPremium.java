import java.util.ArrayList;

public class UsuarioPremium extends Usuario {
    private String plano;
    private ArrayList<Musica> musicasBaixadas;

    public UsuarioPremium(String nome, String email, String plano) {
        super(nome, email);
        this.plano = plano;
        this.musicasBaixadas = new ArrayList<>();
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        // Comportamento exclusivo Premium
        System.out.println("🎵 Reproduzindo em ALTA QUALIDADE: " + musica.getTitulo());
        this.historicoReproducao.add(musica);
    }

    public void baixarMusica(Musica musica) {
        // Verificação de duplicidade antes de adicionar
        if (!musicasBaixadas.contains(musica)) {
            musicasBaixadas.add(musica);
            System.out.println("⬇️ Música baixada: " + musica.getTitulo());
        } else {
            System.out.println("ℹ️ Música já está baixada!");
        }
    }

    public void listarMusicasBaixadas() {
        System.out.println("\n--- MÚSICAS BAIXADAS ---");
        if (musicasBaixadas.isEmpty()) {
            System.out.println("Nenhuma música baixada.");
            return;
        }
        for (Musica m : musicasBaixadas) {
            m.exibir();
        }
    }
    public String getPlano() { return plano; }
    public void setPlano(String plano) { this.plano = plano; }
}