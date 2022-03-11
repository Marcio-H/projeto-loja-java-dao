package controller.cadastro;

import controller.cadastro.ControllerCadastroTamanho;
import controller.cadastro.ControllerCadastroMarca;
import controller.cadastro.ControllerCadastroTipoProduto;
import controller.busca.ControllerBuscaTamanho;
import controller.busca.ControllerBuscaMarca;
import controller.busca.ControllerBuscaTipoProduto;
import controller.busca.ControllerBuscaProduto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
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
        setDisabledForms();
        setFormStatus(false);
        tela.setVisible(true);
    }
    
    public Produto getProduto() {
        try {
            produto.setId(Long.parseLong(tela.getId().getText()));  
        } catch (Exception e) {}
          produto.setDescricao(tela.getDescricaoTextField().getText());
         try {
            produto.setValor(
              Float.valueOf(tela.getValorFormattedTextField().getText())
            );
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, String.format("O valor \"%s\" é invalido para o campo \"Valor\"", e.getMessage()));
            throw new Error();
        }
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto.setId(produto.getId());
        this.tela.getId().setText(String.valueOf(produto.getId()));
        this.produto.setDescricao(produto.getDescricao());
        this.tela.getDescricaoTextField().setText(produto.getDescricao());
        this.produto.setValor(produto.getValor());
        this.tela.getValorFormattedTextField().setText(String.valueOf(produto.getValor()));

        if(produto.getMarca() != null) {
            setMarca(produto.getMarca());
        }

        if(produto.getTamanho()!= null) {
            setTamanho(produto.getTamanho());
        }

        if(produto.getTipoProduto()!= null) {
            setTipoProduto(produto.getTipoProduto());
        }
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
            produto = new Produto();
            cleanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, e.getMessage());
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
        ControllerBuscaProduto buscaController = new ControllerBuscaProduto(produto-> {
            setProduto(produto);
            setFormStatus(true);
        });
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
          setTamanho(tamanho);
          setFormStatus(true);
       });
    }
    
    private void buscarMarcaEventAction(MouseEvent evt) {
        ControllerBuscaMarca con = new  ControllerBuscaMarca(marca -> {
            setMarca(marca);
            setFormStatus(true);
        });
    }

   private void buscarTipoProdutoEventAction(MouseEvent evt) {
        ControllerBuscaTipoProduto con = new  ControllerBuscaTipoProduto(tipoProduto -> {
            setTipoProduto(tipoProduto);
            setFormStatus(true);
        });
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }
    private void setMarca(Marca marca) {
        Marca produtoMarca = produto.getMarca();
     
        produtoMarca.setId(marca.getId());
        produtoMarca.setDescricao(marca.getDescricao());
        tela.getMarcaTextField().setText(marca.getDescricao());
    }

    private void setTamanho(Tamanho tamanho) {
        Tamanho produtoTamanho = produto.getTamanho();
     
        produtoTamanho.setId(tamanho.getId());
        produtoTamanho.setDescricao(tamanho.getDescricao());
        tela.getTamanhoTextField().setText(tamanho.getDescricao());
    }     

    private void setTipoProduto(TipoProduto tipoProduto) {
        TipoProduto produtoTipoProduto = produto.getTipoProduto();

        produtoTipoProduto.setId(tipoProduto.getId());
        produtoTipoProduto.setDescricao(tipoProduto.getDescricao());
        tela.getTipoProdutoTextField().setText(tipoProduto.getDescricao());
    }

    private void setDisabledForms() {
        this.tela.getId().setEnabled(false);
        this.tela.getTamanhoTextField().setEditable(false);
        this.tela.getMarcaTextField().setEditable(false);
        this.tela.getTipoProdutoTextField().setEditable(false);
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
}
