package AULA9.ATV1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraFuncional extends JFrame {
    private JTextField display;
    private String currentInput = "";
    private double result = 0;
    private String lastOperator = "";
    private boolean startNewNumber = true;

    public CalculadoraFuncional() {
        setTitle("Calculadora Funcional");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de texto para mostrar os números
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
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

        // Adiciona botões ao painel com ActionListeners
        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            botao.addActionListener(new BotaoClickListener());
            panelBotoes.add(botao);
        }

        add(panelBotoes, BorderLayout.CENTER);
        pack();
        setSize(300, 400);
        setLocationRelativeTo(null);
    }

    private class BotaoClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
                    handleNumber(command);
                    break;

                case ".":
                    handleDecimal();
                    break;

                case "+": case "-": case "*": case "/":
                    handleOperator(command);
                    break;

                case "=":
                    calculateResult();
                    break;

                case "C":
                    clearAll();
                    break;

                case "CE":
                    clearEntry();
                    break;

                case "√":
                    calculateSquareRoot();
                    break;

                case "x²":
                    calculateSquare();
                    break;
            }

            // Atualiza o display
            display.setText(currentInput);
        }

        private void handleNumber(String number) {
            if (startNewNumber) {
                currentInput = number;
                startNewNumber = false;
            } else {
                currentInput += number;
            }
        }

        private void handleDecimal() {
            if (startNewNumber) {
                currentInput = "0.";
                startNewNumber = false;
            } else if (!currentInput.contains(".")) {
                currentInput += ".";
            }
        }

        private void handleOperator(String operator) {
            if (!startNewNumber) {
                calculateResult();
            }
            lastOperator = operator;
            result = Double.parseDouble(currentInput);
            startNewNumber = true;
        }

        private void calculateResult() {
            if (!lastOperator.isEmpty() && !startNewNumber) {
                double currentNumber = Double.parseDouble(currentInput);

                switch (lastOperator) {
                    case "+":
                        result += currentNumber;
                        break;
                    case "-":
                        result -= currentNumber;
                        break;
                    case "*":
                        result *= currentNumber;
                        break;
                    case "/":
                        if (currentNumber != 0) {
                            result /= currentNumber;
                        } else {
                            currentInput = "Erro";
                            startNewNumber = true;
                            lastOperator = "";
                            return;
                        }
                        break;
                }

                // Formata o resultado para remover .0 se for inteiro
                if (result == (long) result) {
                    currentInput = String.valueOf((long) result);
                } else {
                    currentInput = String.valueOf(result);
                }

                lastOperator = "";
                startNewNumber = true;
            }
        }

        private void clearAll() {
            currentInput = "0";
            result = 0;
            lastOperator = "";
            startNewNumber = true;
        }

        private void clearEntry() {
            currentInput = "0";
            startNewNumber = true;
        }

        private void calculateSquareRoot() {
            try {
                double number = Double.parseDouble(currentInput);
                if (number >= 0) {
                    result = Math.sqrt(number);
                    if (result == (long) result) {
                        currentInput = String.valueOf((long) result);
                    } else {
                        currentInput = String.valueOf(result);
                    }
                } else {
                    currentInput = "Erro";
                }
                startNewNumber = true;
            } catch (NumberFormatException ex) {
                currentInput = "Erro";
                startNewNumber = true;
            }
        }

        private void calculateSquare() {
            try {
                double number = Double.parseDouble(currentInput);
                result = number * number;
                if (result == (long) result) {
                    currentInput = String.valueOf((long) result);
                } else {
                    currentInput = String.valueOf(result);
                }
                startNewNumber = true;
            } catch (NumberFormatException ex) {
                currentInput = "Erro";
                startNewNumber = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraFuncional().setVisible(true);
        });
    }
}