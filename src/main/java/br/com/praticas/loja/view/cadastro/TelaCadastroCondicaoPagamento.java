package br.com.praticas.loja.view.cadastro;

import javax.swing.JTextField;

public interface TelaCadastroCondicaoPagamento extends TelaCadastro {

	JTextField getDescricaoTextField();
	
	JTextField getNumeroDiasAtePrimeiraParcelaTextField();
	
	JTextField getNumeroDiasEntreParcelasTextField();
}
