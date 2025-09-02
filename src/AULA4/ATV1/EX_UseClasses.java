package AULA4.ATV1;

import java.util.Scanner;

public class EX_UseClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TESTANDO CLASSE MATRIZ ===");

        System.out.print("Digite o número de linhas da matriz: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        int colunas = scanner.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);
        matriz.inserirValores();
        matriz.imprimirMatriz();

        System.out.println("Soma dos valores: " + matriz.somarValores());

        System.out.print("Digite um multiplicador: ");
        int multiplicador = scanner.nextInt();
        matriz.multiplicarPor(multiplicador);
        System.out.println("Matriz após multiplicação:");
        matriz.imprimirMatriz();

        System.out.println("\n=== TESTANDO CLASSE LISTA ===");
        Lista lista = new Lista();
        lista.inserirElementos();
        lista.exibirLista();

        System.out.println("Maior elemento: " + lista.encontrarMaiorElemento());
        System.out.println("Números pares: " + lista.contarNumerosPares());
        System.out.println("Média: " + lista.calcularMedia());

        System.out.println("\n=== TESTANDO CLASSE PRODUTO E ESTOQUE ===");
        Estoque estoque = new Estoque();

        estoque.inserirProduto(new Produto("Notebook", 1001, 2500.00, 10));
        estoque.inserirProduto(new Produto("Mouse", 1002, 50.00, 25));
        estoque.inserirProduto(new Produto("Teclado", 1003, 120.00, 15));
        estoque.inserirProduto(new Produto("Monitor", 1004, 800.00, 8));

        estoque.imprimirProdutos();

        scanner.close();
    }
}