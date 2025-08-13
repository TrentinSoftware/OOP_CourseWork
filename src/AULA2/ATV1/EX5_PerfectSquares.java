package AULA2.ATV1;

import javax.swing.JOptionPane;

public class EX5_PerfectSquares {
    public static void main(String[] args) {
        StringBuilder perfectSquares = new StringBuilder("Quadrados perfeitos de 1 a 1000:\n\n");
        int count = 0;

        for (int i = 1; ; i++) {
            int squad = i * i;
            if (squad > 1000) {
                break;
            }
            perfectSquares.append(squad).append(" ");
            count++;

            if (count % 10 == 0) {
                perfectSquares.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null,
                perfectSquares.toString(),
                "Resultado - Quadrados Perfeitos",
                JOptionPane.INFORMATION_MESSAGE);
    }
}