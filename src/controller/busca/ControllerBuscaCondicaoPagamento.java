package controller.busca;

import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.AbstractAction;
import static javax.swing.JComponent.WHEN_FOCUSED;
import static javax.swing.KeyStroke.getKeyStroke;
import javax.swing.table.DefaultTableModel;
import model.bo.CondicaoPagamento;
import service.CondicaoPagamentoService;
import view.busca.TelaBuscaCondicaoPagamento;

public class ControllerBuscaCondicaoPagamento {
    
    private TelaBuscaCondicaoPagamento tela;
    private CondicaoPagamentoService condicaoPagamentoService;
    private Consumer<CondicaoPagamento> carregarCallBack;
    
    public ControllerBuscaCondicaoPagamento(Consumer<CondicaoPagamento> carregarCallBack) {
        tela = new TelaBuscaCondicaoPagamento();
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        condicaoPagamentoService = new CondicaoPagamentoService();
        addRows();
        this.tela.getTable().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        selectFirstRow();
        carregarToEnterEventListener();
    }

    private void selectFirstRow() {
        tela.getTable().requestFocus();
        tela.getTable().setRowSelectionInterval(0,0);
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
            carregarCallBack.accept(condicaoPagamentoService.readById(id));
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
    
    private void addRows() {
        DefaultTableModel tabela = (DefaultTableModel) tela.getTable().getModel();
        condicaoPagamentoService.read().stream().forEach(condicaoPagamento -> {
            tabela.addRow(new Object[]{condicaoPagamento.getId(),
                condicaoPagamento.getDescricao(),
                condicaoPagamento.getNumeroDiasAtePrimeiraParcela(),
                condicaoPagamento.getNumeroDiasEntreParcelas()
            });
        });
    }
}
