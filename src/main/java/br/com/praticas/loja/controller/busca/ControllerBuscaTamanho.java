package controller.busca;

import model.bo.Tamanho;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import service.TamanhoService;
import view.busca.TelaBuscaTamanho;

public class ControllerBuscaTamanho {
    
    private TelaBuscaTamanho tela;
    private TamanhoService tamanhoService;
    private Consumer<Tamanho> carregarCallBack;
    
    public ControllerBuscaTamanho(Consumer<Tamanho> carregarCallBack) {
        tela = new TelaBuscaTamanho();
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        tamanhoService = new TamanhoService();
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
            carregarCallBack.accept(tamanhoService.readById(id));
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
        tamanhoService.read().stream().forEach(tamanho -> {
            tabela.addRow(new Object[]{ tamanho.getId(), 
                                        tamanho.getDescricao()
            });
        });
    }
}
