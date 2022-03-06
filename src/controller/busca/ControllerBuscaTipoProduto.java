package controller.busca;

import model.bo.TipoProduto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import service.TipoProdutoService;
import view.busca.TelaBuscaCor;


public class ControllerBuscaTipoProduto {
    private TelaBuscaCor tela;
    private TipoProdutoService tipoProdutoService;
    private Consumer<TipoProduto> carregarCallBack;

     public ControllerBuscaTipoProduto(Consumer<TipoProduto> carregarCallBack) {
        tela = new TelaBuscaCor();
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        tipoProdutoService = new TipoProdutoService();
        addRows();
        this.tela.getTable().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
    }
    
    private void carregarEventListener() {
        tela.getBotaoCarregar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                carregarEventAction(evt);
            }
        });
    }
    
    private void carregarEventAction(MouseEvent evt) {
        int index = tela.getTable().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTable().getValueAt(index, 0);
            carregarCallBack.accept(tipoProdutoService.readById(id));
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
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTable().getModel();
        tipoProdutoService.read().stream().forEach(tipoProduto -> {
            tabela.addRow(new Object[]{ tipoProduto.getId(), 
                                        tipoProduto.getDescricao()
            });
        });
    }
}
