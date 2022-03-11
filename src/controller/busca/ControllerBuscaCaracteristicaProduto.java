package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import model.bo.CaracteristicaProduto;
import service.CaracteristicaProdutoService;
import view.busca.TelaBuscaCaracteristicaProduto;


public class ControllerBuscaCaracteristicaProduto {
    private TelaBuscaCaracteristicaProduto tela;
    private CaracteristicaProdutoService caracteristicaProdutoService;
    private Consumer<CaracteristicaProduto> carregarCallBack;

     public ControllerBuscaCaracteristicaProduto(Consumer<CaracteristicaProduto> carregarCallBack) {
        tela = new TelaBuscaCaracteristicaProduto();
        this.carregarCallBack = carregarCallBack;
        init();
    }

    private void init() {
        tela.setVisible(true);
        caracteristicaProdutoService = new CaracteristicaProdutoService();
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
            carregarCallBack.accept(caracteristicaProdutoService.readById(id));
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
        caracteristicaProdutoService.read().stream().forEach(caracteristicaProduto -> {
            tabela.addRow(new Object[]{ caracteristicaProduto.getId(), 
                                        caracteristicaProduto.getBarra(),
                                        caracteristicaProduto.getProduto().getDescricao(),
                                        caracteristicaProduto.getTamanho(),
                                        caracteristicaProduto.getEstoque(),
                                        caracteristicaProduto.getCor().getDescricao(),

            });
        });
    }
}
