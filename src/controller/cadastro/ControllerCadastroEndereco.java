package controller.cadastro;

//import controller.busca.ControllerBuscaMarca;
import controller.cadastro.ControllerCadastroBairro;
import controller.cadastro.ControllerCadastroCidade;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import service.EnderecoService;
import view.cadastro.TelaCadastroEndereco;

public class ControllerCadastroEndereco {
    
    private TelaCadastroEndereco tela;
    private Endereco endereco;
    private EnderecoService enderecoService;
    
    public ControllerCadastroEndereco() {
        tela = new TelaCadastroEndereco();
        init();
    }

    public ControllerCadastroEndereco(TelaCadastroEndereco telaCadastroEndereco) {
        this.tela = telaCadastroEndereco;
        init();
    }
    
    private void init() {
        enderecoService = new EnderecoService();
        endereco = new Endereco();
        endereco.setCidade(new Cidade());
        endereco.setBairro(new Bairro());
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        cadastroBairroEventListener();
        cadastroCidadeEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
    }
    
    public Endereco getEndereco() {
        try {
            endereco.setId(Long.parseLong(tela.getId().getText()));  
        } catch (Exception e) {}
          endereco.setCep(tela.getCep().getText());
          endereco.setLogradouro(tela.getLogradouro().getText());
        
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco.setId(endereco.getId());
        this.tela.getId().setText(String.valueOf(endereco.getId()));
        this.endereco.setCep(endereco.getCep());
        this.tela.getCep().setText(endereco.getCep());
        this.endereco.setLogradouro(endereco.getLogradouro());
        this.tela.getLogradouro().setText(endereco.getLogradouro());
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
            enderecoService.createOrUpdate(getEndereco());
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
//        ControllerBuscaMarca buscaController = new ControllerBuscaMarca(this);
    }
    
    private void sairEventListener() {
        this.tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }

    private void cadastroBairroEventListener() {
       this.tela.getBotaoAdicionarBairro().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              cadastoBairroEventAction(evt);
           }
       });
    }
        
    private void cadastroCidadeEventListener() {
        this.tela.getBotaoAdicionarCidade().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              cadastoCidadeEventAction(evt);
           }
       });
    }

    private void cadastoCidadeEventAction(MouseEvent evt) {
       ControllerCadastroCidade controllerCadastroCidade = new ControllerCadastroCidade();
    }

    private void cadastoBairroEventAction(MouseEvent evt) {
       ControllerCadastroBairro controllerCadastroBairro = new ControllerCadastroBairro();
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }
    
    public void setFormStatus(boolean status) {
        this.tela.getLogradouro().setEnabled(status);
        this.tela.getCep().setEnabled(status);
        this.tela.getBotaoNovo().setEnabled(!status);
        this.tela.getBotaoCancelar().setEnabled(status);
        this.tela.getBotaoGravar().setEnabled(status);
    }
    
    private void cleanForm() {
        this.tela.getId().setText("");
        this.tela.getCep().setText(""); 
        this.tela.getLogradouro().setText("");
    }
    
    public static void main(String[] args) {
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco();
        
        controllerCadastroEndereco.tela.setVisible(true);
    }
}
