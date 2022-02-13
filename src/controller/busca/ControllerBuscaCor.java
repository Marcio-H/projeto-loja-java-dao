package controller.busca;

import controller.cadastro.ControllerCadastroCor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import service.CorService;
import view.busca.TelaBuscaCor;


public class ControllerBuscaCor {
    private TelaBuscaCor tela;
    private CorService corService;
    private ControllerCadastroCor controllerCadastroCor;

     public ControllerBuscaCor(ControllerCadastroCor controllerCadastroCor) {
        tela = new TelaBuscaCor();
        this.controllerCadastroCor = controllerCadastroCor;
        init();
    }
    
    public ControllerBuscaCor(TelaBuscaCor tela, ControllerCadastroCor controllerCadastroCor) {
        this.tela = tela;
        this.controllerCadastroCor = controllerCadastroCor;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        corService = new CorService();
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
            controllerCadastroCor.setCor(corService.readById(id));
            controllerCadastroCor.setFormStatus(true);
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
        corService.read().stream().forEach(cor -> {
            tabela.addRow(new Object[]{ cor.getId(), 
                                        cor.getDescricao()
            });
        });
    }
}
