import java.util.ArrayList;

public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public void removerMusica(int indice) {
        if (indice >= 0 && indice < this.musicas.size()) {
            this.musicas.remove(indice);
        } else {
            System.out.println("Erro: Índice de música inválido.");
        }
    }

    public void listarMusicas() {
        System.out.println("\n--- Músicas da Playlist: " + this.nome + " ---");
        for (Musica m : this.musicas) {
            m.exibir();
        }
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : this.musicas) {
            total += m.duracaoSegundos;
        }
        return total;
    }

    public int getQuantidadeMusicas() {
        return this.musicas.size();
    }
}