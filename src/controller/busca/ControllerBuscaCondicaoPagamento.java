package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
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
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTable().getModel();
        condicaoPagamentoService.read().stream().forEach(condicaoPagamento -> {
            tabela.addRow(new Object[]{condicaoPagamento.getId(),
                condicaoPagamento.getDescricao(),
                condicaoPagamento.getNumeroDiasAtePrimeiraParcela(),
                condicaoPagamento.getNumeroDiasEntreParcelas()
            });
        });
    }
}
