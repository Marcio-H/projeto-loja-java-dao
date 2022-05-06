package br.com.praticas.loja.controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.praticas.loja.model.Marca;
import br.com.praticas.loja.view.busca.TelaBusca;

public class ControllerBuscaMarca {

	@Autowired
	@Qualifier("marca")
    private TelaBusca tela;

	
    private MarcaService marcaService;
    private Consumer<Marca> carregarCallBack;

     public ControllerBuscaMarca(Consumer<Marca> carregarCallBack) {
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        marcaService = new MarcaService();
        addRows();
        this.tela.getTabela().setSelectionMode(0);
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
        int index = tela.getTabela().getSelectedRow();
        if (index >= 0) {
            Long id = (long) tela.getTabela().getValueAt(index, 0);
            carregarCallBack.accept(marcaService.readById(id));
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
        marcaService.read().stream().forEach(marca -> {
            tabela.addRow(new Object[]{ marca.getId(), 
                                        marca.getDescricao()
            });
        });
    }
}
