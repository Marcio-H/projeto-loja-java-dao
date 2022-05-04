package controller.cadastro;

import controller.busca.ControllerBuscaMarca;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Marca;
import service.MarcaService;
import view.cadastro.TelaCadastroMarca;

public class ControllerCadastroMarca {
    
    private TelaCadastroMarca tela;
    private Marca marca;
    private MarcaService marcaService;
    
    public ControllerCadastroMarca() {
        tela = new TelaCadastroMarca();
        init();
    }

    public ControllerCadastroMarca(TelaCadastroMarca telaCadastroMarca) {
        this.tela = telaCadastroMarca;
        init();
    }
    
    private void init() {
        marcaService = new MarcaService();
        marca = new Marca();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
        this.tela.setVisible(true);
    }
    
    public Marca getCidade() {
        try {
            marca.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {}
        marca.setDescricao(tela.getDescricaoTextField().getText());
        
        return marca;
    }
    
    public void setCidade(Marca bairro) {
        this.marca.setId(bairro.getId());
        this.tela.getId().setText(String.valueOf(bairro.getId()));
        this.marca.setDescricao(bairro.getDescricao());
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
            marca = new Marca();
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
            marcaService.createOrUpdate(getCidade());
            setFormStatus(false);
            marca = new Marca();
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
        ControllerBuscaMarca buscaController = new ControllerBuscaMarca(marca -> {
            this.marca.setId(marca.getId());
            this.tela.getId().setText(String.valueOf(marca.getId()));
            this.marca.setDescricao(marca.getDescricao());
            this.tela.getDescricaoTextField().setText(marca.getDescricao());
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
