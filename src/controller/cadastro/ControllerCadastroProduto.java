package controller.cadastro;

//import controller.busca.ControllerBuscaMarca;
import controller.cadastro.ControllerCadastroTamanho;
import controller.cadastro.ControllerCadastroMarca;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Marca;
import model.bo.Tamanho;
import model.bo.TipoProduto;
import model.bo.Produto;
import service.EnderecoService;
import view.cadastro.TelaCadastroProduto;

public class ControllerCadastroProduto {
    
    private TelaCadastroProduto tela;
    private Produto produto;
    private EnderecoService enderecoService;
    
    public ControllerCadastroProduto() {
        tela = new TelaCadastroProduto();
        init();
    }

    public ControllerCadastroProduto(TelaCadastroProduto telaCadastroProduto) {
        this.tela = telaCadastroProduto;
        init();
    }
    
    private void init() {
        enderecoService = new EnderecoService();
        produto = new Produto();
        produto.setMarca(new Marca());
        produto.setTipoProduto(new TipoProduto());
        produto.setTamanho(new Tamanho());
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
    
    public Produto getEndereco() {
        try {
            produto.setId(Long.parseLong(tela.getId().getText()));  
        } catch (Exception e) {}
          produto.setDescricao(tela.getDescricaoTextField().getText());
          produto.setValor( (float) tela.getValorFormattedTextField().getValue());
        
        return produto;
    }
    
    public void setEndereco(Produto produto) {
        this.produto.setId(produto.getId());
        this.tela.getId().setText(String.valueOf(produto.getId()));
        this.produto.setDescricao(produto.getDescricao());
        this.tela.getDescricaoTextField().setText(produto.getDescricao());
        this.produto.setValor(produto.getValor());
        this.tela.getValorFormattedTextField().setText((String) produto.getValor());
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
