package controller.cadastro;

import controller.busca.ControllerBuscaTipoProduto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.TipoProduto;
import service.TipoProdutoService;
import view.cadastro.TelaCadastroTipoProduto;

public class ControllerCadastroTipoProduto {
    
    private TelaCadastroTipoProduto tela;
    private TipoProduto tipoProduto;
    private TipoProdutoService tipoProdutoService;
    
    public ControllerCadastroTipoProduto() {
        tela = new TelaCadastroTipoProduto();
        init();
    }

    public ControllerCadastroTipoProduto(TelaCadastroTipoProduto telaCadastroTipoProduto) {
        this.tela = telaCadastroTipoProduto;
        init();
    }
    
    private void init() {
        tipoProdutoService = new TipoProdutoService();
        tipoProduto = new TipoProduto();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
        this.tela.setVisible(true);
    }
    
    public TipoProduto getTipoProduto() {
        try {
            tipoProduto.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {}
        tipoProduto.setDescricao(tela.getDescricaoTextField().getText());
        
        return tipoProduto;
    }
    
    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto.setId(tipoProduto.getId());
        this.tela.getId().setText(String.valueOf(tipoProduto.getId()));
        this.tipoProduto.setDescricao(tipoProduto.getDescricao());
        this.tela.getDescricaoTextField().setText(tipoProduto.getDescricao());
    }
    
    private void novoEventListener() {
        this.tela.getBotaoNovo().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                novoEventAction(evt);
            }
        });
    }
    
     private void novoEventAction(MouseEvent evt) {
        if (tela.getBotaoNovo().isEnabled()) {
            setFormStatus(true);
        }
    }
    
    private void cancelarEventListener() {
        this.tela.getBotaoCancelar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cancelarEventAction(evt);
            }
        });
    }
    
    private void cancelarEventAction(MouseEvent evt) {
        if (tela.getBotaoCancelar().isEnabled()) {
            setFormStatus(false);
            cleanForm();
        }
    }
    
    private void gravarEventListener() {
        this.tela.getBotaoGravar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                gravarEventAction(evt);
            }
        });
    }
    
    private void gravarEventAction(MouseEvent evt) {
        if (!tela.getBotaoGravar().isEnabled()) {
            return;
        }
        try {
            tipoProdutoService.createOrUpdate(getTipoProduto());
            setFormStatus(false);
            cleanForm();
        } catch (Exception e) {
            //implementar mensagem de erro
            e.printStackTrace();
        }
    }
    
    private void buscarEventListener() {
        this.tela.getBotaoBuscar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarEventAction(evt);
            }
        });
    }
    
    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaTipoProduto busca = new ControllerBuscaTipoProduto(tipoProduto-> {
           this.tela.getId().setText(String.valueOf(tipoProduto.getId()));
           this.tela.getDescricaoTextField().setText(tipoProduto.getDescricao());
           this.tipoProduto.setId(tipoProduto.getId());
           this.tipoProduto.setDescricao(tipoProduto.getDescricao());
        });
    }
    
    private void sairEventListener() {
        this.tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }
    
    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }
    
    public void setFormStatus(boolean status) {
        this.tela.getDescricaoTextField().setEnabled(status);
        this.tela.getBotaoNovo().setEnabled(!status);
        this.tela.getBotaoCancelar().setEnabled(status);
        this.tela.getBotaoGravar().setEnabled(status);
    }
    
    private void cleanForm() {
        this.tela.getId().setText("");
        this.tela.getDescricaoTextField().setText("");
    }
}
