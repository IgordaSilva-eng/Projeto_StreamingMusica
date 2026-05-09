import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {
    static ArrayList<Musica> acervo = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        popularDados();
        int opcao = -1;
        do {
            System.out.println("\n=== SISTEMA DE STREAMING ===");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Login");
            System.out.println("3. Listar usuários");
            System.out.println("4. Estatísticas do Sistema");
            System.out.println("0. Sair");
            System.out.print("\nEscolha: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> criarUsuario();
                    case 2 -> realizarLogin();
                    case 3 -> listarUsuarios();
                    case 4 -> exibirEstatisticas();
                }
            } catch (Exception e) {
                System.err.println("Erro: Entrada inválida.");
            }
        } while (opcao != 0);
    }

    public static void criarUsuario() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Email (deve conter @): "); String email = scanner.nextLine();
        System.out.println("1. Free | 2. Premium");
        try {
            int tipo = Integer.parseInt(scanner.nextLine());
            if (tipo == 1) {
                usuarios.add(new UsuarioFree(nome, email));
            } else {
                System.out.print("Plano (Mensal/Anual/Familiar): ");
                usuarios.add(new UsuarioPremium(nome, email, scanner.nextLine()));
            }
            System.out.println("✅ Usuário criado!");
        } catch (Exception e) {
            System.err.println("❌ Erro: " + e.getMessage());
        }
    }

    public static void listarUsuarios() {
        System.out.println("\nUsuários cadastrados:");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            String tipo = (u instanceof UsuarioPremium) ? "Premium" : "Free";
            System.out.println((i + 1) + ". " + u.getNome() + " (" + tipo + ")");
        }
    }

    public static void realizarLogin() {
        listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.print("\nEscolha o usuário: ");
        try {
            int id = Integer.parseInt(scanner.nextLine()) - 1;
            if (id >= 0 && id < usuarios.size()) {
                usuarioLogado = usuarios.get(id);
                System.out.println("✅ Login realizado!");
                menuPlayer();
            } else {
                System.out.println("❌ Usuário inválido.");
            }
        } catch (Exception e) { System.err.println("Entrada inválida."); }
    }

    static void menuPlayer() {
        while (usuarioLogado != null) {
            System.out.println("\n--- MENU DE " + usuarioLogado.getNome().toUpperCase() + " ---");
            System.out.println("1. Ouvir Música | 2. Gerar Playlist Automática | 0. Logout");
            System.out.print("Escolha: ");
            try {
                int op = Integer.parseInt(scanner.nextLine());
                if (op == 1) {
                    if (!acervo.isEmpty()) usuarioLogado.reproduzirMusica(acervo.get(0));
                    else System.out.println("Acervo vazio.");
                } else if (op == 2) {
                    gerarPlaylistAutomatica();
                } else if (op == 0) {
                    usuarioLogado = null;
                }
            } catch (Exception e) { System.err.println("Opção inválida."); }
        }
    }

    static void gerarPlaylistAutomatica() {
        System.out.println("\n1. Top 10 | 2. Recomendadas | 3. Recentes");
        System.out.print("Escolha: ");
        try {
            int op = Integer.parseInt(scanner.nextLine());
            String titulo = switch (op) {
                case 1 -> "Top 10";
                case 2 -> "Recomendadas";
                case 3 -> "Recentes";
                default -> null;
            };
            String crit = switch (op) {
                case 1 -> "top";
                case 2 -> "recomendadas";
                case 3 -> "recentes";
                default -> null;
            };

            if (titulo != null) {
                PlaylistAutomatica pa = new PlaylistAutomatica(titulo, crit);
                pa.atualizar(acervo);
                usuarioLogado.getPlaylists().add(pa);
                // LINHA CORRIGIDA COM O NOVO GETTER
                System.out.println("✅ Playlist criada com " + pa.getMusicas().size() + " músicas!");
            }
        } catch (Exception e) { System.err.println("Erro ao gerar playlist."); }
    }

    static void exibirEstatisticas() {
        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.println("Total Usuários: " + usuarios.size());
        System.out.println("Anúncios Globais: " + UsuarioFree.totalAnunciosGlobais);
    }

    static void popularDados() {
        acervo.add(new Musica("Spoken For", "Flavor Foley", 244, "Pop"));
        acervo.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        usuarios.add(new UsuarioFree("Juliano", "juliano@email.com"));
        usuarios.add(new UsuarioPremium("Igor", "igor@email.com", "Anual"));
    }
}