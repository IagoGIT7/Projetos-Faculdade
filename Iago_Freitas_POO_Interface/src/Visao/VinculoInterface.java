package Visao;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import Controle.VincularController;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class VinculoInterface extends JFrame implements ActionListener {

    private JLabel labelIdLivro, labelIdCategoria;
    private JFormattedTextField campoIdLivro, campoIdCategoria; // Alterado para JFormattedTextField
    private JButton botaoEnviar;

    public VinculoInterface() {
        super("Cadastrar Categoria do Livro");

        // Criando e posicionando os labels
        labelIdLivro = new JLabel("ID Livro:");
        labelIdLivro.setBounds(10, 10, 80, 25);
        add(labelIdLivro);

        labelIdCategoria = new JLabel("ID Categoria:");
        labelIdCategoria.setBounds(10, 40, 80, 25);
        add(labelIdCategoria);

        // Criando e posicionando os campos de texto
        try {
            MaskFormatter formatter = new MaskFormatter("#####");
            formatter.setPlaceholderCharacter('0');
            campoIdLivro = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        campoIdLivro.setBounds(90, 10, 200, 25);
        add(campoIdLivro);

        try {
            MaskFormatter formatter = new MaskFormatter("#####");
            formatter.setPlaceholderCharacter('0');
            campoIdCategoria = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        campoIdCategoria.setBounds(90, 40, 200, 25);
        add(campoIdCategoria);

        // Criando e posicionando o botão "Enviar"
        botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(100, 70, 100, 25);
        botaoEnviar.addActionListener(this); // Adicionando listener ao botão
        add(botaoEnviar);

        // Definindo layout e propriedades da tela
        setLayout(null);
        setSize(320, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoEnviar) {
            int idLivro = Integer.parseInt(campoIdLivro.getText()); // Convertendo o texto do campoId para int
            int idCategoria = Integer.parseInt(campoIdCategoria.getText());
            
            TelaResultado telaImpressao = new TelaResultado("Vínculado com sucesso!");
            telaImpressao.setVisible(true);
            
            try {
                VincularController vincularController = new VincularController();
                vincularController.vincular(idLivro, idCategoria);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}