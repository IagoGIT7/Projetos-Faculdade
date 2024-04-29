package Visao;

import javax.swing.*;

public class TelaResultado extends JDialog {

	private JLabel labelId ,labelNome, labelAutor, labelTipo;
    private JLabel valorId, valorNome, valorAutor, valorTipo;

    public TelaResultado(String nome) {
        super((JFrame) null, "Dados do Usuario", true);

        // Criando e posicionando os labels com os valores dos dados
        
        valorNome = new JLabel(nome);
        valorNome.setBounds(90, 10, 200, 25);
        add(valorNome);

        // Definindo layout e propriedades da tela
        setLayout(null);
        setSize(320, 150);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Fechar ao clicar no X
    }
}