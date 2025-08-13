package AULA2.ATV1;

import javax.swing.JOptionPane;
import java.util.Locale;

public class EX4_PrintNumbersFactorial {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        String input = JOptionPane.showInputDialog("Digite um número inteiro positivo (N):");

        try {
            int n = Integer.parseInt(input);

            if (n <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Por favor, digite um número inteiro positivo!",
                        "Valor inválido",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            StringBuilder resultado = new StringBuilder("Fatoriais de 1 a " + n + ":\n\n");

            for (int i = 1; i <= n; i++) {
                long fatorial = calcularFatorial(i);
                resultado.append(i).append("! = ").append(fatorial).append("\n");
            }

            JOptionPane.showMessageDialog(null,
                    resultado.toString(),
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Valor inválido! Digite um número inteiro.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static long calcularFatorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }

        long resultado = 1;
        for (int i = 2; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
