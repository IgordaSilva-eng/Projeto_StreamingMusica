import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Playlist> playlists = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void criarPlaylist(String nomePlaylist) {
        Playlist novaPlaylist = new Playlist(nomePlaylist);
        this.playlists.add(novaPlaylist);
        System.out.println("Nova playlist '" + nomePlaylist + "' vinculada ao usuário " + this.nome);
    }

    public Playlist getPlaylist(int indice) {
        if (indice >= 0 && indice < this.playlists.size()) {
            return this.playlists.get(indice);
        }
        return null;
    }

    public void listarPlaylists() {
        System.out.println("\n--- Playlists de " + this.nome + " ---");
        for (int i = 0; i < this.playlists.size(); i++) {
            System.out.println("[" + i + "] " + this.playlists.get(i).nome);
        }
    }
}