package AULA2.ATV1;

import javax.swing.JOptionPane;
import java.util.Locale;

public class EX1_NumClassify {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        String input = JOptionPane.showInputDialog("Digite um número:");

        try {
            double numero = Double.parseDouble(input.replace(",", "."));

            String classificacao = "";

            if (numero > 0) {
                classificacao = "Positivo";
            } else if (numero < 0) {
                classificacao = "Negativo";
            } else {
                classificacao = "Zero";
            }

            if (numero % 2 == 0) {
                classificacao += " e Par";
            } else {
                classificacao += " e Ímpar";
            }

            JOptionPane.showMessageDialog(null,
                    "O número é: " + classificacao,
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Valor inválido! Digite um número.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}