package controller.cadastro;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.CondicaoPagamento;
import model.bo.Cliente;
import model.bo.Vendedor;
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
        this.venda.setTotal(venda.getTotal());
        this.venda.setDesconto(venda.getDesconto());
//        this.tela.getId().setText(String.valueOf(venda.getId()));
//        this.venda.setCep(venda.getCep());
//        this.tela.getCep().setText(venda.getCep());
//        this.venda.setLogradouro(venda.getLogradouro());
//        this.tela.getLogradouro().setText(venda.getLogradouro());

        if (venda.getCliente()!= null) {
            setCLiente(venda.getCliente());
        }
        if (venda.getCondicaoPagamento() != null) {
            setCondicaoPagamento(venda.getCondicaoPagamento());
        }

        if(venda.getVendedor() != null) {
            setVendedor(venda.getVendedor());
        }
    }

    private void setCLiente(Cliente cliente) {
        Cliente vendaCliente = venda.getCliente();

         vendaCliente.setId(cliente.getId());
         vendaCliente.setCpf(cliente.getCpf());
         vendaCliente.setDataNascimento(cliente.getDataNascimento());
         vendaCliente.setEmail(cliente.getEmail());
         vendaCliente.setCpf(cliente.getCpf());
         vendaCliente.setRg(cliente.getEmail());
         vendaCliente.setComplementoEndereco(cliente.getComplementoEndereco());
         vendaCliente.setEndereco(cliente.getEndereco());
         vendaCliente.setNome(cliente.getNome());

         tela.getIdClienteTextField().setText(String.valueOf(cliente.getId()));
         tela.getNomeClienteTextField().setText(cliente.getNome());
    }

    private void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        CondicaoPagamento vendaCondicaoPagamento = venda.getCondicaoPagamento();
 
        vendaCondicaoPagamento.setId(condicaoPagamento.getId());
        vendaCondicaoPagamento.setDescricao(condicaoPagamento.getDescricao());
        vendaCondicaoPagamento.setNumeroDiasAtePrimeiraParcela(condicaoPagamento.getNumeroDiasAtePrimeiraParcela());
        vendaCondicaoPagamento.setNumeroDiasEntreParcelas(condicaoPagamento.getNumeroDiasEntreParcelas());

        tela.getIdCondicaoPagamentoTextField().setText(String.valueOf(condicaoPagamento.getId()));
        tela.getDescricaoCondicaoPagamentoTextField().setText(condicaoPagamento.getDescricao());
    }

    private void setVendedor(Vendedor vendedor) {
        Vendedor vendaVendedor = venda.getVendedor();
 
        vendaVendedor.setId(vendedor.getId());
        vendaVendedor.setEmail(vendedor.getEmail());
        vendaVendedor.setComplementoEndereco(vendedor.getComplementoEndereco());
        vendaVendedor.setEndereco(vendedor.getEndereco());
        vendaVendedor.setNome(vendedor.getNome());
        vendaVendedor.setPercentagemComissaoRecebimento(vendedor.getPercentagemComissaoRecebimento());
        vendaVendedor.setPercentagemComissaoVenda(vendedor.getPercentagemComissaoVenda());

        tela.getIdVendedorTextField().setText(String.valueOf(vendedor.getId()));
        tela.getNomeVendedorTextField().setText(vendedor.getNome());
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

    private void adicionarCondicaoPagamentoEventListener() {
        this.tela.getBotaoAdicionarCondicaoPagamento().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                adicionarCondicaoPagamentoEventAction(evt);
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
    
    private void buscarCondicaoPagamentoEventListener() {
        tela.getBotaoBuscarCondicaoPagamento().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buscarCondicaoPagamentoEventAction(evt);
            }
        });
    }
    
    private void buscarCondicaoPagamentoEventAction(MouseEvent evt) {
        if (tela.getBotaoBuscarCondicaoPagamento().isEnabled()) {
            ControllerBuscaCondicaoPagamento con = new ControllerBuscaCondicaoPagamento(cidade -> {
                setCondicaoPagamento(cidade);
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

    private void adicionarCondicaoPagamentoEventAction(MouseEvent evt) {
        ControllerCadastroCondicaoPagamento controllerCadastroCondicaoPagamento = new ControllerCadastroCondicaoPagamento();
    }

    private void cadastoBairroEventAction(MouseEvent evt) {
        ControllerCadastroBairro controllerCadastroBairro = new ControllerCadastroBairro();
    }

    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }

    private void cleanForm() {
        tela.getIdClienteTextField().setText("");
        tela.getIdCondicaoPagamentoTextField().setText("");
        tela.getIdVendedorTextField().setText("");
        tela.getNomeClienteTextField().setText("");
        tela.getNomeVendedorTextField().setText("");
        tela.getDescricaoCondicaoPagamentoTextField().setText("");
        DefaultTableModel tabela = (DefaultTableModel) this.tela.getTableProdutos().getModel();
        tabela.setNumRows(0);
        tela.getValotTotal().setText("R$ 00,00");   
    }

    private void setDisabledForms() {
        tela.getIdClienteTextField().setEnabled(false);
        tela.getIdCondicaoPagamentoTextField().setEditable(false);
        tela.getIdVendedorTextField().setEditable(false);
        tela.getNomeClienteTextField().setEditable(false);
        tela.getNomeVendedorTextField().setEditable(false);
        tela.getDescricaoCondicaoPagamentoTextField().setEditable(false);
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
        buscarCondicaoPagamentoEventListener();
        adicionarCondicaoPagamentoEventListener();
        setDisabledForms();
        tela.setVisible(true);
    }

    public static void main(String[] args) {
        ControllerCadastroVenda controllerCadastroVenda = new ControllerCadastroVenda();
    }
}
