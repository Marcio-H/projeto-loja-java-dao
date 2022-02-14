package controller.cadastro;

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
        tela.getId().setEnabled(false);
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

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }
    
    public void setFormStatus(boolean status) {
        this.tela.getBotaoNovo().setEnabled(!status);
        this.tela.getBotaoCancelar().setEnabled(status);
        this.tela.getBotaoGravar().setEnabled(status);
    }
    
    private void cleanForm() {
        this.tela.getId().setText("");
    }
    
    public static void main(String[] args) {
        ControllerCadastroProduto con = new ControllerCadastroProduto();
    }
}
