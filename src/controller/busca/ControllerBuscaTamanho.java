package controller.busca;

import controller.cadastro.ControllerCadastroTamanho;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import service.TamanhoService;
import view.busca.TelaBuscaTamanho;

public class ControllerBuscaTamanho {
    
    private TelaBuscaTamanho tela;
    private TamanhoService tamanhoService;
    private ControllerCadastroTamanho controllerCadastroTamanho;
    
    public ControllerBuscaTamanho(ControllerCadastroTamanho controllerCadastroTamanho) {
        tela = new TelaBuscaTamanho();
        this.controllerCadastroTamanho = controllerCadastroTamanho;
        init();
    }
    
    public ControllerBuscaTamanho(TelaBuscaTamanho tela, ControllerCadastroTamanho controllerCadastroTamanho) {
        this.tela = tela;
        this.controllerCadastroTamanho = controllerCadastroTamanho;
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
            controllerCadastroTamanho.setCidade(tamanhoService.readById(id));
            controllerCadastroTamanho.setFormStatus(true);
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
        tamanhoService.read().stream().forEach(cidade -> {
            tabela.addRow(new Object[]{ cidade.getId(), 
                                        cidade.getDescricao()
            });
        });
    }
}
