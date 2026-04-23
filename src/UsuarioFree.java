public class UsuarioFree extends Usuario {
    // Constante de limite
    private static final int MAX_PLAYLISTS = 3;
    private int contadorReproducoes = 0;

    public UsuarioFree(String nome, String email) {
        super(nome, email);
    }

    // Lógica de limite na criação de playlist
    public void criarPlaylist(String nome) {
        if (playlists.size() >= MAX_PLAYLISTS) {
            System.out.println("❌ Limite de playlists atingido!");
            System.out.println("💎 Assine Premium para playlists ilimitadas!");
            return;
        }

        Playlist playlist = new Playlist(nome);
        playlists.add(playlist);
        System.out.println("✅ Playlist criada!");
    }

    // Método privado de anúncio formatado
    private void exibirAnuncio() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ANÚNCIO: Assine Premium e ouça sem interrupções!");
        System.out.println("=".repeat(50) + "\n");
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorReproducoes++;
        if (contadorReproducoes % 3 == 0) {
            exibirAnuncio(); // Chamar o método novo
        }
        super.reproduzirMusica(musica);
    }
}