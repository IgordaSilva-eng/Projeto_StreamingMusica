public class Musica {
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

    // Lista de gêneros válidos para validação case-insensitive
    private static final String[] GENEROS_VALIDOS = {"Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica"};

    // Construtor Parametrizado (Inicialização Robustas)
    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        setGenero(genero);
    }

    // Sobrecarga de Construtor (Exemplo: Gênero padrão se não informado)
    public Musica(String titulo, String artista, int duracaoSegundos) {
        this(titulo, artista, duracaoSegundos, "Pop");
    }

    // --- GETTERS E SETTERS COM VALIDAÇÕES ---

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
        }
        this.titulo = titulo.trim();
    }

    public String getArtista() { return artista; }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("Artista não pode ser nulo ou vazio.");
        }
        this.artista = artista.trim();
    }

    public int getDuracaoSegundos() { return duracaoSegundos; }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0 || duracaoSegundos >= 3600) {
            throw new IllegalArgumentException("Duração deve ser entre 1 e 3599 segundos.");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getGenero() { return genero; }

    public void setGenero(String genero) {
        for (String g : GENEROS_VALIDOS) {
            if (g.equalsIgnoreCase(genero)) {
                this.genero = g; // Salva com a capitalização correta do array
                return;
            }
        }
        throw new IllegalArgumentException("Gênero inválido. Escolha entre: Pop, Rock, Jazz, Eletrônica, Hip-Hop ou Clássica.");
    }

    // --- MÉTODOS DE COMPORTAMENTO ---

    public void exibir() {
        System.out.printf("🎵 %s | Artista: %s | Duração: %s | Gênero: %s%n",
                titulo, artista, getDuracaoFormatada(), genero);
    }

    public String getDuracaoFormatada() {
        return String.format("%02d:%02d", duracaoSegundos / 60, duracaoSegundos % 60);
    }

    public boolean contemTitulo(String busca) {
        return titulo.toLowerCase().contains(busca.toLowerCase());
    }

    public boolean contemArtista(String busca) {
        return artista.toLowerCase().contains(busca.toLowerCase());
    }
}