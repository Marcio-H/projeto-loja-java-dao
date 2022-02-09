package controller.busca;

import controller.cadastro.ControllerCadastroCidade;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import service.CidadeService;
import view.busca.TelaBuscaCidade;

public class ControllerBuscaCidade {
    
    private TelaBuscaCidade tela;
    private CidadeService cidadeService;
    private ControllerCadastroCidade controllerCadastroCidade;
    
    public ControllerBuscaCidade(ControllerCadastroCidade controllerCadastroCidade) {
        tela = new TelaBuscaCidade();
        this.controllerCadastroCidade = controllerCadastroCidade;
        init();
    }
    
    public ControllerBuscaCidade(TelaBuscaCidade tela, ControllerCadastroCidade controllerCadastroCidade) {
        this.tela = tela;
        this.controllerCadastroCidade = controllerCadastroCidade;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        cidadeService = new CidadeService();
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
            controllerCadastroCidade.setCidade(cidadeService.readById(id));
            controllerCadastroCidade.setFormStatus(true);
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
        cidadeService.read().stream().forEach(cidade -> {
            tabela.addRow(new Object[]{ cidade.getId(), 
                                        cidade.getDescricao(),
                                        cidade.getUf()
            });
        });
    }
}
