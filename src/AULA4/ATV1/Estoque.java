package AULA4.ATV1;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void inserirProduto(Produto produto) {
        produtos.add(produto);
    }

    public void imprimirProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS EM ESTOQUE ===");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto em estoque.");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        System.out.println("Total de produtos: " + produtos.size());
    }
}