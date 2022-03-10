package controller.cadastro;

import controller.busca.ControllerBuscaBairro;
import controller.busca.ControllerBuscaCidade;
import controller.busca.ControllerBuscaVenda;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Venda;
import service.VendaService;
import view.cadastro.TelaCadastroVenda;

public class ControllerCadastroVenda {

    private TelaCadastroVenda tela;
    private Venda venda;
    private VendaService vendaService;

    public ControllerCadastroVenda() {
        tela = new TelaCadastroVenda();
        init();
    }

    public Venda getVenda() {
        try {
            venda.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
        venda.setCep(tela.getCep().getText());
        venda.setLogradouro(tela.getLogradouro().getText());

        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda.setId(venda.getId());
        this.tela.getId().setText(String.valueOf(venda.getId()));
        this.venda.setCep(venda.getCep());
        this.tela.getCep().setText(venda.getCep());
        this.venda.setLogradouro(venda.getLogradouro());
        this.tela.getLogradouro().setText(venda.getLogradouro());

        if (venda.getBairro() != null) {
            setBairro(venda.getBairro());
        }
        if (venda.getCidade() != null) {
            setCidade(venda.getCidade());
        }
    }

    private void setBairro(Bairro bairro) {
        Bairro vendaBairro = venda.getBairro();

        vendaBairro.setId(bairro.getId());
        vendaBairro.setDescricao(bairro.getDescricao());
        tela.getDescricaoBairro().setText(bairro.getDescricao());
    }

    private void setCidade(Cidade cidade) {
        Cidade vendaCidade = venda.getCidade();
 
        vendaCidade.setId(cidade.getId());
        vendaCidade.setDescricao(cidade.getDescricao());
        tela.getDescricaoCidade().setText(cidade.getDescricao());
        vendaCidade.setUf(cidade.getUf());
        tela.getUfCidade().setText(cidade.getUf());
    }

    private void novoEventListener() {
        this.tela.getBotaoNovo().addMouseListener(new MouseAdapter() {
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
        this.tela.getBotaoGravar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                gravarEventAction(evt);
            }
        });
    }

    private void buscarEventListener() {
        this.tela.getBotaoBuscar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarEventAction(evt);
            }
        });
    }

    private void sairEventListener() {
        this.tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }

    private void adicionarBairroEventListener() {
        this.tela.getBotaoAdicionarBairro().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cadastoBairroEventAction(evt);
            }
        });
    }

    private void adicionarCidadeEventListener() {
        this.tela.getBotaoAdicionarCidade().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                adicionarCidadeEventAction(evt);
            }
        });
    }

    private void buscarBairroEventListener() {
        tela.getBotaoBuscaBairro().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarBairroEventAction(evt);
            }
        });
    }
    
    private void buscarCidadeEventListener() {
        tela.getBotaoBuscarCidade().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarCidadeEventAction(evt);
            }
        });
    }
    
    private void buscarCidadeEventAction(MouseEvent evt) {
        if (tela.getBotaoBuscarCidade().isEnabled()) {
            ControllerBuscaCidade con = new ControllerBuscaCidade(cidade -> {
                setCidade(cidade);
                setFormStatus(true);
            });
        }
    }

    private void buscarBairroEventAction(MouseEvent evt) {
        if (tela.getBotaoBuscaBairro().isEnabled()) {
            ControllerBuscaBairro con = new ControllerBuscaBairro(bairro -> {
                setBairro(bairro);
                setFormStatus(true);
            });
        }
    }

    private void novoEventAction(MouseEvent evt) {
        if (tela.getBotaoNovo().isEnabled()) {
            setFormStatus(true);
        }
    }

    private void cancelarEventAction(MouseEvent evt) {
        if (tela.getBotaoCancelar().isEnabled()) {
            setFormStatus(false);
            venda = new Venda();
            cleanForm();
        }
    }

    private void gravarEventAction(MouseEvent evt) {
        if (!tela.getBotaoGravar().isEnabled()) {
            return;
        }
        try {
            vendaService.createOrUpdate(getVenda());
            setFormStatus(false);
            venda = new Venda();
            cleanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, e.getMessage());
        }
    }

    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaVenda buscaController = new ControllerBuscaVenda(venda -> {
            setVenda(venda);
            setFormStatus(true);
        });
    }

    private void adicionarCidadeEventAction(MouseEvent evt) {
        ControllerCadastroCidade controllerCadastroCidade = new ControllerCadastroCidade();
    }

    private void cadastoBairroEventAction(MouseEvent evt) {
        ControllerCadastroBairro controllerCadastroBairro = new ControllerCadastroBairro();
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }

    public void setFormStatus(boolean status) {
        tela.getLogradouro().setEnabled(status);
        tela.getCep().setEnabled(status);
        tela.getBotaoNovo().setEnabled(!status);
        tela.getBotaoCancelar().setEnabled(status);
        tela.getBotaoGravar().setEnabled(status);
        tela.getBotaoAdicionarBairro().setEnabled(status);
        tela.getBotaoBuscarBairro().setEnabled(status);
        tela.getBotaoAdicionarCidade().setEnabled(status);
        tela.getBotaoBuscarCidade().setEnabled(status);
    }

    private void cleanForm() {
        tela.getId().setText("");
        tela.getCep().setText("");
        tela.getLogradouro().setText("");
        tela.getDescricaoBairro().setText("");
        tela.getDescricaoCidade().setText("");
        tela.getUfCidade().setText("");
    }

    private void setDisabledForms() {
        tela.getId().setEnabled(false);
        tela.getDescricaoBairro().setEditable(false);
        tela.getDescricaoCidade().setEditable(false);
        tela.getUfCidade().setEditable(false);
    }
    
     private void init() {
        vendaService = new VendaService();
        venda = new Venda();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        adicionarBairroEventListener();
        buscarBairroEventListener();
        buscarCidadeEventListener();
        adicionarCidadeEventListener();
        setDisabledForms();
        setFormStatus(false);
        tela.setVisible(true);
    }

    public static void main(String[] args) {
        ControllerCadastroVenda controllerCadastroVenda = new ControllerCadastroVenda();
    }
}
