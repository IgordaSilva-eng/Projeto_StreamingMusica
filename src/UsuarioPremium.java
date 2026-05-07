public final class UsuarioPremium extends Usuario {
    private String plano;

    public UsuarioPremium(String nome, String email, String plano) {
        super(nome, email);
        this.plano = plano;
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        System.out.print("💎 [HIFI] ");
        super.reproduzirMusica(musica);
    }

    public String getPlano() { return plano; }
}