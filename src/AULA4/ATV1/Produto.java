package AULA4.ATV1;

public class Produto {
    private String nome;
    private int codigo;
    private double preco;
    private int quantidade;

    public Produto(String nome, int codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public int getCodigo() { return codigo; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return String.format("Código: %d | Nome: %-15s | Preço: R$%.2f | Quantidade: %d",
                codigo, nome, preco, quantidade);
    }
}