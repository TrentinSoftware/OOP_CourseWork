package AULA4.ATV1;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Matriz {
    private int[][] matriz;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[linhas][colunas];
    }

    public void imprimirMatriz() {
        System.out.println("\nMatriz " + linhas + "x" + colunas + ":");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void inserirValores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite os valores da matriz " + linhas + "x" + colunas + ":");

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                boolean valorValido = false;

                while (!valorValido) {
                    try {
                        System.out.print("Matriz[" + i + "][" + j + "]: ");
                        matriz[i][j] = scanner.nextInt();
                        valorValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Digite um número inteiro válido!");
                        scanner.next(); // Limpa o buffer do scanner
                    }
                }
            }
        }
    }

    public int somarValores() {
        int soma = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                soma += matriz[i][j];
            }
        }
        return soma;
    }

    public void multiplicarPor(int multiplicador) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] *= multiplicador;
            }
        }
    }
}