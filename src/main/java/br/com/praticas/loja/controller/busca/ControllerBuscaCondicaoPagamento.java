package br.com.praticas.loja.controller.busca;

import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.AbstractAction;
import static javax.swing.JComponent.WHEN_FOCUSED;
import static javax.swing.KeyStroke.getKeyStroke;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.praticas.loja.model.CondicaoPagamento;
import br.com.praticas.loja.view.busca.TelaBusca;

public class ControllerBuscaCondicaoPagamento {
    
	@Autowired
	@Qualifier("condicao_pagamento")
    private TelaBusca tela;

	
    private CondicaoPagamentoService condicaoPagamentoService;
    private Consumer<CondicaoPagamento> carregarCallBack;
    
    public ControllerBuscaCondicaoPagamento(Consumer<CondicaoPagamento> carregarCallBack) {
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        condicaoPagamentoService = new CondicaoPagamentoService();
        addRows();
        this.tela.getTabela().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        selectFirstRow();
        carregarToEnterEventListener();
    }

    private void selectFirstRow() {
        tela.getTabela().requestFocus();
        tela.getTabela().setRowSelectionInterval(0,0);
    }
    
    private void carregarEventListener() {
        tela.getBotaoCarregar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                carregarEventAction();
            }
        });
    }
    private void carregarToEnterEventListener() {
        tela.getTabela().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getTabela().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarEventAction();
            }
        });
    }
    private void carregarEventAction() {
        int index = tela.getTabela().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTabela().getValueAt(index, 0);
            carregarCallBack.accept(condicaoPagamentoService.readById(id));
            tela.dispose();
        }
    }

    private void sairEventListener() {
        tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }

    private void sairEventAction(MouseEvent evt) {
        tela.dispose();
    }
    
    private void addRows() {
        DefaultTableModel tabela = (DefaultTableModel) tela.getTabela().getModel();
        condicaoPagamentoService.read().stream().forEach(condicaoPagamento -> {
            tabela.addRow(new Object[]{condicaoPagamento.getId(),
                condicaoPagamento.getDescricao(),
                condicaoPagamento.getNumeroDiasAtePrimeiraParcela(),
                condicaoPagamento.getNumeroDiasEntreParcelas()
            });
        });
    }
}
