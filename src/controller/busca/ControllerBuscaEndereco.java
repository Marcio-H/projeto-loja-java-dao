package controller.busca;

import controller.cadastro.ControllerCadastroEndereco;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import service.EnderecoService;
import view.busca.TelaBuscaEndereco;


public class ControllerBuscaEndereco {
    private TelaBuscaEndereco tela;
    private EnderecoService enderecoService;
    private ControllerCadastroEndereco controllerCadastroEndereco;

     public ControllerBuscaEndereco(ControllerCadastroEndereco controllerCadastroEndereco) {
        tela = new TelaBuscaEndereco();
        this.controllerCadastroEndereco = controllerCadastroEndereco;
        init();
    }
    
    public ControllerBuscaEndereco(TelaBuscaEndereco tela, ControllerCadastroEndereco controllerCadastroEndereco) {
        this.tela = tela;
        this.controllerCadastroEndereco = controllerCadastroEndereco;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        enderecoService = new EnderecoService();
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
            controllerCadastroEndereco.setEndereco(enderecoService.readById(id));
            controllerCadastroEndereco.setFormStatus(true);
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
        enderecoService.read().stream().forEach(endereco -> {
            tabela.addRow(new Object[]{ endereco.getId(), 
                                        endereco.getCep(),
                                        endereco.getLogradouro(),
                                        endereco.getCidade().getDescricao(),
                                        endereco.getBairro().getDescricao()
            });
        });
    }
}
