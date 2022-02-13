package controller.cadastro;

import controller.busca.ControllerBuscaBairro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Bairro;
import service.BairroService;
import view.cadastro.TelaCadastroBairro;

public class ControllerCadastroBairro {
    
    private TelaCadastroBairro tela;
    private Bairro bairro;
    private BairroService bairroService;
    
    public ControllerCadastroBairro() {
        tela = new TelaCadastroBairro();
        init();
    }

    public ControllerCadastroBairro(TelaCadastroBairro telaCadastroBairro) {
        this.tela = telaCadastroBairro;
        init();
    }
    
    private void init() {
        bairroService = new BairroService();
        bairro = new Bairro();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
        this.tela.setVisible(true);
    }
    
    public Bairro getBairro() {
        try {
            bairro.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {}
        bairro.setDescricao(tela.getDescricaoTextField().getText());
        
        return bairro;
    }
    
    public void setCidade(Bairro bairro) {
        this.bairro.setId(bairro.getId());
        this.tela.getId().setText(String.valueOf(bairro.getId()));
        this.bairro.setDescricao(bairro.getDescricao());
        this.tela.getDescricaoTextField().setText(bairro.getDescricao());
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
            bairroService.createOrUpdate(getBairro());
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
        ControllerBuscaBairro buscaController = new ControllerBuscaBairro(bairro -> {
            
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
    
    public static void main(String[] args) {
        ControllerCadastroBairro controllerCadastroBairro = new ControllerCadastroBairro();
        
        controllerCadastroBairro.tela.setVisible(true);
    }
}
