package br.com.praticas.loja.view.busca;

import javax.swing.JButton;
import javax.swing.JTable;

import br.com.praticas.loja.view.Janela;

public interface TelaBusca extends Janela {

	JTable getTabela();

	JButton getBotaoCarregar();

	JButton getBotaoSair();
}
