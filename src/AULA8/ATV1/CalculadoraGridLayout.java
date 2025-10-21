package AULA8.ATV1;

import javax.swing.*;
import java.awt.*;

public class CalculadoraGridLayout extends JFrame {
    public CalculadoraGridLayout() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de texto para mostrar os números
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        // Painel de botões com GridLayout
        JPanel panelBotoes = new JPanel(new GridLayout(5, 4, 5, 5));

        // Array com os textos dos botões
        String[] botoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "CE", "√", "x²"
        };

        // Adiciona botões ao painel
        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            panelBotoes.add(botao);
        }

        add(panelBotoes, BorderLayout.CENTER);
        pack();
        setSize(300, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraGridLayout().setVisible(true);
        });
    }
}