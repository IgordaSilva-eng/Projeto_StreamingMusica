import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {
    static ArrayList<Musica> acervo = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        popularDados();
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE STREAMING ===");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Login");
            System.out.println("3. Listar usuários");
            System.out.println("4. Estatísticas do Sistema");
            System.out.println("0. Sair");
            System.out.print("\nEscolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> criarUsuario();
                case 2 -> realizarLogin();
                case 3 -> listarUsuarios();
                case 4 -> exibirEstatisticas();
            }
        } while (opcao != 0);
    }

    public static void criarUsuario() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.println("1. Free | 2. Premium");
        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            usuarios.add(new UsuarioFree(nome, email));
        } else {
            System.out.print("Plano (Mensal/Anual/Familiar): ");
            usuarios.add(new UsuarioPremium(nome, email, scanner.nextLine()));
        }
        System.out.println("✅ Usuário criado!");
    }

    public static void listarUsuarios() {
        System.out.println("\nUsuários cadastrados:");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            // Uso de instanceof para determinar o tipo na listagem
            String tipo = (u instanceof UsuarioPremium) ? "Premium" : "Free";
            System.out.println((i + 1) + ". " + u.getNome() + " (" + tipo + ")");
        }
    }

    public static void realizarLogin() {
        listarUsuarios();
        System.out.print("\nEscolha o usuário: ");
        int id = Integer.parseInt(scanner.nextLine()) - 1;

        if (id >= 0 && id < usuarios.size()) {
            usuarioLogado = usuarios.get(id);
            String tipo = (usuarioLogado instanceof UsuarioPremium) ? "Premium" : "Free";
            System.out.println("✅ Login realizado: " + usuarioLogado.getNome() + " (" + tipo + ")");
            menuPlayer();
        } else {
            System.out.println("❌ Usuário inválido.");
        }
    }

    static void menuPlayer() {
        while (usuarioLogado != null) {
            System.out.println("\n--- MENU DE " + usuarioLogado.getNome().toUpperCase() + " ---");
            System.out.println("1. Ouvir Música");
            System.out.println("2. Gerar Playlist Automática");
            System.out.println("0. Logout");
            System.out.print("Escolha: ");
            int op = Integer.parseInt(scanner.nextLine());

            if (op == 1) {
                // Simulação de ouvir uma música do acervo para gerar dados para estatísticas
                usuarioLogado.reproduzirMusica(acervo.get(0));
            } else if (op == 2) {
                gerarPlaylistAutomatica();
            } else if (op == 0) {
                usuarioLogado = null;
            }
        }
    }

    static void gerarPlaylistAutomatica() {
        System.out.println("\n=== PLAYLISTS AUTOMÁTICAS ===");
        System.out.println("1. Top 10 Mais Tocadas");
        System.out.println("2. Recomendadas para Você");
        System.out.println("3. Adicionadas Recentemente");
        System.out.print("\nEscolha: ");
        int op = Integer.parseInt(scanner.nextLine());

        String titulo = "";
        String crit = "";
        if (op == 1) { titulo = "Top 10 Mais Tocadas"; crit = "top"; }
        else if (op == 2) { titulo = "Recomendadas para Você"; crit = "recomendadas"; }
        else if (op == 3) { titulo = "Adicionadas Recentemente"; crit = "recentes"; }
        else return;

        System.out.println("🤖 Gerando playlist \"" + titulo + "\"...");
        PlaylistAutomatica pa = new PlaylistAutomatica(titulo, crit);
        pa.atualizar(acervo);
        usuarioLogado.getPlaylists().add(pa);
        System.out.println("✅ Playlist criada com " + pa.getMusicas().size() + " músicas!");
    }

    static void exibirEstatisticas() {
        int freeUsers = 0, premiumUsers = 0;
        int freeRep = 0, premiumRep = 0;

        // Varrendo a lista polimórfica com instanceof
        for (Usuario u : usuarios) {
            if (u instanceof UsuarioPremium) {
                premiumUsers++;
                premiumRep += u.getTotalReproducoes();
            } else if (u instanceof UsuarioFree) {
                freeUsers++;
                freeRep += u.getTotalReproducoes();
            }
        }

        int totalUsers = usuarios.size();
        int totalRep = freeRep + premiumRep;

        // Evitando divisão por zero no cálculo da porcentagem
        int pctFree = (totalRep == 0) ? 0 : (freeRep * 100) / totalRep;
        int pctPremium = (totalRep == 0) ? 0 : (premiumRep * 100) / totalRep;

        System.out.println("\n=== ESTATÍSTICAS DO SISTEMA ===");
        System.out.println("Total de usuários: " + totalUsers);
        System.out.println("- Free: " + freeUsers + " usuários");
        System.out.println("- Premium: " + premiumUsers + " usuários");

        System.out.println("\nReproduções totais: " + totalRep);
        System.out.println("- Free: " + freeRep + " reproduções (" + pctFree + "%)");
        System.out.println("- Premium: " + premiumRep + " reproduções (" + pctPremium + "%)");

        System.out.println("\nAnúncios exibidos: " + UsuarioFree.totalAnunciosGlobais);
    }

    static void popularDados() {
        // População de dados para facilitar os testes iniciais e reproduzir o exemplo do PDF
        acervo.add(new Musica("Spoken For", "Flavor Foley", 244, "Pop"));
        acervo.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        acervo.add(new Musica("Billie Jean", "Michael Jackson", 293, "Pop"));

        usuarios.add(new UsuarioFree("Juliano", "juliano@email.com"));
        usuarios.add(new UsuarioPremium("Igor", "igor@email.com", "Anual"));
        usuarios.add(new UsuarioFree("Gabryel", "gabryel@email.com"));
    }
}