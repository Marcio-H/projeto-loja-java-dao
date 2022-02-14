package controller.busca;

import controller.cadastro.ControllerCadastroMarca;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import service.MarcaService;
import view.busca.TelaBuscaMarca;


public class ControllerBuscaMarca {
    private TelaBuscaMarca tela;
    private MarcaService marcaService;
    private ControllerCadastroMarca controllerCadastroMarca;

     public ControllerBuscaMarca(ControllerCadastroMarca controllerCadastroMarca) {
        tela = new TelaBuscaMarca();
        this.controllerCadastroMarca = controllerCadastroMarca;
        init();
    }
    
    public ControllerBuscaMarca(TelaBuscaMarca tela, ControllerCadastroMarca controllerCadastroMarca) {
        this.tela = tela;
        this.controllerCadastroMarca = controllerCadastroMarca;
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
            controllerCadastroMarca.setCidade(marcaService.readById(id));
            controllerCadastroMarca.setFormStatus(true);
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
