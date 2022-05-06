package br.com.praticas.loja.view.cadastro;

import javax.swing.JButton;
import javax.swing.JTextField;

import br.com.praticas.loja.view.Janela;

public interface TelaCadastro extends Janela {

	JTextField getId();
	
	JButton getBotaoNovo();
	
	JButton getBotaoCancelar();
	
	JButton getBotaoGravar();
	
	JButton getBotaoBuscar();
	
	JButton getBotaoSair();
}
