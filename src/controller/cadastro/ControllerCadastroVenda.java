package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_F1;
import static java.awt.event.KeyEvent.VK_F2;
import static java.awt.event.KeyEvent.VK_F3;
import static java.awt.event.KeyEvent.VK_F4;
import static java.awt.event.KeyEvent.VK_F5;
import static java.awt.event.KeyEvent.VK_F6;
import static java.awt.event.KeyEvent.VK_F7;
import javax.swing.AbstractAction;
import static javax.swing.JComponent.WHEN_FOCUSED;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import controller.busca.ControllerBuscaCliente;
import controller.busca.ControllerBuscaVendedor;
import controller.busca.ControllerBuscaCondicaoPagamento;
import static javax.swing.KeyStroke.getKeyStroke;
import javax.swing.table.DefaultTableModel;
import model.bo.CondicaoPagamento;
import model.bo.Cliente;
import model.bo.Vendedor;
import model.bo.Venda;
import service.VendaService;
import view.cadastro.TelaCadastroVenda;

public class ControllerCadastroVenda implements ActionListener{

    private TelaCadastroVenda tela;
    private Venda venda;
    private VendaService vendaService;

    public ControllerCadastroVenda() {
        tela = new TelaCadastroVenda();
        init();
    }
    public void actionPerformed(ActionEvent e) {
       
    }
//    public Venda getVenda() {
//        try {
//            venda.setId(Long.parseLong(tela.getId().getText()));
//        } catch (Exception e) {
//        }
//        venda.setCep(tela.getCep().getText());
//        venda.setLogradouro(tela.getLogradouro().getText());
//
//        return venda;
//    }

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

    private void buscaProdutoEventListener() {
        tela.getBotaoBuscaProduto().addActionListener(a ->  System.out.println("testeeeeeeee1"));
        tela.getBotaoBuscaProduto().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F1, 0), "EVENTO");
        tela.getBotaoBuscaProduto().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoBuscaProduto().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("testeeeeeeee1");
            }
         });
    }
    private void buscaClienteEventListener() {
        tela.getBotaoBuscaCliente().addActionListener(a ->  System.out.println("testeeeeeeee2"));
        tela.getBotaoBuscaCliente().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F5, 0), "EVENTO");
        tela.getBotaoBuscaCliente().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoBuscaCliente().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscaClienteEventAction();
            }
        });
    }
    private void buscaCondicaoPagamentoEventListener() {
        tela.getBotaoBuscaCondicaoPagamento().addActionListener(a ->  System.out.println("testeeeeeeee3"));
        tela.getBotaoBuscaCondicaoPagamento().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F7, 0), "EVENTO");
        tela.getBotaoBuscaCondicaoPagamento().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoBuscaCondicaoPagamento().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscaCondicaoPagamentoEventAction();
            }
        });
    }
    private void cancelarItemFaturadoEventListener() {
        tela.getBotaoCancelaItemFaturado().addActionListener(a ->  System.out.println("testeeeeeeee4"));
        tela.getBotaoCancelaItemFaturado().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F4, 0), "EVENTO");
        tela.getBotaoCancelaItemFaturado().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoCancelaItemFaturado().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("testeeeeeeee4");
            }
        });
    }
    private void cancelarVendaEventListener() {
        tela.getBotaoCancelarVenda().addActionListener(a ->  System.out.println("testeeeeeeee5"));
        tela.getBotaoCancelarVenda().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F2, 0), "EVENTO1");
        tela.getBotaoCancelarVenda().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO1");
        tela.getBotaoCancelarVenda().getActionMap().put("EVENTO1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("testeeeeeeee5");
            }
        });
    }
    private void finalizaVendaEventListener() {
        tela.getBotaoFinalizarVenda().addActionListener(a ->  System.out.println("testeeeeeeee6"));
        tela.getBotaoFinalizarVenda().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F3, 0), "EVENTO");
        tela.getBotaoFinalizarVenda().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoFinalizarVenda().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("testeeeeeeee6");
            }
        });
    }
    private void buscaVendedorEventListener() {
        tela.getBotaoFinalizarVenda().addActionListener(a ->  System.out.println("testeeeeeeee7"));
        tela.getBotaoFinalizarVenda().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F6, 0), "EVENTO");
        tela.getBotaoFinalizarVenda().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoFinalizarVenda().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscaVendedorEventAction();
            }
        });
    }

    private void buscaClienteEventAction() {
        ControllerBuscaCliente con = new ControllerBuscaCliente(cliente-> {
            setCLiente(cliente);
        });
    }

    private void buscaVendedorEventAction() {
        ControllerBuscaVendedor con = new ControllerBuscaVendedor(vendedor-> {
            setVendedor(vendedor);
        });
    }
    private void buscaCondicaoPagamentoEventAction() {
        ControllerBuscaCondicaoPagamento con = new ControllerBuscaCondicaoPagamento(cp-> {
            setCondicaoPagamento(cp);
        });
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
        buscaProdutoEventListener();
        buscaClienteEventListener();
        buscaCondicaoPagamentoEventListener();
        cancelarItemFaturadoEventListener();
        cancelarVendaEventListener();
        finalizaVendaEventListener();
        buscaVendedorEventListener();
        setDisabledForms();
        tela.setVisible(true);
    }

    public static void main(String[] args) {
        ControllerCadastroVenda controllerCadastroVenda = new ControllerCadastroVenda();
    }
}
