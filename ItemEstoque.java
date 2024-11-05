/** Essa classe que representava um item em estoque, foi inutilizada no versionamento seguinte do código. Atualmente INUTILIZADA.
 * Classe que representa um produto no armazém.
 * Atributos em private (encapsulados)
 * para somente a classe ItemEstoque acessar.
 */
public class ItemEstoque {
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

    /**
     * @param id         identificador
     * @param nome       nome do objeto
     * @param descricao  descrição do objeto
     * @param quantidade quantidade em estoque
     * @param preco      preço do objeto
     */
    public ItemEstoque(int id, String nome, String descricao, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    /**
     * Método Getters e Setters para acessar
     * e retornar o nome.
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Se a quantidade do item no estoque for < ||= 0
     * então irá retornar um aviso de que é necessário comprar mais.
     * Caso contrário irá avisar que tem o item + a quantidade
     */
    public void verificarEstoque() {
        if (quantidade == 0) {
            System.out.println("Item: " + nome + " está esgotado. É necessário comprar mais.");
        } else {
            System.out.println("Item: " + nome + " | Quantidade em estoque: " + quantidade);
        }
    }

}
