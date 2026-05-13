package br.com.streaming.principal;

import br.com.streaming.modelo.*;
import br.com.streaming.servico.*;
import br.com.streaming.util.Validador;
import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {
    static ArrayList<Musica> acervo = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);
    static GeradorRecomendacoes recomendador = new GeradorRecomendacoes();

    public static void main(String[] args) {
        popularDados();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== STREAMING MUSICA - CHECKPOINT FINAL ===");
            System.out.println("1. Cadastro | 2. Login | 3. Estatísticas | 0. Sair");
            System.out.print("Escolha: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> criarUsuario();
                    case 2 -> realizarLogin();
                    case 3 -> exibirEstatisticas();
                }
            } catch (Exception e) { System.err.println("Entrada inválida."); }
        }
    }

    public static void criarUsuario() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        if (!Validador.isEmailValido(email)) {
            System.out.println("❌ Email inválido!");
            return;
        }
        System.out.print("1. Free | 2. Premium: ");
        int tipo = Integer.parseInt(scanner.nextLine());
        if (tipo == 1) usuarios.add(new UsuarioFree(nome, email));
        else usuarios.add(new UsuarioPremium(nome, email, "Anual"));
        System.out.println("✅ Usuário cadastrado!");
    }

    public static void realizarLogin() {
        if (usuarios.isEmpty()) return;
        for (int i = 0; i < usuarios.size(); i++) System.out.println((i+1) + ". " + usuarios.get(i).getNome());
        System.out.print("Escolha o ID: ");
        int id = Integer.parseInt(scanner.nextLine()) - 1;
        if (id >= 0 && id < usuarios.size()) {
            usuarioLogado = usuarios.get(id);
            menuPlayer();
        }
    }

    static void menuPlayer() {
        while (usuarioLogado != null) {
            System.out.println("\n--- MENU DE " + usuarioLogado.getNome().toUpperCase() + " ---");
            recomendador.recomendarPara(usuarioLogado, acervo);

            System.out.println("\nOPÇÕES:");
            System.out.println("1. Ouvir | 2. Curtir | 3. Criar Playlist | 4. Ver minhas Playlists");

            if (usuarioLogado instanceof Baixavel) {
                System.out.println("5. Baixar | 6. Remover Download | 7. Ver total baixado");
            }

            System.out.println("0. Logout");
            System.out.print("Escolha: ");
            try {
                int op = Integer.parseInt(scanner.nextLine());
                Musica m = acervo.get(0);

                switch (op) {
                    case 1 -> {
                        usuarioLogado.reproduzirMusica(m);
                        recomendador.filtrar(m);
                    }
                    case 2 -> {
                        m.curtir();
                        System.out.println("❤️ Curtidas em '" + m.getTitulo() + "': " + m.getTotalCurtidas());
                    }
                    case 3 -> {
                        // Aplicação do método de criação de playlist
                        System.out.print("Nome da sua nova Playlist: ");
                        String nomeP = scanner.nextLine();
                        usuarioLogado.criarPlaylist(nomeP);
                        System.out.println("✅ Playlist '" + nomeP + "' criada com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("\n--- SUAS PLAYLISTS ---");
                        if (usuarioLogado.getPlaylists().isEmpty()) System.out.println("Você ainda não tem playlists.");
                        else usuarioLogado.getPlaylists().forEach(p -> System.out.println("- " + p.getTitulo()));
                    }
                    case 5 -> { if (usuarioLogado instanceof Baixavel b) b.baixar(m); }
                    case 6 -> { if (usuarioLogado instanceof Baixavel b) b.removerDownload(m); }
                    case 7 -> { if (usuarioLogado instanceof Baixavel b) System.out.println("📂 Total: " + b.getTamanhoBaixados()); }
                    case 0 -> usuarioLogado = null;
                }
            } catch (Exception e) { System.err.println("Opção inválida."); }
        }
    }

    static void popularDados() {
        acervo.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        acervo.add(new Musica("Spoken For", "Flavor Foley", 244, "Pop"));
    }

    static void exibirEstatisticas() {
        System.out.println("Total de Usuários: " + usuarios.size());
        System.out.println("Anúncios Globais (Free): " + UsuarioFree.totalAnunciosGlobais);
    }
}