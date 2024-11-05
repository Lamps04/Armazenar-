import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String NOTAS = "produtos.txt";
    private static List<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;  

    public static void main(String[] args) {
        carregarProdutos(); 
        String logo = """
            $$$$$$\\  $$$$$$$\\   $$\\      $$\\  $$$$$$\\  $$$$$$$$\\ $$$$$$$$\\ $$\\   $$\\  $$$$$$\\  $$$$$$$\\            
           $$  __$$\\ $$  __$$\\  $$$\\    $$$$ |$$  __$$\\ \\____$$  |$$  _____|$$$\\  $$ |$$  __$$\\ $$  __$$\\    $$\\    
           $$ /  $$ |$$ |  $$   |$$$$\\  $$$$ |$$ /  $$ |    $$  / $$ |      $$$$\\ $$ |$$ /  $$ |$$ |  $$ |   $$ |   
           $$$$$$$$ |$$$$$$$    |$$\\$$\\$$ $$ |$$$$$$$$$    $$  /  $$$$$\\    $$ $$\\$$ |$$$$$$$$$|$$$$$$$  |$$$$$$$$\\ 
           $$  __$$ |$$  __$$<   $$ \\$$$  $$ |$$  __$$ |  $$  /   $$  __|   $$ \\$$$$ |$$  __$$ |$$  __$$< \\__$$  __| 
           $$ |  $$ |$$ |  $$ |  $$ |\\$  /$$ |$$ |  $$ | $$  /    $$ |      $$ |\\$$$ |$$ |  $$ |$$ |  $$ |   $$ |   
           $$ |  $$ |$$ |  $$ |  $$ | \\_/ $$ |$$ |  $$ |$$$$$$$$$\\ $$$$$$$$\\$$ | \\$$ |$$ |  $$ |$$ |  $$ |   \\__|   
           \\__|  \\__|\\__|\\  __|\\__|     \\__|\\__|  \\__|\\________|\\________|\\__|  \\__|\\__|  \\__|\\__|  \\__|          
           
           """;
           System.out.println(logo);
       int opcao;
       do {

            System.out.println("\n=== Menu de Estoque Armazenar+ ===");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Mostrar Estoque");
            System.out.println("3. Deletar produto");
            System.out.println("4. Buscar item pelo ID");
            System.out.println("5. Sair\n");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    mostrarEstoque();
                    break;
                case 3:
                    deletarProduto();
                    break;
                case 4:
                    buscarID();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
        scanner.close();
    }

    private static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.next();
        
        System.out.print("Preço: ");
        double preco = 0;
        while (true) {
            try {
                preco = scanner.nextDouble();
                scanner.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um valor numérico para o preço.");
                scanner.next(); 
            }
        }

        System.out.print("Descrição do produto: ");
        String descricao = scanner.nextLine(); 

        System.out.print("Digite a quantidade em estoque: ");
        double quantidade = 0;
        while (true) {
            try {
                quantidade = scanner.nextDouble();
                scanner.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um valor numérico para a quantidade.");
                scanner.next(); 
            }
        }
        
        Produto novoProduto = new Produto(nome, preco, descricao, quantidade);
        novoProduto.setId(nextId++);
        produtos.add(novoProduto);
        salvarProdutos();
        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();
    }

    private static void mostrarEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio");
        } else {
            System.out.println("\n=== Estoque de produtos ===");
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.getId() + " - " + produto.getNome() + " - R$" + produto.getPreco() + 
                " - " + produto.getDescricao());
            }
        }

        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();
    }

    private static void deletarProduto() {
        System.out.print("Digite o ID do produto a ser deletado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produto produtoEncontrado = buscarProdutoPorId(id);
    
        if (produtoEncontrado != null) {
            produtos.remove(produtoEncontrado);
            salvarProdutos();
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    
        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();
    }
    
    private static void buscarID() {
        System.out.print("Digite o ID do produto a ser buscado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produto produto = buscarProdutoPorId(id);
    
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("\nProduto com ID " + id + " não encontrado.");
        }
    
        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();
    }
    
    private static Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public static void carregarProdutos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOTAS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
    
                if (dados.length >= 5) {
                    Produto produto = new Produto(dados[1], Double.parseDouble(dados[2]), dados[3], Double.parseDouble(dados[4]));
                    produto.setId(Integer.parseInt(dados[0]));
                    produtos.add(produto);
                    nextId = Math.max(nextId, produto.getId() + 1);
                } else {
                    System.out.println("Linha inválida: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os produtos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter valores: " + e.getMessage());
        }
    }
    
    public static void salvarProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTAS))) {
            for (Produto produto : produtos) {
                writer.write(produto.getId() + ";" + produto.getNome() + ";" + produto.getPreco() + ";" + produto.getDescricao() + ";" + produto.getQuantidade());
                writer.newLine(); 
            }
            System.out.println("Produtos salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os produtos: " + e.getMessage());
        }
    }
}
