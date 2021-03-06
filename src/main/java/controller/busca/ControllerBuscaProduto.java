package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.table.DefaultTableModel;

import domain.Produto;
import service.ProdutoService;
import view.busca.TelaBuscaProduto;


public class ControllerBuscaProduto {
    private TelaBuscaProduto tela;
    private ProdutoService produtoService;
    private Consumer<Produto> carregarCallBack;

     public ControllerBuscaProduto(Consumer<Produto> carregarCallBack) {
        tela = new TelaBuscaProduto();
        this.carregarCallBack = carregarCallBack;
        init();
    }

    private void init() {
        tela.setVisible(true);
        produtoService = new ProdutoService();
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
            carregarCallBack.accept(produtoService.readById(id));
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
        produtoService.read().stream().forEach(produto -> {
            tabela.addRow(new Object[]{ produto.getId(), 
                                        produto.getDescricao(),
                                        produto.getValor(),
                                        produto.getMarca().getDescricao(),
                                        produto.getTamanho().getDescricao(),
                                        produto.getTipoProduto().getDescricao()
            });
        });
    }
}
