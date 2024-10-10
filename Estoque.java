
/**Aqui é importado a biblioteca de ArrayList do Java.
E onde serão criados os métodos de adicionar itens ao estoque.
*/
import java.util.ArrayList;

public class Estoque {
    private ArrayList<ItemEstoque> itens;

    public Estoque() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, String descricao, int quantidade, double preco) {
        // Método para determinar o próximo ID disponível
        int novoId = 1; // Inicia com 1
        if (!itens.isEmpty()) {
            novoId = itens.get(itens.size() - 1).getId() + 1; // Aumenta o ID do último item
        }

        // Cria um novo item com o novo ID
        ItemEstoque novoItem = new ItemEstoque(novoId, nome, descricao, quantidade, preco);

        // Adiciona o item ao estoque
        itens.add(novoItem);
        System.out.println("Item adicionado com sucesso! ID do item: " + novoId);
    }

    // Esse método é para verificar e mostrar o estoque
    public void mostrarEstoque() {
        for (ItemEstoque item : itens) {
            item.verificarEstoque(); // Verifica a quantidade do item
        }
    }

    // Esse método é para buscar o item pelo id
    public ItemEstoque buscarItemPorId(int id) {
        for (ItemEstoque item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // Esse método para atualizar a quantidade de um item específico
    public void atualizarQuantidade(int id, int novaQuantidade) {
        ItemEstoque item = buscarItemPorId(id);
        if (item != null) {
            item.setQuantidade(novaQuantidade);
            System.out.println("Quantidade atualizada para o item" + item.getNome());
        } else {
            System.out.println("Item com ID: " + id + "Não encontrado.");
        }
    }

    // Esse método é para remover item do estoque
    public void removerItem(int id) {
        ItemEstoque item = buscarItemPorId(id);
        if (item != null) {
            itens.remove(item); // Remove o item da lista
            System.out.println("Item " + item.getNome() + " foi removido do estoque.");
        } else {
            System.out.println("Item com ID: " + id + " não encontrado.");
        }
    }
}
