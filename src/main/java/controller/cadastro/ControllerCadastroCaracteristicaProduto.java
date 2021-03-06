package controller.cadastro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import controller.busca.ControllerBuscaCaracteristicaProduto;
import controller.busca.ControllerBuscaCor;
import controller.busca.ControllerBuscaProduto;
import domain.CaracteristicaProduto;
import domain.Cor;
import domain.Produto;
import service.CaracteristicaProdutoService;
import view.cadastro.TelaCadastroCaracteristicaProduto;

public class ControllerCadastroCaracteristicaProduto {

    private TelaCadastroCaracteristicaProduto tela;
    private CaracteristicaProduto caracteristicaProduto;
    private CaracteristicaProdutoService caracteristicaProdutoService;

    public ControllerCadastroCaracteristicaProduto() {
        tela = new TelaCadastroCaracteristicaProduto();
        init();
    }

    public CaracteristicaProduto getCaracteristicaProduto() {
        try {
            caracteristicaProduto.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
        caracteristicaProduto.setTamanho(tela.getTamanho().getText());
        caracteristicaProduto.setBarra(tela.getCodigoBarras().getText());
        try {
            caracteristicaProduto.setEstoque(Long.parseLong(tela.getEstoque().getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, String.format("O valor \"%s\" é invalido para o campo \"Estoque\"", e.getMessage()));
            throw new Error();
        }

        return caracteristicaProduto;
    }

    public void setCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto) {
        this.caracteristicaProduto.setId(caracteristicaProduto.getId());
        this.caracteristicaProduto.setTamanho(caracteristicaProduto.getTamanho());
        this.caracteristicaProduto.setBarra(caracteristicaProduto.getBarra());
        this.caracteristicaProduto.setEstoque(caracteristicaProduto.getEstoque());

        tela.getId().setText(String.valueOf(caracteristicaProduto.getId()));
        tela.getTamanho().setText(caracteristicaProduto.getTamanho());
        tela.getCodigoBarras().setText(caracteristicaProduto.getBarra());
        tela.getEstoque().setText(String.valueOf(caracteristicaProduto.getEstoque()));

        setProduto(caracteristicaProduto.getProduto());
        setCor(caracteristicaProduto.getCor());
    }

    private void init() {
        caracteristicaProdutoService = new CaracteristicaProdutoService();
        caracteristicaProduto = new CaracteristicaProduto();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        buscaProdutoEventListener();
        buscaCorEventListener();
        sairEventListener();
        addCorEventListener();
        addProdutoEventListener();
        setFormStatus(false);
        disabledForms();
        tela.setVisible(true);
    }

    private void disabledForms() {
        tela.getId().setEnabled(false);
        tela.getDescricaoProduto().setEnabled(false);
        tela.getValorProduto().setEnabled(false);
        tela.getDescricaoCor().setEnabled(false);
    }

    private void setFormStatus(boolean status) {
        tela.getTamanho().setEnabled(status);
        tela.getEstoque().setEnabled(status);
        tela.getCodigoBarras().setEnabled(status);
        tela.getBotaoAddCor().setEnabled(status);
        tela.getBuscarCor().setEnabled(status);
        tela.getAddProduto().setEnabled(status);
        tela.getBuscarProduto().setEnabled(status);
        tela.getBotaoNovo().setEnabled(!status);
        tela.getBotaoCancelar().setEnabled(status);
        tela.getBotaoGravar().setEnabled(status);
    }

    private void cleanForm() {
        tela.getId().setText("");
        tela.getTamanho().setText("");
        tela.getEstoque().setText("");
        tela.getCodigoBarras().setText("");
        tela.getDescricaoCor().setText("");
        tela.getDescricaoProduto().setText("");
        tela.getValorProduto().setText("");
    }

    private void novoEventListener() {
        tela.getBotaoNovo().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                novoEventAction(evt);
            }
        });
    }

    private void cancelarEventListener() {
        this.tela.getBotaoCancelar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cancelarEventAction(evt);
            }
        });
    }

    private void gravarEventListener() {
        tela.getBotaoGravar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                gravarEventAction(evt);
            }
        });
    }

    private void buscarEventListener() {
        tela.getBotaoBuscar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarEventAction(evt);
            }
        });
    }

    private void sairEventListener() {
        tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }

    private void buscaCorEventListener() {
        tela.getBuscarCor().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscaCorEventAction(evt);
            }
        });
    }

    private void buscaProdutoEventListener() {
        tela.getBuscarProduto().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscaProdutoEventAction(evt);
            }
        });
    }

    private void addProdutoEventListener() {
        tela.getAddProduto().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addProdutoEventAction(evt);
            }
        });
    }

    private void addCorEventListener() {
        tela.getBotaoAddCor().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addCorEventAction(evt);
            }
        });
    }

    private void novoEventAction(MouseEvent evt) {
        if (tela.getBotaoNovo().isEnabled()) {
            setFormStatus(true);
        }
    }

    private void cancelarEventAction(MouseEvent evt) {
        if (tela.getBotaoCancelar().isEnabled()) {
            setFormStatus(false);
            caracteristicaProduto = new CaracteristicaProduto();
            cleanForm();
        }
    }

    private void gravarEventAction(MouseEvent evt) {
        if (!tela.getBotaoGravar().isEnabled()) {
            return;
        }
        try {
            caracteristicaProdutoService.createOrUpdate(getCaracteristicaProduto());
            setFormStatus(false);
            caracteristicaProduto = new CaracteristicaProduto();
            cleanForm();
        } catch (Exception e) {
            //implementar mensagem de erro
            e.printStackTrace();
        }
    }

    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaCaracteristicaProduto buscaController = new ControllerBuscaCaracteristicaProduto(cp -> {
            setCaracteristicaProduto(cp);
            setFormStatus(true);
        });
    }

    private void buscaCorEventAction(MouseEvent evt) {
        if (tela.getBotaoBuscar().isEnabled()) {
            ControllerBuscaCor con = new ControllerBuscaCor(cor -> {
                setCor(cor);
                setFormStatus(true);
            });
        }
    }

    private void buscaProdutoEventAction(MouseEvent evt) {
        if (tela.getBuscarProduto().isEnabled()) {
            ControllerBuscaProduto con = new ControllerBuscaProduto(produto -> {
                setProduto(produto);
                setFormStatus(true);
            });
        }
    }

    private void addProdutoEventAction(MouseEvent evt) {
        if (tela.getAddProduto().isEnabled()) {
            ControllerCadastroProduto con = new ControllerCadastroProduto();
        }
    }

    private void addCorEventAction(MouseEvent evt) {
        if (tela.getBotaoAddCor().isEnabled()) {
            ControllerCadastroCor con = new ControllerCadastroCor();
        }
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }

    private void setProduto(Produto produto) {
        Produto thisProduto = caracteristicaProduto.getProduto();

        thisProduto.setId(produto.getId());
        thisProduto.setDescricao(produto.getDescricao());
        thisProduto.setValor(produto.getValor());

        tela.getDescricaoProduto().setText(produto.getDescricao());
        tela.getValorProduto().setText(String.valueOf(produto.getValor()));
    }

    private void setCor(Cor cor) {
        Cor thiscor = caracteristicaProduto.getCor();

        thiscor.setId(cor.getId());
        thiscor.setDescricao(cor.getDescricao());

        tela.getDescricaoCor().setText(cor.getDescricao());
    }
}
