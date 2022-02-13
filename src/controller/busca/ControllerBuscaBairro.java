package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import view.busca.TelaBuscaBairro;

public class ControllerBuscaBairro {
    private TelaBuscaBairro tela;
    private BairroService bairroService;
    private Consumer<Bairro> carregarCallBack;

     public ControllerBuscaBairro(Consumer<Bairro> carregarCallBack) {
        tela = new TelaBuscaBairro();
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        bairroService = new BairroService();
        addRows();
        this.tela.getTable().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        tela.setVisible(true);
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
            carregarCallBack.accept(bairroService.readById(id));
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
        bairroService.read().stream().forEach(bairro -> {
            tabela.addRow(new Object[]{ bairro.getId(), 
                                        bairro.getDescricao()
            });
        });
    }
}
