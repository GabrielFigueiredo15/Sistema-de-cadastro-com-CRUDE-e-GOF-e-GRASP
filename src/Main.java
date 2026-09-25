import controller.PlanoController;
import model.Plano;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static PlanoController controller = new PlanoController();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1 -> cadastrarPlano();
                case 2 -> listarPlanos();
                case 3 -> atualizarPlano();
                case 4 -> removerPlano();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!\n");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("SISTEMA DE ASSINATURAS DE STREAMING");
        System.out.println("1 - Cadastrar plano (Create)");
        System.out.println("2 - Listar planos (Read)");
        System.out.println("3 - Atualizar plano (Update)");
        System.out.println("4 - Remover plano (Delete)");
        System.out.println("0 - Sair");
    }

    private static void cadastrarPlano() {
        System.out.println("\n--- Cadastro de novo plano ---");
        System.out.print("Nome do plano: ");
        String nome = scanner.nextLine();
        double precoMensal = lerDouble("Preço mensal: ");
        int quantidadeAssinantes = lerInteiro("Quantidade de assinantes: ");

        try {
            Plano plano = controller.cadastrar(nome, precoMensal, quantidadeAssinantes);
            System.out.println("Plano cadastrado com sucesso! " + plano + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage() + "\n");
        }
    }

    private static void listarPlanos() {
        System.out.println("\n--- Lista de planos ---");
        List<Plano> planos = controller.listar();
        if (planos.isEmpty()) {
            System.out.println("Nenhum plano cadastrado.\n");
            return;
        }
        for (Plano p : planos) {
            System.out.println(p);
        }
        System.out.println();
    }

    private static void atualizarPlano() {
        System.out.println("\n--- Atualizar plano ---");
        int id = lerInteiro("Informe o ID do plano: ");
        Plano existente = controller.buscar(id);
        if (existente == null) {
            System.out.println("Plano não encontrado.\n");
            return;
        }
        System.out.print("Novo nome (" + existente.getNome() + "): ");
        String nome = scanner.nextLine();
        double precoMensal = lerDouble("Novo preço mensal (" + existente.getPrecoMensal() + "): ");
        int quantidadeAssinantes = lerInteiro("Nova quantidade de assinantes (" + existente.getQuantidadeAssinantes() + "): ");

        boolean sucesso = controller.atualizar(id, nome, precoMensal, quantidadeAssinantes);
        System.out.println(sucesso ? "Plano atualizado com sucesso!\n" : "Falha ao atualizar.\n");
    }

    private static void removerPlano() {
        System.out.println("\n--- Remover plano ---");
        int id = lerInteiro("Informe o ID do plano: ");
        boolean sucesso = controller.remover(id);
        System.out.println(sucesso ? "Plano removido com sucesso!\n" : "Plano não encontrado.\n");
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. " + mensagem);
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor inválido. " + mensagem);
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}
