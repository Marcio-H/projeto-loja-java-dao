package controller.cadastro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import model.bo.Fornecedor;
import model.bo.Telefone;
import service.FornecedorService;
import view.cadastro.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor {

    private TelaCadastroFornecedor tela;
    private Fornecedor fornecedor;
    private FornecedorService fornecedorService;
    private List<Telefone> telefones;

    public ControllerCadastroFornecedor() {
        tela = new TelaCadastroFornecedor();
        init();
    }

    private void init() {
        fornecedorService = new FornecedorService();
        fornecedor = new Fornecedor();
        telefones = new ArrayList<>();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        deletarTelefoneEventListener();
        adicionarTelefoneEventListener();
        cleanForm();
        setFormStatus(false);
        setFieldsUnable();
    }

    public Fornecedor getFornecedor() {
        try {
            fornecedor.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
        fornecedor.setNome(tela.getNomeTextField().getText());
        fornecedor.setEmail(tela.getEmailTextField().getText());
        fornecedor.setComplementoEndereco(tela.getComplementoTextField().getText());
        //ver como vai setar endereço
        fornecedor.setRazaoSocial(tela.getRazaoSocialTextField().getText());
        fornecedor.setInscricaoEstadual(tela.getInscricaoEstadualFormattedTextField().getText());
        return fornecedor;
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
//            bairroService.createOrUpdate(getBairro());
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
//        ControllerBuscaBairro buscaController = new ControllerBuscaBairro(this);
    }

    private void sairEventListener() {
        this.tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }
    
    private void deletarTelefoneEventListener() {
        tela.getDeletarTelefoneBotao().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                deletarTelefoneEventAction(evt);
            }
        });
    }
    
    private void deletarTelefoneEventAction(MouseEvent evt) {
        if (!tela.getDeletarTelefoneBotao().isEnabled()) {
            return;
        }
        int index = tela.getTelefoneComboBox().getSelectedIndex();
        if (index >= 0) {
            telefones.remove(index); 
            tela.getTelefoneComboBox().removeItemAt(index);
        }
    }
    

    private void adicionarTelefoneEventListener() {
        tela.getAdicionarTelefoneBotao().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                adicionarTelefoneEventAction(evt);
            }
        });
    }

    private void adicionarTelefoneEventAction(MouseEvent evt) {
        if (!tela.getAdicionarTelefoneBotao().isEnabled()) {
            return;
        }

        ControllerCadastroTelefone con = new ControllerCadastroTelefone(telefone -> {
            telefones.add(telefone);
            tela.getTelefoneComboBox().addItem(telefone.getTelefone());
        });
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }

    private void setFormStatus(boolean status) {
        this.tela.getId().setEnabled(false);
        tela.getBotaoGravar().setEnabled(status);
        tela.getNomeTextField().setEnabled(status);
        tela.getEmailTextField().setEnabled(status);
        tela.getRazaoSocialTextField().setEnabled(status);
        tela.getComplementoTextField().setEnabled(status);
        tela.getCnpjFormattedTextField().setEnabled(status);
        tela.getInscricaoEstadualFormattedTextField().setEnabled(status);
        tela.getTelefoneComboBox().setEditable(status);
        tela.getDeletarTelefoneBotao().setEnabled(status);
        tela.getBotaoNovo().setEnabled(!status);
        tela.getBotaoCancelar().setEnabled(status);
        tela.getBuscarEnderecoBotao().setEnabled(status);
        tela.getAdicionarEnderecoBotao().setEnabled(status);
        tela.getAdicionarTelefoneBotao().setEnabled(status);
    }

    private void setFieldsUnable() {
        tela.getCepTextField().setEnabled(false);
        tela.getLogradouroTextField().setEnabled(false);
        tela.getCidadeTextField().setEnabled(false);
        tela.getBairroTextField().setEnabled(false);
        tela.getUfTextFIeld().setEnabled(false);
    }

    private void cleanForm() {
        tela.getId().setText("");
        tela.getNomeTextField().setText("");
        tela.getEmailTextField().setText("");
        tela.getRazaoSocialTextField().setText("");
        tela.getCepTextField().setText("");
        tela.getLogradouroTextField().setText("");
        tela.getCidadeTextField().setText("");
        tela.getBairroTextField().setText("");
        tela.getComplementoTextField().setText("");
        tela.getCnpjFormattedTextField().setText("");
        tela.getInscricaoEstadualFormattedTextField().setText("");
        tela.getTelefoneComboBox().removeAllItems();
    }

    public static void main(String[] args) {
        ControllerCadastroFornecedor controllerCadastroBairro = new ControllerCadastroFornecedor();

        controllerCadastroBairro.tela.setVisible(true);
    }
}
