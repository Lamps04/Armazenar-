public class Produto {
    private static int contador = 0; 
    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private double quantidade;

    public Produto(String nome, double preco, String descricao, double quantidade) {
        this.id = ++contador;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    
    @Override
    public String toString() {
        return "ID: " + id +
               ", Nome: " + nome +
               ", Preço: R$" + preco +
               ", Descrição: " + descricao +
               ", Quantidade: " + quantidade;
    }

    public String toLine() {
        return id + ";" + nome + ";" + preco + ";" + descricao + ";" + quantidade;
    }
}
