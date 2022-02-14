package controller.busca;

import model.bo.Marca;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import service.MarcaService;
import view.TelaBuscaMarca;


public class ControllerBuscaMarca {
    private TelaBuscaMarca tela;
    private MarcaService marcaService;
    private Consumer<Marca> carregarCallBack;

     public ControllerBuscaMarca(Consumer<Marca> carregarCallBack) {
        tela = new TelaBuscaMarca();
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        marcaService = new MarcaService();
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
            carregarCallBack.accept(marcaService.readById(id));
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
        marcaService.read().stream().forEach(marca -> {
            tabela.addRow(new Object[]{ marca.getId(), 
                                        marca.getDescricao()
            });
        });
    }
}
