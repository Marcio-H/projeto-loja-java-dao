package controller.cadastro;

import controller.busca.ControllerBuscaEndereco;
import controller.busca.ControllerBuscaFornecedor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Fornecedor;
import model.bo.Telefone;
import service.FornecedorService;
import service.TelefoneService;
import view.cadastro.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor {

    private TelaCadastroFornecedor tela;
    private Fornecedor fornecedor;
    private FornecedorService fornecedorService;
    private TelefoneService telefoneService;
    private List<Telefone> telefones;

    public ControllerCadastroFornecedor() {
        tela = new TelaCadastroFornecedor();
        init();
    }

    public Fornecedor getFornecedor() {
        try {
            fornecedor.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
        fornecedor.setNome(tela.getNomeTextField().getText());
        fornecedor.setEmail(tela.getEmailTextField().getText());
        fornecedor.setComplementoEndereco(tela.getComplementoTextField().getText());
        fornecedor.setCnpj(tela.getCnpjFormattedTextField().getText());
        fornecedor.setRazaoSocial(tela.getRazaoSocialTextField().getText());
        fornecedor.setInscricaoEstadual(tela.getInscricaoEstadualFormattedTextField().getText());
        return fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor.setId(fornecedor.getId());
        tela.getId().setText(fornecedor.getId().toString());
        this.fornecedor.setNome(fornecedor.getNome());
        tela.getNomeTextField().setText(fornecedor.getNome());
        this.fornecedor.setEmail(fornecedor.getEmail());
        tela.getEmailTextField().setText(fornecedor.getEmail());
        this.fornecedor.setComplementoEndereco(fornecedor.getComplementoEndereco());
        tela.getComplementoTextField().setText(fornecedor.getComplementoEndereco());
        setEndereco(fornecedor.getEndereco());
        this.fornecedor.setRazaoSocial(fornecedor.getRazaoSocial());
        tela.getRazaoSocialTextField().setText(fornecedor.getRazaoSocial());
        this.fornecedor.setCnpj(fornecedor.getCnpj());
        tela.getCnpjFormattedTextField().setText(fornecedor.getCnpj());
        this.fornecedor.setInscricaoEstadual(fornecedor.getInscricaoEstadual());
        tela.getInscricaoEstadualFormattedTextField().setText(fornecedor.getInscricaoEstadual());
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

    private void deletarTelefoneEventListener() {
        tela.getDeletarTelefoneBotao().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                deletarTelefoneEventAction(evt);
            }
        });
    }

    private void adicionarTelefoneEventListener() {
        tela.getAdicionarTelefoneBotao().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                adicionarTelefoneEventAction(evt);
            }
        });
    }
    
    private void adicionarEnderecoEventListener() {
        tela.getAdicionarEnderecoBotao().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                adicionarEnderecoEventAction(evt);
            }
        });
    }
    
    private void buscarEnderecoEventListener() {
        tela.getBuscarEnderecoBotao().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarEnderecoEventAction(evt);
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
            fornecedor = new Fornecedor();
            setFormStatus(false);
            telefones.clear();
            cleanForm();
        }
    }

    private void gravarEventAction(MouseEvent evt) {
        if (!tela.getBotaoGravar().isEnabled()) {
            return;
        }
        try {
            Fornecedor fornecedorCriado = fornecedorService.createOrUpdate(getFornecedor());
            telefones.stream().forEach(telefone -> {
                telefone.setFornecedor(fornecedorCriado);
                telefoneService.createOrUpdate(telefone);
            });
            setFormStatus(false);
            cleanForm();
            telefones.clear();
            fornecedor = new Fornecedor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, e.getMessage());
        }
    }

    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaFornecedor buscaController = new ControllerBuscaFornecedor(fornecedor -> {
            setFornecedor(fornecedor);
            telefones.addAll(telefoneService.findByFornecedor(fornecedor));
            telefones.forEach(telefone -> {
                tela.getTelefoneComboBox().addItem(telefone.getTelefone());
            });
            setFormStatus(true);
        });
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }

    private void deletarTelefoneEventAction(MouseEvent evt) {
        if (!tela.getDeletarTelefoneBotao().isEnabled()) {
            return;
        }
        int index = tela.getTelefoneComboBox().getSelectedIndex();
        if (index >= 0) {
            Telefone deletedTelefone = telefones.remove(index);
            tela.getTelefoneComboBox().removeItemAt(index);
            telefoneService.delete(deletedTelefone);
        }
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
    
    private void adicionarEnderecoEventAction(MouseEvent evt) {
        if (!tela.getAdicionarEnderecoBotao().isEnabled()) {
            return;
        }
        
        ControllerCadastroEndereco con = new ControllerCadastroEndereco();
    }
    
    private void buscarEnderecoEventAction(MouseEvent evt) {
        if (!tela.getBuscarEnderecoBotao().isEnabled()) {
            return;
        }
        
        ControllerBuscaEndereco con = new ControllerBuscaEndereco(endereco -> {
            setEndereco(endereco);
            setFormStatus(true);
        });
    }
    
    private void setEndereco(Endereco endereco) {
        Endereco fornecedorEndereco = fornecedor.getEndereco();
        Cidade fornecedorCidade = fornecedorEndereco.getCidade();
        Bairro fornecedorBairro = fornecedorEndereco.getBairro();
        
        fornecedorEndereco.setId(endereco.getId());
        fornecedorEndereco.setCep(endereco.getCep());
        tela.getCepTextField().setText(endereco.getCep());
        fornecedorEndereco.setLogradouro(endereco.getLogradouro());
        tela.getLogradouroTextField().setText(endereco.getLogradouro());
        fornecedorCidade.setId(endereco.getCidade().getId());
        fornecedorCidade.setDescricao(endereco.getCidade().getDescricao());
        tela.getCidadeTextField().setText(endereco.getCidade().getDescricao());
        fornecedorCidade.setUf(endereco.getCidade().getUf());
        tela.getUfTextFIeld().setText(endereco.getCidade().getUf());
        fornecedorBairro.setId(endereco.getBairro().getId());
        fornecedorBairro.setDescricao(endereco.getBairro().getDescricao());
        tela.getBairroTextField().setText(endereco.getBairro().getDescricao());
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
        tela.getUfTextFIeld().setText("");
        tela.getTelefoneComboBox().removeAllItems();
    }

    private void init() {
        fornecedorService = new FornecedorService();
        fornecedor = new Fornecedor();
        telefones = new ArrayList<>();
        telefoneService = new TelefoneService();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        deletarTelefoneEventListener();
        adicionarTelefoneEventListener();
        adicionarEnderecoEventListener();
        buscarEnderecoEventListener();
        cleanForm();
        setFormStatus(false);
        setFieldsUnable();
        tela.setVisible(true);
    }
}
