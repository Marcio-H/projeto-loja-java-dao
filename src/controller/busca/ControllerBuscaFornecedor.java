package controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import service.FornecedorService;
import view.busca.TelaBuscaFornecedor;

public class ControllerBuscaFornecedor {
    
    private TelaBuscaFornecedor tela;
    private FornecedorService fornecedorService;
    private Consumer<Fornecedor> carregarCallBack;
    
    public ControllerBuscaFornecedor(Consumer<Fornecedor> carregarCallBack) {
        tela = new TelaBuscaFornecedor();
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        fornecedorService = new FornecedorService();
        addRows();
        this.tela.getTable().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        tela.setVisible(true);
    }
    
    private void addRows() {
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTable().getModel();
        fornecedorService.read().stream().forEach(fornecedor -> {
            tabela.addRow(new Object[]{fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getEmail(),
                fornecedor.getRazaoSocial()
            });
        });
    }
    
    private void carregarEventListener() {
        tela.getBotaoCarregar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                carregarEventAction(evt);
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
    
    private void carregarEventAction(MouseEvent evt) {
        int index = tela.getTable().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTable().getValueAt(index, 0);
            carregarCallBack.accept(fornecedorService.readById(id));
            tela.dispose();
        }
    }
    
    private void sairEventAction(MouseEvent evt) {
        tela.dispose();
    }
}
