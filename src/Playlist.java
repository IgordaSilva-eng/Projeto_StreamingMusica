import java.util.ArrayList;

public class Playlist {
    protected String nome;
    protected ArrayList<Musica> musicas = new ArrayList<>();
    protected String descricao;

    public Playlist(String nome) {
        setNome(nome);
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome inválido.");
        this.nome = nome.trim();
    }

    public String getNome() { return nome; }

    public void adicionarMusica(Musica m) {
        if (m != null) musicas.add(m);
    }

    public void reproduzir() {
        System.out.println("🎵 Reproduzindo playlist: " + nome);
        for (Musica m : musicas) {
            System.out.println("  ▶ " + m.getTitulo());
        }
    }
}