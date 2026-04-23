public class UsuarioFree extends Usuario {
    private static final int MAX_PLAYLISTS = 3;
    private int contadorReproducoes = 0;

    public UsuarioFree(String nome, String email) {
        super(nome, email); // Chama o construtor da superclasse
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorReproducoes++;
        // Lógica de anúncio a cada 3 músicas
        if (contadorReproducoes % 3 == 0) {
            System.out.println("\nANÚNCIO: Assine Premium e ouça sem interrupções!");
        }
        super.reproduzirMusica(musica); // Reutiliza o método do pai
    }
}