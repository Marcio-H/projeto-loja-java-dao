package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.swing.table.DefaultTableModel;
import model.bo.Telefone;
import service.TelefoneService;
import view.busca.TelaBuscaTelefone;

public class ControllerBuscaTelefone {
    
    private TelaBuscaTelefone tela;
    private TelefoneService telefoneService;
    private Consumer <Telefone> carregarCallBack;

    public ControllerBuscaTelefone(Consumer <Telefone> carregarCallBack) {
        tela = new TelaBuscaTelefone();
        init();
        this.carregarCallBack = carregarCallBack;
    }

    private void init() {
        tela.setVisible(true);
        telefoneService = new TelefoneService();
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
            carregarCallBack.accept(telefoneService.readById(id));
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
        telefoneService.read().stream().forEach(telefone -> {
            tabela.addRow(new Object[]{ telefone.getId(), 
                                        telefone.getTelefone()
            });
        });
    }
}
