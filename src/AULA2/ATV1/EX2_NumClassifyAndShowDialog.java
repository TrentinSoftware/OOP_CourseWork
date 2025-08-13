package AULA2.ATV1;

import javax.swing.JOptionPane;
import java.util.Locale;

public class EX2_NumClassifyAndShowDialog {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        String input = JOptionPane.showInputDialog("Digite um número:");

        try {
            double numero = Double.parseDouble(input.replace(",", "."));

            StringBuilder resultado = new StringBuilder();

            if (numero > 0) {
                resultado.append("Positivo");
            } else if (numero < 0) {
                resultado.append("Negativo");
            } else {
                resultado.append("Zero");
            }

            if (numero % 2 == 0) {
                resultado.append(" e Par");
            } else {
                resultado.append(" e Ímpar");
            }

            if (numero == (int)numero) {
                int numInteiro = (int)numero;
                if (numInteiro % 3 == 0 || numInteiro % 5 == 0) {
                    resultado.append("\nO número é múltiplo de ");

                    if (numInteiro % 3 == 0 && numInteiro % 5 == 0) {
                        resultado.append("3 e 5");
                    } else if (numInteiro % 3 == 0) {
                        resultado.append("3");
                    } else {
                        resultado.append("5");
                    }
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Classificação:\n" + resultado.toString(),
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