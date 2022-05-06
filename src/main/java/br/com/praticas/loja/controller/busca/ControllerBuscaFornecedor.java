package br.com.praticas.loja.controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.praticas.loja.model.Fornecedor;
import br.com.praticas.loja.view.busca.TelaBusca;

public class ControllerBuscaFornecedor {
    
	@Autowired
    private FornecedorService fornecedorService;
	
	@Autowired
	@Qualifier("fornecedor")
    private TelaBusca tela;
    
    private Consumer<Fornecedor> carregarCallBack;
    
    public ControllerBuscaFornecedor(Consumer<Fornecedor> carregarCallBack) {
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        fornecedorService = new FornecedorService();
        addRows();
        this.tela.getTabela().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        tela.setVisible(true);
    }
    
    private void addRows() {
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTabela().getModel();
        fornecedorService.read().stream().forEach(fornecedor -> {
            tabela.addRow(new Object[]{fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getEmail(),
                fornecedor.getRazaoSocial()
            });
        });
    }
    
    private void carregarEventListener() {
        tela.getBotaoCarregar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                carregarEventAction(evt);
            }
        });
    }
    
    private void sairEventListener() {
        tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }
    
    private void carregarEventAction(MouseEvent evt) {
        int index = tela.getTabela().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTabela().getValueAt(index, 0);
            carregarCallBack.accept(fornecedorService.readById(id));
            tela.dispose();
        }
    }
    
    private void sairEventAction(MouseEvent evt) {
        tela.dispose();
    }
}
