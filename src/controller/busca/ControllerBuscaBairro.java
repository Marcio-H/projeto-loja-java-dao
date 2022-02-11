package controller.busca;

import controller.cadastro.ControllerCadastroBairro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import service.BairroService;
import view.busca.TelaBuscaBairro;

public class ControllerBuscaBairro {
    private TelaBuscaBairro tela;
    private BairroService bairroService;
    private ControllerCadastroBairro controllerCadastroBairro;

     public ControllerBuscaBairro(ControllerCadastroBairro controllerCadastroBairro) {
        tela = new TelaBuscaBairro();
        this.controllerCadastroBairro = controllerCadastroBairro;
        init();
    }
    
    public ControllerBuscaBairro(TelaBuscaBairro tela, ControllerCadastroBairro controllerCadastroBairro) {
        this.tela = tela;
        this.controllerCadastroBairro = controllerCadastroBairro;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        bairroService = new BairroService();
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
            controllerCadastroBairro.setCidade(bairroService.readById(id));
            controllerCadastroBairro.setFormStatus(true);
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
        bairroService.read().stream().forEach(cidade -> {
            tabela.addRow(new Object[]{ cidade.getId(), 
                                        cidade.getDescricao()
            });
        });
    }
}
