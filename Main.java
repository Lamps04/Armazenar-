import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Adicionando itens ao estoque o sistema gera ID automaticamente
        estoque.adicionarItem("Fita Isolante 3M", "Feito de PVC, bom isolante elétrico.", 10, 5.99);
        estoque.adicionarItem("Caixa d'água", "Cx 1500L", 0, 1130.0);
        estoque.adicionarItem("Chuveiro", "Alta pressão", 5, 1200.0);
        estoque.adicionarItem("Fio Flexível", "Rolo de 100m", 100, 189.90);

        while (continuar) {
            // Exibir o menu de opções
            System.out.println("\n=== Menu de Estoque Armazenar+ ===");
            System.out.println("1. Adicionar item ao estoque");
            System.out.println("2. Atualizar quantidade de item");
            System.out.println("3. Remover item do estoque");
            System.out.println("4. Mostrar estoque completo");
            System.out.println("5. Buscar item pelo ID");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Adicionar item ao estoque
                    System.out.println("Adicionar item:");
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble();
                    estoque.adicionarItem(nome, descricao, quantidade, preco);
                    break;
                case 2:
                    // Atualizar quantidade de um item
                    System.out.println("Atualizar quantidade de item:");
                    System.out.print("Digite o ID do item: ");
                    int idAtualizar = scanner.nextInt();
                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    break;
                case 3:
                    // Remover item do estoque
                    System.out.print("Digite o ID do item que deseja remover: ");
                    int idRemover = scanner.nextInt();
                    estoque.removerItem(idRemover);
                    break;
                case 4:
                    // Mostrar estoque completo
                    System.out.println("=== Estoque Atual ===");
                    estoque.mostrarEstoque();
                    break;
                case 5:
                    // Buscar item pelo ID
                    System.out.print("Digite o ID do item que deseja buscar: ");
                    int idBuscar = scanner.nextInt();
                    ItemEstoque itemBuscado = estoque.buscarItemPorId(idBuscar);
                    if (itemBuscado != null) {
                        System.out.println("Item encontrado: " + itemBuscado.getNome() + " | Quantidade: "
                                + itemBuscado.getQuantidade());
                    } else {
                        System.out.println("Item não encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            // Perguntar ao usuário se deseja voltar ao menu
            System.out.print("\nDeseja voltar para o menu? (S para Sim / N para Não): ");
            char voltarMenu = scanner.next().charAt(0);
            if (voltarMenu == 'N' || voltarMenu == 'n') {
                continuar = false;
                System.out.println("Programa encerrado.");
            }
        }

        // Fechando o Scanner para liberar recursos
        scanner.close();
    }
}
