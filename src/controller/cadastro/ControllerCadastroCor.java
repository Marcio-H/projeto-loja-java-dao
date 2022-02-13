package controller.cadastro;

import controller.busca.ControllerBuscaCor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Cor;
import service.CorService;
import view.cadastro.TelaCadastroCor;

public class ControllerCadastroCor {
    
    private TelaCadastroCor tela;
    private Cor cor;
    private CorService corService;
    
    public ControllerCadastroCor() {
        tela = new TelaCadastroCor();
        init();
    }

    public ControllerCadastroCor(TelaCadastroCor telaCadastroCor) {
        this.tela = telaCadastroCor;
        init();
    }
    
    private void init() {
        corService = new CorService();
        cor = new Cor();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
        this.tela.setVisible(true);
    }
    
    public Cor getCor() {
        try {
            cor.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {}
        cor.setDescricao(tela.getDescricaoTextField().getText());
        
        return cor;
    }
    
    public void setCor(Cor cor) {
        this.cor.setId(cor.getId());
        this.tela.getId().setText(String.valueOf(cor.getId()));
        this.cor.setDescricao(cor.getDescricao());
        this.tela.getDescricaoTextField().setText(cor.getDescricao());
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
            corService.createOrUpdate(getCor());
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
        ControllerBuscaCor buscaController = new ControllerBuscaCor(this);
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
    
    public static void main(String[] args) {
        ControllerCadastroCor controllerCadastroCor = new ControllerCadastroCor();
        
        controllerCadastroCor.tela.setVisible(true);
    }
}
