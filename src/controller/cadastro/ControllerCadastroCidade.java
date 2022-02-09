package controller.cadastro;

import controller.busca.ControllerBuscaCidade;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Cidade;
import service.CidadeService;
import view.cadastro.TelaCadastroCidade;

public class ControllerCadastroCidade {
    
    private TelaCadastroCidade tela;
    private Cidade cidade;
    private CidadeService cidadeService;
    
    public ControllerCadastroCidade() {
        tela = new TelaCadastroCidade();
        init();
    }

    public ControllerCadastroCidade(TelaCadastroCidade telaCadastroCidade) {
        this.tela = telaCadastroCidade;
        init();
    }
    
    private void init() {
        cidadeService = new CidadeService();
        cidade = new Cidade();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
    }
    
    public Cidade getCidade() {
        try {
            cidade.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {}
        cidade.setDescricao(tela.getDescricaoTextField().getText());
        cidade.setUf(tela.getUfTextField().getText());
        
        return cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade.setId(cidade.getId());
        this.tela.getId().setText(String.valueOf(cidade.getId()));
        this.cidade.setDescricao(cidade.getDescricao());
        this.tela.getDescricaoTextField().setText(cidade.getDescricao());
        this.cidade.setUf(cidade.getUf());
        this.tela.getUfTextField().setText(cidade.getUf());
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
            cidadeService.createOrUpdate(getCidade());
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
        ControllerBuscaCidade buscaController = new ControllerBuscaCidade(this);
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
        this.tela.getUfTextField().setEnabled(status);
        this.tela.getBotaoNovo().setEnabled(!status);
        this.tela.getBotaoCancelar().setEnabled(status);
        this.tela.getBotaoGravar().setEnabled(status);
    }
    
    private void cleanForm() {
        this.tela.getId().setText("");
        this.tela.getDescricaoTextField().setText("");
        this.tela.getUfTextField().setText("");
    }
    
    public static void main(String[] args) {
        ControllerCadastroCidade controllerCadastroCidade = new ControllerCadastroCidade();
        
        controllerCadastroCidade.tela.setVisible(true);
    }
}
