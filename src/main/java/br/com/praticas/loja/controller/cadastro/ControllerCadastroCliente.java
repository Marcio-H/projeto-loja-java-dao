package controller.cadastro;

import controller.busca.ControllerBuscaCliente;
import controller.busca.ControllerBuscaEndereco;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bo.Endereco;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Telefone;
import service.ClienteService;
import service.TelefoneService;
import view.cadastro.TelaCadastroCliente;

public class ControllerCadastroCliente {

    private TelaCadastroCliente tela;
    private Cliente cliente;
    private ClienteService clienteService;
    private TelefoneService telefoneService;
    private List<Telefone> telefones;
    
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public ControllerCadastroCliente() {
        tela = new TelaCadastroCliente();
        init();
    }

    public Cliente getCliente() {
        
        try {
            cliente.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
        cliente.setNome(tela.getNomeTextField().getText());
        cliente.setEmail(tela.getEmailTextField().getText());
        cliente.setComplementoEndereco(tela.getComplementoTextField().getText());
        cliente.setCpf(tela.getCpfFormattedTextField().getText());
        cliente.setRg(tela.getRgFormattedTextField().getText());
        
        try {
            java.util.Date dataNascimento = formatter.parse(tela.getDataNascimentolFormattedTextField().getText());
            cliente.setDataNascimento(new java.sql.Date(dataNascimento.getTime()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente.setId(cliente.getId());
        tela.getId().setText(cliente.getId().toString());
        
        this.cliente.setDataNascimento(cliente.getDataNascimento());
        java.util.Date date = new java.util.Date(cliente.getDataNascimento().getTime());
        tela.getDataNascimentolFormattedTextField().setText(formatter.format(date));
        
        this.cliente.setCpf(cliente.getCpf());
        tela.getCpfFormattedTextField().setText(cliente.getCpf());
        this.cliente.setNome(cliente.getNome());
        tela.getNomeTextField().setText(cliente.getNome());
        this.cliente.setEmail(cliente.getEmail());
        tela.getEmailTextField().setText(cliente.getEmail());
        this.cliente.setComplementoEndereco(cliente.getComplementoEndereco());
        tela.getComplementoTextField().setText(cliente.getComplementoEndereco());
        setEndereco(cliente.getEndereco());
        this.cliente.setRg(cliente.getRg());
        tela.getRgFormattedTextField().setText(cliente.getRg());
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
            cliente = new Cliente();
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
            Cliente clienteCriado = clienteService.createOrUpdate(getCliente());
            telefones.stream().forEach(telefone -> {
                telefone.setCliente(clienteCriado);
                telefoneService.createOrUpdate(telefone);
            });
            setFormStatus(false);
            cleanForm();
            telefones.clear();
            cliente = new Cliente();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, e.getMessage());
        }
    }

    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaCliente buscaController = new ControllerBuscaCliente(cliente -> {
            setCliente(cliente);
            telefones.addAll(telefoneService.findByCliente(cliente));
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
        Endereco clienteEndereco = cliente.getEndereco();
        Cidade fornecedorCidade = clienteEndereco.getCidade();
        Bairro fornecedorBairro = clienteEndereco.getBairro();
        
        clienteEndereco.setId(endereco.getId());
        clienteEndereco.setCep(endereco.getCep());
        tela.getCepTextField().setText(endereco.getCep());
        clienteEndereco.setLogradouro(endereco.getLogradouro());
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
        tela.getRgFormattedTextField().setEnabled(status);
        tela.getComplementoTextField().setEnabled(status);
        tela.getTelefoneComboBox().setEditable(status);
        tela.getDeletarTelefoneBotao().setEnabled(status);
        tela.getBotaoNovo().setEnabled(!status);
        tela.getBotaoCancelar().setEnabled(status);
        tela.getBuscarEnderecoBotao().setEnabled(status);
        tela.getAdicionarEnderecoBotao().setEnabled(status);
        tela.getAdicionarTelefoneBotao().setEnabled(status);
        tela.getCpfFormattedTextField().setEnabled(status);
        tela.getDataNascimentolFormattedTextField().setEnabled(status);
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
        tela.getCepTextField().setText("");
        tela.getLogradouroTextField().setText("");
        tela.getCidadeTextField().setText("");
        tela.getBairroTextField().setText("");
        tela.getComplementoTextField().setText("");
        tela.getCpfFormattedTextField().setText("");
        tela.getDataNascimentolFormattedTextField().setText("");
        tela.getRgFormattedTextField().setText("");
        tela.getUfTextFIeld().setText("");
        tela.getTelefoneComboBox().removeAllItems();
    }

    private void init() {
        clienteService = new ClienteService();
        cliente = new Cliente();
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
