package AULA2.ATV1;

import javax.swing.JOptionPane;
import java.util.Locale;

public class EX3_PrintNumbersItterate {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        String input = JOptionPane.showInputDialog("Digite um número inteiro positivo (N):");

        try {
            int n = Integer.parseInt(input.replace(",", "."));

            if (n <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Por favor, digite um número inteiro positivo!",
                        "Valor inválido",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            StringBuilder numeros = new StringBuilder("Números de 1 a " + n + ":\n");
            for (int i = 1; i <= n; i++) {
                numeros.append(i);
                if (i < n) {
                    numeros.append(", ");
                }
                if (i % 10 == 0) {
                    numeros.append("\n");
                }
            }

            JOptionPane.showMessageDialog(null,
                    numeros.toString(),
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Valor inválido! Digite um número inteiro.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}