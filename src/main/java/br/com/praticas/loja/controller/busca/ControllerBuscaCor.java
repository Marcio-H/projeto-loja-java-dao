package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import model.bo.Cor;
import service.CorService;
import view.busca.TelaBuscaCor;

public class ControllerBuscaCor {

    private TelaBuscaCor tela;
    private CorService corService;
    private Consumer<Cor> carregarCallBack;

    public ControllerBuscaCor(Consumer<Cor> carregarCallBack) {
        tela = new TelaBuscaCor();
        this.carregarCallBack = carregarCallBack;
        init();
    }

    private void init() {
        tela.setVisible(true);
        corService = new CorService();
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
            carregarCallBack.accept(corService.readById(id));
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
        corService.read().stream().forEach(cor -> {
            tabela.addRow(new Object[]{cor.getId(),
                cor.getDescricao()
            });
        });
    }
}
