import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {
    static ArrayList<Musica> acervoGeral = new ArrayList<>();
    static Usuario usuario = new Usuario("Usuario Exemplo");
    static Scanner scanner = new Scanner(System.in);
    static final String[] GENEROS_VALIDOS = {"Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica"};

    public static void main(String[] args) {
        popularDadosTeste();
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerInteiro();
            processarMenu(opcao);
        } while (opcao != 0);
    }

    static void exibirMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE STREAMING DE MÚSICA ===");
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar todas as músicas");
        System.out.println("3. Buscar música");
        System.out.println("4. Criar playlist");
        System.out.println("5. Gerenciar playlists");
        System.out.println("6. Exibir estatísticas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void processarMenu(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarMusica();
            case 2 -> listarAcervo();
            case 3 -> buscarMusica();
            case 4 -> {
                System.out.print("Nome da playlist: ");
                usuario.criarPlaylist(scanner.nextLine());
            }
            case 5 -> gerenciarPlaylists();
            case 6 -> exibirEstatisticas();
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opção inválida.");
        }
    }

    // --- MÉTODOS DE APOIO ---

    static void cadastrarMusica() {
        System.out.print("Título: "); String t = scanner.nextLine();
        System.out.print("Artista: "); String a = scanner.nextLine();
        System.out.print("Duração (seg): "); int d = lerInteiro();
        System.out.print("Gênero: "); String g = scanner.nextLine();
        acervoGeral.add(new Musica(t, a, d, g));
    }

    static void listarAcervo() {
        System.out.println("\n--- ACERVO GERAL ---");
        for (int i = 0; i < acervoGeral.size(); i++) {
            System.out.print((i + 1) + ". ");
            acervoGeral.get(i).exibir();
        }
    }

    static void buscarMusica() {
        System.out.print("Digite o termo de busca (Título ou Artista): ");
        String busca = scanner.nextLine().trim();
        for (Musica m : acervoGeral) {
            if (m.contemTitulo(busca) || m.contemArtista(busca)) {
                m.exibir();
            }
        }
    }

    static void gerenciarPlaylists() {
        System.out.println("\n=== GERENCIAR PLAYLISTS ===");
        usuario.listarPlaylists();
        if (usuario.playlists.isEmpty()) return;

        System.out.print("Escolha o número da playlist (ou 0 para voltar): ");
        int idx = lerInteiro() - 1;
        Playlist p = usuario.getPlaylist(idx);

        if (p != null) {
            System.out.println("1. Adicionar música | 2. Remover música | 3. Ver detalhes | 0. Voltar");
            int subOp = lerInteiro();
            if (subOp == 1) {
                listarAcervo();
                System.out.print("Número da música do acervo: ");
                int mIdx = lerInteiro() - 1;
                if (mIdx >= 0 && mIdx < acervoGeral.size()) p.adicionarMusica(acervoGeral.get(mIdx));
            } else if (subOp == 2) {
                p.listarMusicas();
                System.out.print("Número da música para remover: ");
                p.removerMusica(lerInteiro() - 1);
            } else if (subOp == 3) {
                p.listarMusicas();
            }
        }
    }

    static void exibirEstatisticas() {
        if (acervoGeral.isEmpty()) return;
        int totalDuracao = 0;
        for (Musica m : acervoGeral) totalDuracao += m.duracaoSegundos;
        System.out.println("Total de músicas no acervo: " + acervoGeral.size());
        System.out.println("Duração média: " + (totalDuracao / acervoGeral.size()) + " segundos.");
    }

    static int lerInteiro() {
        try {
            int n = Integer.parseInt(scanner.nextLine());
            return n;
        } catch (Exception e) { return -1; }
    }

    static void popularDadosTeste() {
        acervoGeral.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        acervoGeral.add(new Musica("Billie Jean", "Michael Jackson", 293, "Pop"));
        acervoGeral.add(new Musica("Smells Like Teen Spirit", "Nirvana", 301, "Rock"));
    }
}