package br.com.praticas.loja.controller.busca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.praticas.loja.model.Bairro;
import br.com.praticas.loja.view.busca.TelaBusca;

public class ControllerBuscaBairro {
	
	@Autowired
	@Qualifier("fornecedor")
    private TelaBusca tela;

	@Autowired
    private BairroService bairroService;
    private Consumer<Bairro> carregarCallBack;

    public ControllerBuscaBairro(Consumer<Bairro> carregarCallBack) {
        this.carregarCallBack = carregarCallBack;
        init();
    }

    private void init() {
        addRows();
        this.tela.getTabela().setSelectionMode(0);
        carregarEventListener();
        sairEventListener();
        tela.setVisible(true);
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
            carregarCallBack.accept(bairroService.readById(id));
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
        bairroService.read().stream().forEach(bairro -> {
            tabela.addRow(new Object[]{bairro.getId(),
                bairro.getDescricao()
            });
        });
    }
}
