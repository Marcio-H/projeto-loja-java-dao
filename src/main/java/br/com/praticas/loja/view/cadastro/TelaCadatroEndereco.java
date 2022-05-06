package br.com.praticas.loja.view.cadastro;

import javax.swing.JButton;
import javax.swing.JTextField;

public interface TelaCadatroEndereco extends TelaCadastro {

	JTextField getCepTextField();

	JTextField getLogradouroTextField();

	JTextField getDescricaoBairroTextField();

	JTextField getDescricaoCidadeTextField();

	JTextField getUfCidadeTextField();

	JButton getBotaoAdicionarCidade();

	JButton getBotaoBuscarCidade();

	JButton getBotaoAdicionarBairro();

	JButton getBotaoBuscarBairro();
}
