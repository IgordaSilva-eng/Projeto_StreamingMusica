public class Musica {
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        setGenero(genero);
    }

    public void setGenero(String genero) {
        this.genero = (genero == null || genero.trim().isEmpty()) ? "Pop" : genero.trim();
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) throw new IllegalArgumentException("Artista obrigatório.");
        this.artista = artista.trim();
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) throw new IllegalArgumentException("Título obrigatório.");
        this.titulo = titulo.trim();
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0) throw new IllegalArgumentException("Duração inválida.");
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() { return titulo; }
    public int getDuracaoSegundos() { return duracaoSegundos; }

    public void exibir() {
        System.out.printf("🎵 %s | Artista: %s | Gênero: %s%n", titulo, artista, genero);
    }
}