package controller.cadastro;

//import controller.busca.ControllerBuscaMarca;
import controller.cadastro.ControllerCadastroTamanho;
import controller.cadastro.ControllerCadastroMarca;
import controller.cadastro.ControllerCadastroTipoProduto;
import controller.busca.ControllerBuscaTamanho;
import controller.busca.ControllerBuscaMarca;
import controller.busca.ControllerBuscaTipoProduto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Marca;
import model.bo.Tamanho;
import model.bo.TipoProduto;
import model.bo.Produto;
import service.ProdutoService;
import view.cadastro.TelaCadastroProduto;

public class ControllerCadastroProduto {
    
    private TelaCadastroProduto tela;
    private Produto produto;
    private ProdutoService produtoService;
    
    public ControllerCadastroProduto() {
        tela = new TelaCadastroProduto();
        init();
    }

    public ControllerCadastroProduto(TelaCadastroProduto telaCadastroProduto) {
        this.tela = telaCadastroProduto;
        init();
    }
    
    private void init() {
        produtoService = new ProdutoService();
        produto = new Produto();
        produto.setMarca(new Marca());
        produto.setTipoProduto(new TipoProduto());
        produto.setTamanho(new Tamanho());
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        cadastroTamanhoEventListener();
        cadastroMarcaEventListener();
        cadastroTipoProdutoEventListener();
        buscarTamanhoEventListener();
        buscarMarcaEventListener();
        buscarTipoProdutoEventListener();
        this.tela.getId().setEnabled(false);
        this.tela.getTamanhoTextField().setEnabled(false);
        this.tela.getMarcaTextField().setEnabled(false);
        this.tela.getTipoProdutoTextField().setEnabled(false);
        setFormStatus(false);
        tela.setVisible(true);
    }
    
    public Produto getProduto() {
        try {
            produto.setId(Long.parseLong(tela.getId().getText()));  
        } catch (Exception e) {}
          produto.setDescricao(tela.getDescricaoTextField().getText());
          produto.setValor( (float) tela.getValorFormattedTextField().getValue());
        
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto.setId(produto.getId());
        this.tela.getId().setText(String.valueOf(produto.getId()));
        this.produto.setDescricao(produto.getDescricao());
        this.tela.getDescricaoTextField().setText(produto.getDescricao());
        this.produto.setValor(produto.getValor());
        this.tela.getValorFormattedTextField().setText(String.valueOf(produto.getValor()));
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
            produtoService.createOrUpdate(getProduto());
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

    private void cadastroTamanhoEventListener() {
       this.tela.getAdicionarTamanhoBotao().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              cadastroTamanhoEventAction(evt);
           }
       });
    }
        
    private void cadastroMarcaEventListener() {
        this.tela.getAdicionarMarcaBotao().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              cadastroMarcaEventAction(evt);
           }
       });
    }
    
    private void cadastroTipoProdutoEventListener() {
        this.tela.getAdicionarTipoProdutoBotao().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              cadastroTipoProdutoEventAction(evt);
           }
       });
    }

    private void buscarTamanhoEventListener() {
       this.tela.getBuscarTamanhoBotao().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              buscarTamanhoEventAction(evt);
           }
       });
    }

    private void buscarMarcaEventListener() {
        this.tela.getBuscarMarcaBotao().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              buscarMarcaEventAction(evt);
           }
       });
    }

    private void buscarTipoProdutoEventListener() {
        this.tela.getBuscarTipoProdutoBotao().addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent evt) {
              buscarTipoProdutoEventAction(evt);
           }
       });
    }

    private void cadastroMarcaEventAction(MouseEvent evt) {
       ControllerCadastroMarca controllerCadastroMarca = new ControllerCadastroMarca();
    }

    private void cadastroTamanhoEventAction(MouseEvent evt) {
       ControllerCadastroTamanho controllerCadastroTamanho = new ControllerCadastroTamanho();
    }

    private void cadastroTipoProdutoEventAction(MouseEvent evt) {
       ControllerCadastroTipoProduto controllerCadastroTipoProduto = new ControllerCadastroTipoProduto();
    }    
    
    private void buscarTamanhoEventAction(MouseEvent evt) {
       ControllerBuscaTamanho con = new ControllerBuscaTamanho(tamanho -> {
          this.tela.getTamanhoTextField().setText(tamanho.getDescricao());
          this.produto.setTamanho(tamanho);
       });
    }
    
    private void buscarMarcaEventAction(MouseEvent evt) {
        ControllerBuscaMarca con = new  ControllerBuscaMarca(marca -> {
            this.tela.getMarcaTextField().setText(marca.getDescricao());
            this.produto.setMarca(marca);
        });
    }

   private void buscarTipoProdutoEventAction(MouseEvent evt) {
        ControllerBuscaTipoProduto con = new  ControllerBuscaTipoProduto(tipoProduto -> {
            this.tela.getTipoProdutoTextField().setText(tipoProduto.getDescricao());
            this.produto.setTipoProduto(tipoProduto);
        });
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }
    
    public void setFormStatus(boolean status) {
        this.tela.getTamanhoTextField().setEnabled(status);
        this.tela.getTipoProdutoTextField().setEnabled(status);
        this.tela.getMarcaTextField().setEnabled(status);
        this.tela.getValorFormattedTextField().setEnabled(status);
        this.tela.getDescricaoTextField().setEnabled(status);
        this.tela.getBotaoNovo().setEnabled(!status);
        this.tela.getBotaoCancelar().setEnabled(status);
        this.tela.getBotaoGravar().setEnabled(status);
        this.tela.getBuscarMarcaBotao().setEnabled(status);
        this.tela.getBuscarTamanhoBotao().setEnabled(status);
        this.tela.getBuscarTipoProdutoBotao().setEnabled(status);
        this.tela.getAdicionarMarcaBotao().setEnabled(status);
        this.tela.getAdicionarTamanhoBotao().setEnabled(status);
        this.tela.getAdicionarTipoProdutoBotao().setEnabled(status);
    }
    
    private void cleanForm() {
        this.tela.getId().setText("");
        this.tela.getDescricaoTextField().setText(""); 
        this.tela.getTamanhoTextField().setText("");
        this.tela.getValorFormattedTextField().setText("");
        this.tela.getMarcaTextField().setText("");
        this.tela.getTipoProdutoTextField().setText("");
        this.tela.getTamanhoTextField().setText("");
    }
    
    public static void main(String[] args) {
        ControllerCadastroProduto controllerCadastroProduto = new ControllerCadastroProduto();
        
        controllerCadastroProduto.tela.setVisible(true);
    }
}
