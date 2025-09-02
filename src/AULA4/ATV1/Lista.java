package AULA4.ATV1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Lista {
    private ArrayList<Integer> elementos;

    public Lista() {
        this.elementos = new ArrayList<>();
    }

    public void inserirElementos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite os elementos da lista (digite -1 para parar):");

        while (true) {
            boolean valorValido = false;
            int elemento = 0;

            while (!valorValido) {
                try {
                    System.out.print("Elemento: ");
                    elemento = scanner.nextInt();
                    valorValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite um número inteiro válido!");
                    scanner.next(); // Limpa o buffer do scanner
                }
            }

            if (elemento == -1) {
                break;
            }

            elementos.add(elemento);
        }
    }

    public int encontrarMaiorElemento() {
        if (elementos.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int maior = elementos.getFirst();
        for (int elemento : elementos) {
            if (elemento > maior) {
                maior = elemento;
            }
        }
        return maior;
    }

    public int contarNumerosPares() {
        int count = 0;
        for (int elemento : elementos) {
            if (elemento % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public double calcularMedia() {
        if (elementos.isEmpty()) {
            return 0.0;
        }

        int soma = 0;
        for (int elemento : elementos) {
            soma += elemento;
        }

        return (double) soma / elementos.size();
    }

    public void exibirLista() {
        System.out.println("\nLista: " + elementos);
    }
}