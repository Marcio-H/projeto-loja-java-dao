package controller.cadastro;

import controller.busca.ControllerBuscaBairro;
import controller.busca.ControllerBuscaCidade;
import controller.busca.ControllerBuscaEndereco;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
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

    public Endereco getEndereco() {
        try {
            endereco.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
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

        if (endereco.getBairro() != null) {
            setBairro(endereco.getBairro());
        }
        if (endereco.getCidade() != null) {
            setCidade(endereco.getCidade());
        }
    }

    private void setBairro(Bairro bairro) {
        Bairro enderecoBairro = endereco.getBairro();

        enderecoBairro.setId(bairro.getId());
        enderecoBairro.setDescricao(bairro.getDescricao());
        tela.getDescricaoBairro().setText(bairro.getDescricao());
    }

    private void setCidade(Cidade cidade) {
        Cidade enderecoCidade = endereco.getCidade();

        enderecoCidade.setId(cidade.getId());
        enderecoCidade.setDescricao(cidade.getDescricao());
        tela.getDescricaoCidade().setText(cidade.getDescricao());
        enderecoCidade.setUf(cidade.getUf());
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
            endereco = new Endereco();
        }
    }

    private void cancelarEventAction(MouseEvent evt) {
        if (tela.getBotaoCancelar().isEnabled()) {
            setFormStatus(false);
            cleanForm();
        }
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
            JOptionPane.showMessageDialog(tela, e.getMessage());
        }
    }

    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaEndereco buscaController = new ControllerBuscaEndereco(endereco -> {
            setEndereco(endereco);
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
        enderecoService = new EnderecoService();
        endereco = new Endereco();
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
    }

    public static void main(String[] args) {
        ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco();

        controllerCadastroEndereco.tela.setVisible(true);
    }
}
