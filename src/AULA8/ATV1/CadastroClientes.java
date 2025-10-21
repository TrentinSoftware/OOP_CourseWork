package AULA8.ATV1;

import javax.swing.*;
import java.awt.*;

public class CadastroClientes extends JFrame {
    public CadastroClientes() {
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Componentes para nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        JTextField txtNome = new JTextField(20);
        add(txtNome, gbc);

        // Componentes para e-mail
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        add(new JLabel("E-mail:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        JTextField txtEmail = new JTextField(20);
        add(txtEmail, gbc);

        // Componentes para senha
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        JPasswordField txtSenha = new JPasswordField(20);
        add(txtSenha, gbc);

        // RadioButtons para tipo de cliente
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        add(new JLabel("Tipo de Cliente:"), gbc);

        gbc.gridx = 1;
        JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup grupoTipo = new ButtonGroup();
        JRadioButton rbFisica = new JRadioButton("Pessoa Física");
        JRadioButton rbJuridica = new JRadioButton("Pessoa Jurídica");
        grupoTipo.add(rbFisica);
        grupoTipo.add(rbJuridica);
        panelTipo.add(rbFisica);
        panelTipo.add(rbJuridica);
        add(panelTipo, gbc);

        // Checkboxes para serviços
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Serviço Exigido:"), gbc);

        gbc.gridx = 1;
        JPanel panelServicos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox cbFinanceiro = new JCheckBox("Financeiro");
        JCheckBox cbAdministrativo = new JCheckBox("Administrativo");
        JCheckBox cbTecnico = new JCheckBox("Técnico");
        panelServicos.add(cbFinanceiro);
        panelServicos.add(cbAdministrativo);
        panelServicos.add(cbTecnico);
        add(panelServicos, gbc);

        // Lista para dias de reunião
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Dia de Reunião:"), gbc);

        gbc.gridx = 1;
        String[] dias = {"Segunda-feira", "Terça-feira", "Quarta-feira",
                "Quinta-feira", "Sexta-feira"};
        JList<String> listaDias = new JList<>(dias);
        listaDias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDias.setVisibleRowCount(3);
        JScrollPane scrollDias = new JScrollPane(listaDias);
        add(scrollDias, gbc);

        // Botão de submissão
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar, gbc);

        pack();
        setLocationRelativeTo(null);
        setSize(500, 400);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CadastroClientes().setVisible(true);
        });
    }
}