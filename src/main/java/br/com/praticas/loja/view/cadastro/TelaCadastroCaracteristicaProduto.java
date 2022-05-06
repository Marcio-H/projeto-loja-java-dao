package br.com.praticas.loja.view.cadastro;

import javax.swing.JButton;
import javax.swing.JTextField;

public interface TelaCadastroCaracteristicaProduto extends TelaCadastro {

	JTextField getTamanhoTextField();

	JTextField getCodigoBarrasTextField();
	
	JTextField getEstoqueTextField();
	
	JTextField getDescricaoProdutoTextField();
	
	JTextField getValorProdutoTextField();
	
	JTextField getDescricaoCor();
	
	JButton getBotaoAddCor();
	
	JButton getBotaoBuscarCor();
	
	JButton getBotaoAddProduto();
	
	JButton getBotaoBuscarProduto();
}
