import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {
    private String criterio;

    public PlaylistAutomatica(String nome, String criterio) {
        super(nome);
        this.criterio = criterio;
        this.descricao = "Gerada automaticamente pelo sistema";
    }

    @Override
    public void reproduzir() {
        System.out.println("\n🤖 Playlist Automática: " + nome);
        System.out.println("📊 Critério: " + criterio);
        super.reproduzir();
    }

    public void atualizar(ArrayList<Musica> todasMusicas) {
        musicas.clear();

        if (criterio.equals("top")) {
            // Adicionar músicas mais tocadas (Simulação: Limita a 10 músicas)
            todasMusicas.stream().limit(10).forEach(this::adicionarMusica);

        } else if (criterio.equals("recomendadas")) {
            // Adicionar músicas recomendadas (Simulação: Adiciona as 2 primeiras)
            todasMusicas.stream().limit(2).forEach(this::adicionarMusica);

        } else if (criterio.equals("recentes") && !todasMusicas.isEmpty()) {
            // Pega a última adicionada
            adicionarMusica(todasMusicas.get(todasMusicas.size() - 1));
        }
    }
}