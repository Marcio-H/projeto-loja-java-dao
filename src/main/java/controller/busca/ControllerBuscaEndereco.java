package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.table.DefaultTableModel;

import domain.Endereco;
import service.EnderecoService;
import view.busca.TelaBuscaEndereco;


public class ControllerBuscaEndereco {
    private TelaBuscaEndereco tela;
    private EnderecoService enderecoService;
    private Consumer<Endereco> carregarCallBack;

     public ControllerBuscaEndereco(Consumer<Endereco> carregarCallBack) {
        tela = new TelaBuscaEndereco();
        this.carregarCallBack = carregarCallBack;
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
            carregarCallBack.accept(enderecoService.readById(id));
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
