import java.util.ArrayList;

public class Usuario {
    protected String nome;
    protected String email;
    protected ArrayList<Musica> historicoReproducao = new ArrayList<>();
    protected ArrayList<Playlist> playlists = new ArrayList<>();

    public Usuario(String nome, String email) {
        setNome(nome);
        setEmail(email);

        this.playlists = new ArrayList<>();
        this.historicoReproducao = new ArrayList<>();
    }
    public void reproduzirMusica(Musica musica){
        System.out.println("Reproduzindo Musica: " + musica.getTitulo());
        historicoReproducao.add(musica);
    }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório.");
        }
        this.nome = nome.trim();
    }

    public void setEmail(String email){
        if (email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("O email não pode ser nulo");
        }

        // Verifica o formato (deve conter '@' e não pode ser apenas o '@')
        if (!email.contains("@") || email.trim().equals("@")) {
            throw new IllegalArgumentException("Formato de e-mail inválido. O e-mail deve conter '@', por exemplo: email@serviço.");
        }
        this.email = email.trim();
    }

    public void criarPlaylist(String nomePlaylist) {
        try {
            this.playlists.add(new Playlist(nomePlaylist));
            System.out.println("✅ Playlist '" + nomePlaylist + "' criada com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }

    public Playlist getPlaylist(int indice) {
        if (indice >= 0 && indice < playlists.size()) {
            return playlists.get(indice);
        }
        return null;
    }

    public void listarPlaylists() {
        System.out.println("\n--- Suas Playlists (" + nome + ") ---");
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println("[" + i + "] " + playlists.get(i).getNome());
        }
    }

    public ArrayList<Playlist> getPlaylists() { return playlists; }
}