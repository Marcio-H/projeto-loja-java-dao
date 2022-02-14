package controller.cadastro;

import controller.busca.ControllerBuscaTamanho;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Tamanho;
import service.TamanhoService;
import view.cadastro.TelaCadastroTamanho;


public class ControllerCadastroTamanho {
    private TelaCadastroTamanho tela;
    private Tamanho tamanho;
    private TamanhoService bairroService;
    
    public ControllerCadastroTamanho() {
        tela = new TelaCadastroTamanho();
        init();
    }

    public ControllerCadastroTamanho(TelaCadastroTamanho telaCadastroTamanho) {
        this.tela = telaCadastroTamanho;
        init();
    }
    
    private void init() {
        bairroService = new TamanhoService();
        tamanho = new Tamanho();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
    }
    
    public Tamanho getCidade() {
        try {
            tamanho.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {}
        tamanho.setDescricao(tela.getDescricaoTextField().getText());
        
        return tamanho;
    }
    
    public void setCidade(Tamanho tamanho) {
        this.tamanho.setId(tamanho.getId());
        this.tela.getId().setText(String.valueOf(tamanho.getId()));
        this.tamanho.setDescricao(tamanho.getDescricao());
        this.tela.getDescricaoTextField().setText(tamanho.getDescricao());
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
            bairroService.createOrUpdate(getCidade());
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
        ControllerBuscaTamanho buscaController = new ControllerBuscaTamanho(tamanho -> {
            this.tamanho.setId(tamanho.getId());
            this.tela.getId().setText(String.valueOf(tamanho.getId()));
            this.tamanho.setDescricao(tamanho.getDescricao());
            this.tela.getDescricaoTextField().setText(tamanho.getDescricao());
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
        ControllerCadastroTamanho controllerCadastroTamanho = new ControllerCadastroTamanho();
        
        controllerCadastroTamanho.tela.setVisible(true);
    }
}
