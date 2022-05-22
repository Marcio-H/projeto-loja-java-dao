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

import domain.Vendedor;
import service.VendedorService;
import view.busca.TelaBuscaVendedor;

public class ControllerBuscaVendedor {
    
    private TelaBuscaVendedor tela;
    private VendedorService VendedorService;
    private Consumer<Vendedor> carregarCallBack;
    
    public ControllerBuscaVendedor(Consumer<Vendedor> carregarCallBack) {
        tela = new TelaBuscaVendedor();
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        VendedorService = new VendedorService();
        addRows();
        this.tela.getTable().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        tela.setVisible(true);
        selectFirstRow();
        carregarToEnterEventListener();
    }

    private void selectFirstRow() {
        try {
        	tela.getTable().requestFocus();
        	tela.getTable().setRowSelectionInterval(0,0);
        } catch (Exception e) {
			//does nothing
		}
    }

    private void addRows() {
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTable().getModel();
        VendedorService.read().stream().forEach(vendedor -> {
            tabela.addRow(new Object[]{vendedor.getId(),
                vendedor.getNome(),
                vendedor.getCpf(),
                vendedor.getEmail(),
                vendedor.getEndereco().getCidade().getDescricao(),
                vendedor.getEndereco().getBairro().getDescricao(),
                vendedor.getPercentagemComissaoVenda(),
                vendedor.getPercentagemComissaoRecebimento(),
            });
        });
    }
    
    private void carregarEventListener() {
        tela.getBotaoCarregar().addMouseListener(new MouseAdapter() {
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
    
    private void sairEventListener() {
        tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }
    
    private void carregarEventAction() {
        int index = tela.getTable().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTable().getValueAt(index, 0);
            carregarCallBack.accept(VendedorService.readById(id));
            tela.dispose();
        }
    }
    
    private void sairEventAction(MouseEvent evt) {
        tela.dispose();
    }
}