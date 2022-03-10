package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import service.ClienteService;
import view.busca.TelaBuscaCliente;

public class ControllerBuscaCliente {

    private TelaBuscaCliente tela;
    private ClienteService clienteService;
    private Consumer<Cliente> carregarCallBack;

    public ControllerBuscaCliente(Consumer<Cliente> carregarCallBack) {
        tela = new TelaBuscaCliente();
        this.carregarCallBack = carregarCallBack;
        init();
    }

    private void init() {
        tela.setVisible(true);
        clienteService = new ClienteService();
        addRows();
        this.tela.getTable().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
    }

    private void addRows() {
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTable().getModel();
        clienteService.read().stream().forEach(cliente -> {
            tabela.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getComplementoEndereco()
            });
        });
    }
    
    private void carregarEventListener() {
        tela.getCarregar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                carregarEventAction(evt);
            }
        });
    }

    private void carregarEventAction(MouseEvent evt) {
        int index = tela.getTable().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTable().getValueAt(index, 0);
            carregarCallBack.accept(clienteService.readById(id));
            tela.dispose();
        }
    }
    
    private void sairEventListener() {
        tela.getSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }

    private void sairEventAction(MouseEvent evt) {
        tela.dispose();
    }
}
