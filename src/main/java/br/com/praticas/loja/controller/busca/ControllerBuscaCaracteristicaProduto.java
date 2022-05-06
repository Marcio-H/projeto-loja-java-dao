package br.com.praticas.loja.controller.busca;

import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.AbstractAction;
import static javax.swing.JComponent.WHEN_FOCUSED;
import static javax.swing.KeyStroke.getKeyStroke;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.praticas.loja.model.CaracteristicaProduto;
import br.com.praticas.loja.view.busca.TelaBusca;

public class ControllerBuscaCaracteristicaProduto {
	
	@Autowired
	@Qualifier("caracteristica_produto")
    private TelaBusca tela;

	
    private CaracteristicaProdutoService caracteristicaProdutoService;
    private Consumer<CaracteristicaProduto> carregarCallBack;

     public ControllerBuscaCaracteristicaProduto(Consumer<CaracteristicaProduto> carregarCallBack) {
        this.carregarCallBack = carregarCallBack;
        init();
    }

    private void init() {
        tela.setVisible(true);
        caracteristicaProdutoService = new CaracteristicaProdutoService();
        addRows();
        this.tela.getTabela().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        carregarToEnterEventListener();
    }
    
    private void carregarEventListener() {
        tela.getBotaoCarregar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                carregarEventAction();
            }
        });
    }
    
    private void carregarEventAction() {
        int index = tela.getTabela().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTabela().getValueAt(index, 0);
            carregarCallBack.accept(caracteristicaProdutoService.readById(id));
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
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTabela().getModel();
        caracteristicaProdutoService.read().stream().forEach(caracteristicaProduto -> {
            tabela.addRow(new Object[]{ caracteristicaProduto.getId(), 
                                        caracteristicaProduto.getBarra(),
                                        caracteristicaProduto.getProduto().getDescricao(),
                                        caracteristicaProduto.getTamanho(),
                                        caracteristicaProduto.getEstoque(),
                                        caracteristicaProduto.getCor().getDescricao(),

            });
        });
    }
    
    private void carregarToEnterEventListener() {
        tela.getTabela().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getTabela().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarEventAction();
            }
        });
    }
}
