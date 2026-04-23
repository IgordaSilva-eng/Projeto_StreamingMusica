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
        // Se o valor for nulo ou apenas espaços, vira "Pop" por padrão
        if (genero == null || genero.trim().isEmpty()) {
            this.genero = "Pop";
        } else {
            this.genero = genero.trim();
        }
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("O artista da música é obrigatório.");
        }
        this.artista = artista.trim();
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título da música é obrigatório.");
        }
        this.titulo = titulo.trim();
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getDuracaoSegundos() {
        return this.duracaoSegundos;
    }

    public void exibir() {
        System.out.println("🎵 " + this.titulo + " | Artista: " + this.artista +
                " | Duração: " + this.getDuracaoFormatada() +
                " | Gênero: " + this.genero);
    }

    public String getDuracaoFormatada() {
        int minutos = this.duracaoSegundos / 60;
        int segundos = this.duracaoSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public boolean contemTitulo(String busca) {
        return this.titulo.toLowerCase().contains(busca.toLowerCase());
    }

    public boolean contemArtista(String busca) {
        return this.artista.toLowerCase().contains(busca.toLowerCase());
    }
}

