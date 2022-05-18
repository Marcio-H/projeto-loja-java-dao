package controller.busca;

import static java.awt.event.KeyEvent.VK_ENTER;
import static javax.swing.JComponent.WHEN_FOCUSED;
import static javax.swing.KeyStroke.getKeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.AbstractAction;
import javax.swing.table.DefaultTableModel;

import domain.Cliente;
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
        carregarToEnterEventListener();
        selectFirstRow();
    }
    private void selectFirstRow() {
        tela.getTable().requestFocus();
        tela.getTable().setRowSelectionInterval(0,0);
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
                carregarEventAction();
            }
        });
    }
    private void carregarToEnterEventListener() {
        tela.getTable().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getTable().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarEventAction();
            }
        });
    }
    private void carregarEventAction() {
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
