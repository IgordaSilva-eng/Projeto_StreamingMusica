import java.util.ArrayList;

public class Usuario {
    protected String nome;
    protected String email;
    protected ArrayList<Playlist> playlists = new ArrayList<>();
    protected int totalReproducoes = 0;

    public Usuario(String nome, String email) {
        this.nome = nome;
        validarEmail(email);
        this.email = email;
    }

    public final void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
    }

    public void reproduzirMusica(Musica m) {
        m.exibir();
        totalReproducoes++;
    }

    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome));
    }

    public String getNome() { return nome; }
    public ArrayList<Playlist> getPlaylists() { return playlists; }
    public int getTotalReproducoes() { return totalReproducoes; }
}