import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {
    static ArrayList<Musica> acervoGeral = new ArrayList<>();
    static Usuario usuarioLogado;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        popularDadosTeste();
        configurarUsuario();

        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro();
            processarMenu(opcao);
        } while (opcao != 0);
    }

    // Atendendo as novas classes do Checkpoint 4
    static void configurarUsuario() {
        System.out.println("=== Bem-vindo ao Streaming ===");
        boolean sucesso = false;

        while (!sucesso) {
            try {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Email (ex: usuario@servico): ");
                String email = scanner.nextLine();

                System.out.print("Tipo de conta (1-Free, 2-Premium): ");
                int tipo = lerInteiro();

                if (tipo == 2) {
                    System.out.print("Plano (Mensal/Anual): ");
                    String plano = scanner.nextLine();
                    
                    usuarioLogado = new UsuarioPremium(nome, email, plano);
                } else {
                    usuarioLogado = new UsuarioFree(nome, email);
                }

                sucesso = true;
                System.out.println("✅ Usuário configurado com sucesso!");

            } catch (IllegalArgumentException e) {

                System.out.println("❌ Erro nos dados: " + e.getMessage());
                System.out.println("Tente novamente.\n");
            }
        }
    }

    static void exibirMenu() {
        System.out.println("\n=== STREAMING - CHECKPOINT 4 ===");
        System.out.println("1. Cadastrar Música\n2. Listar Acervo\n3. Ouvir Música (Novo)");
        System.out.println("4. Criar Playlist\n5. Gerenciar Playlists\n0. Sair");
        System.out.print("Opção: ");
    }

    static void processarMenu(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarMusica();
            case 2 -> listarAcervo();
            case 3 -> ouvirMusica(); // Implementação polimorfismo
            case 4 -> {
                System.out.print("Nome da nova playlist: ");
                usuarioLogado.criarPlaylist(scanner.nextLine());
            }
            case 5 -> gerenciarPlaylists();
            case 0 -> System.out.println("Encerrando sistema...");
            default -> System.out.println("Opção inválida.");
        }
    }

    static void ouvirMusica() {
        listarAcervo();
        System.out.print("Escolha o número da música para ouvir: ");
        int idx = lerInteiro() - 1;
        if (idx >= 0 && idx < acervoGeral.size()) {
            // Implementação polimorfismo
            usuarioLogado.reproduzirMusica(acervoGeral.get(idx));
        }
    }

    static void cadastrarMusica() {
        try {
            System.out.print("Título: "); String t = scanner.nextLine();
            System.out.print("Artista: "); String a = scanner.nextLine();
            System.out.print("Duração (segundos): "); int d = lerInteiro();
            System.out.print("Gênero: "); String g = scanner.nextLine();

            acervoGeral.add(new Musica(t, a, d, g));
            System.out.println("Música adicionada ao acervo!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    static void listarAcervo() {
        System.out.println("\n--- ACERVO COMPLETO ---");
        for (int i = 0; i < acervoGeral.size(); i++) {
            System.out.print((i + 1) + ". ");
            acervoGeral.get(i).exibir();
        }
    }

    static void buscarMusica() {
        System.out.print("Pesquisar título ou artista: ");
        String busca = scanner.nextLine();
        for (Musica m : acervoGeral) {
            if (m.contemTitulo(busca) || m.contemArtista(busca)) {
                m.exibir();
            }
        }
    }

    static void gerenciarPlaylists() {
        usuarioLogado.listarPlaylists();
        if (usuarioLogado.getPlaylists().isEmpty()) return;

        System.out.print("Selecione o índice da playlist: ");
        Playlist p = usuarioLogado.getPlaylist(lerInteiro());

        if (p != null) {
            System.out.println("1. Adicionar do Acervo | 2. Ver Músicas | 0. Voltar");
            int subOp = lerInteiro();
            if (subOp == 1) {
                listarAcervo();
                System.out.print("Número da música: ");
                int mIdx = lerInteiro() - 1;
                if (mIdx >= 0 && mIdx < acervoGeral.size()) p.adicionarMusica(acervoGeral.get(mIdx));
            } else if (subOp == 2) {
                p.listarMusicas();
            }
        }
    }

    static int lerInteiro() {
        try { return Integer.parseInt(scanner.nextLine()); } catch (Exception e) { return -1; }
    }

    static void popularDadosTeste() {
        acervoGeral.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        acervoGeral.add(new Musica("Billie Jean", "Michael Jackson", 293, "Pop"));
    }
}