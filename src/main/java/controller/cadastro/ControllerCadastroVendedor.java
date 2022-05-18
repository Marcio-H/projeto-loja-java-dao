package controller.cadastro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.busca.ControllerBuscaEndereco;
import controller.busca.ControllerBuscaVendedor;
import domain.Bairro;
import domain.Cidade;
import domain.Endereco;
import domain.Vendedor;
import domain.bo.Telefone;
import service.TelefoneService;
import service.VendedorService;
import view.cadastro.TelaCadastroVendedor;

public class ControllerCadastroVendedor {

    private TelaCadastroVendedor tela;
    private Vendedor vendedor;
    private VendedorService vendedorService;
    private TelefoneService telefoneService;
    
    // TODO: Implementar TelefoneVendedor
    private List<Telefone> telefones;

    public ControllerCadastroVendedor() {
        tela = new TelaCadastroVendedor();
        init();
    }

    public Vendedor getVendedor() {
        try {
            vendedor.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
        vendedor.setNome(tela.getNomeTextField().getText());
        vendedor.setEmail(tela.getEmailTextField().getText());
        vendedor.setComplementoEndereco(tela.getComplementoTextField().getText());
        vendedor.setCpf(tela.getCpfFormattedTextField().getText());
        try {
           vendedor.setPercentagemComissaoRecebimento(
              Float.valueOf(tela.getPorcentagemComissaoRecebimentoFormattedTextField().getText())
            );
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, String.format("O valor \"%s\" é invalido para o campo \"Porcentagem de Comissao do Recebimento\"", e.getMessage()));
            throw new Error();
        }
        try {
           vendedor.setPercentagemComissaoVenda(
              Float.valueOf(tela.getPorcentagemComissaoVendaFormattedTextField().getText())
            );
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, String.format("O valor \"%s\" é invalido para o campo \"Porcentagem de Comissao da Venda\"", e.getMessage()));
            throw new Error();
        }
        return vendedor;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor.setId(vendedor.getId());
        tela.getId().setText(vendedor.getId().toString());
        this.vendedor.setNome(vendedor.getNome());
        tela.getNomeTextField().setText(vendedor.getNome());
        this.vendedor.setEmail(vendedor.getEmail());
        tela.getEmailTextField().setText(vendedor.getEmail());
        this.vendedor.setComplementoEndereco(vendedor.getComplementoEndereco());
        tela.getComplementoTextField().setText(vendedor.getComplementoEndereco());
        setEndereco(vendedor.getEndereco());
        this.vendedor.setCpf(vendedor.getCpf());
        tela.getCpfFormattedTextField().setText(vendedor.getCpf());
        this.vendedor.setPercentagemComissaoRecebimento(vendedor.getPercentagemComissaoRecebimento());
        tela.getPorcentagemComissaoRecebimentoFormattedTextField().setText(String.valueOf(vendedor.getPercentagemComissaoRecebimento()));
        this.vendedor.setPercentagemComissaoVenda(vendedor.getPercentagemComissaoVenda());
        tela.getPorcentagemComissaoVendaFormattedTextField().setText(String.valueOf(vendedor.getPercentagemComissaoVenda()));
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
            vendedor = new Vendedor();
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
            Vendedor vendedorCriado = vendedorService.createOrUpdate(getVendedor());
            telefones.stream().forEach(telefone -> {
                telefone.setVendedor(vendedorCriado);
                telefoneService.createOrUpdate(telefone);
            });
            setFormStatus(false);
            cleanForm();
            telefones.clear();
            vendedor = new Vendedor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, e.getMessage());
        }
    }

    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaVendedor buscaController = new ControllerBuscaVendedor(vendedor -> {
            setVendedor(vendedor);
            telefones.addAll(telefoneService.findByVendedor(vendedor));
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
        Endereco vendedorEndereco = vendedor.getEndereco();
        Cidade vendedorCidade = vendedorEndereco.getCidade();
        Bairro vendedorBairro = vendedorEndereco.getBairro();
        
        vendedorEndereco.setId(endereco.getId());
        vendedorEndereco.setCep(endereco.getCep());
        tela.getCepTextField().setText(endereco.getCep());
        vendedorEndereco.setLogradouro(endereco.getLogradouro());
        tela.getLogradouroTextField().setText(endereco.getLogradouro());
        vendedorCidade.setId(endereco.getCidade().getId());
        vendedorCidade.setDescricao(endereco.getCidade().getDescricao());
        tela.getCidadeTextField().setText(endereco.getCidade().getDescricao());
        vendedorCidade.setUf(endereco.getCidade().getUf());
        tela.getUfTextFIeld().setText(endereco.getCidade().getUf());
        vendedorBairro.setId(endereco.getBairro().getId());
        vendedorBairro.setDescricao(endereco.getBairro().getDescricao());
        tela.getBairroTextField().setText(endereco.getBairro().getDescricao());
    }

    private void setFormStatus(boolean status) {
        this.tela.getId().setEnabled(false);
        tela.getBotaoGravar().setEnabled(status);
        tela.getNomeTextField().setEnabled(status);
        tela.getEmailTextField().setEnabled(status);
        tela.getPorcentagemComissaoRecebimentoFormattedTextField().setEnabled(status);
        tela.getComplementoTextField().setEnabled(status);
        tela.getCpfFormattedTextField().setEnabled(status);
        tela.getPorcentagemComissaoVendaFormattedTextField().setEnabled(status);
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
        tela.getPorcentagemComissaoRecebimentoFormattedTextField().setText("");
        tela.getCepTextField().setText("");
        tela.getLogradouroTextField().setText("");
        tela.getCidadeTextField().setText("");
        tela.getBairroTextField().setText("");
        tela.getComplementoTextField().setText("");
        tela.getPorcentagemComissaoVendaFormattedTextField().setText("");
        tela.getUfTextFIeld().setText("");
        tela.getTelefoneComboBox().removeAllItems();
        tela.getCpfFormattedTextField().setText("");
    }

    private void init() {
        vendedorService = new VendedorService();
        vendedor = new Vendedor();
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
