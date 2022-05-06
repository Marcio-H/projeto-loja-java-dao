package br.com.praticas.loja.controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.praticas.loja.model.Cidade;
import br.com.praticas.loja.view.busca.TelaBusca;

public class ControllerBuscaCidade {
    
	@Autowired
	@Qualifier("cidade")
    private TelaBusca tela;

	
    private CidadeService cidadeService;

    private Consumer<Cidade> carregarCallBack;
    
    public ControllerBuscaCidade(Consumer<Cidade> carregarCallBack) {
        this.carregarCallBack = carregarCallBack;
        init();
    }
    
    private void init() {
        tela.setVisible(true);
        cidadeService = new CidadeService();
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
            carregarCallBack.accept(cidadeService.readById(id));
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
        cidadeService.read().stream().forEach(cidade -> {
            tabela.addRow(new Object[]{ cidade.getId(), 
                                        cidade.getDescricao(),
                                        cidade.getUf()
            });
        });
    }
}
