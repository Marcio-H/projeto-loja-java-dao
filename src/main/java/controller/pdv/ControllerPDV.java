package controller.pdv;

import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_F1;
import static java.awt.event.KeyEvent.VK_F2;
import static java.awt.event.KeyEvent.VK_F3;
import static java.awt.event.KeyEvent.VK_F4;
import static java.awt.event.KeyEvent.VK_F5;
import static java.awt.event.KeyEvent.VK_F6;
import static java.awt.event.KeyEvent.VK_F7;
import static javax.swing.JComponent.WHEN_FOCUSED;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import static javax.swing.KeyStroke.getKeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.busca.ControllerBuscaCaracteristicaProduto;
import controller.busca.ControllerBuscaCliente;
import controller.busca.ControllerBuscaCondicaoPagamento;
import controller.busca.ControllerBuscaVendedor;
import domain.CaracteristicaProduto;
import domain.Cliente;
import domain.CondicaoPagamento;
import domain.Venda;
import domain.Vendedor;
import service.CaracteristicaProdutoService;
import service.VendaService;
import view.pdv.TelaPDV;

public class ControllerPDV {

    private TelaPDV tela;
    private Venda venda;
    private VendaService vendaService;
    private CaracteristicaProdutoService caracteristicaProdutoService;
    private static int item = 1;
    private static float total = 0;

    public ControllerPDV() {
        tela = new TelaPDV();
        init();
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

    private void init() {
        vendaService = new VendaService();
        venda = new Venda();
        caracteristicaProdutoService = new CaracteristicaProdutoService();
        buscaProdutoEventListener();
        buscaClienteEventListener();
        buscaCondicaoPagamentoEventListener();
        cancelarItemFaturadoEventListener();
        cancelarVendaEventListener();
        finalizaVendaEventListener();
        buscaVendedorEventListener();
        onEnterBarraEventListener();
        selectBarraProdutoEventListener();
        removeRowTableEventListener();
        setDisabledForms();
        cleanForm();
        tela.setVisible(true);
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
        tela.getBotaoBuscaProduto().addMouseListener(new MouseAdapter() {;
            public void mouseClicked(MouseEvent evt) {
                buscaProdutoEventAction();
            }
        });

        tela.getBotaoBuscaProduto().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoBuscaProduto().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscaProdutoEventAction();
            }
         });
    }
    
    private void selectBarraProdutoEventListener() { 
        tela.getCodigoBarraProdutoTextField().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F1, 0), "FOCUS");
        tela.getCodigoBarraProdutoTextField().getActionMap().put("FOCUS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectBarraProdutoEventAction();
            }
         });
    }

    private void buscaClienteEventListener() {
        tela.getBotaoBuscaCliente().addMouseListener(new MouseAdapter() {;
            public void mouseClicked(MouseEvent evt) {
                buscaClienteEventAction();
            }
        });

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
        tela.getBotaoBuscaCondicaoPagamento().addMouseListener(new MouseAdapter() {;
            public void mouseClicked(MouseEvent evt) {
                buscaCondicaoPagamentoEventAction();
            }
        });
        
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
                cancelarItemFaturadoEventAction();
            }
        });
    }

    private void cancelarVendaEventListener() {

        tela.getBotaoCancelarVenda().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F2, 0), "EVENTO1");
        tela.getBotaoCancelarVenda().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO1");
        tela.getBotaoCancelarVenda().getActionMap().put("EVENTO1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanForm();
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
                cleanForm();
            }
        });
    }

    private void buscaVendedorEventListener() {
        tela.getBotaoBuscaVendedor().addMouseListener(new MouseAdapter() {;
            public void mouseClicked(MouseEvent evt) {
                buscaVendedorEventAction();
            }
        });

        tela.getBotaoBuscaVendedor().getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_F6, 0), "EVENTO");
        tela.getBotaoBuscaVendedor().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getBotaoBuscaVendedor().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscaVendedorEventAction();
            }
        });
    }
    
    private void onEnterBarraEventListener() {
        tela.getCodigoBarraProdutoTextField().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getCodigoBarraProdutoTextField().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEnterBarraEventAction();
            }
        });
    }

    private void removeRowTableEventListener() {
        tela.getTableProdutos().getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_ENTER, 0), "EVENTO");
        tela.getTableProdutos().getActionMap().put("EVENTO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRowTableEventAction();
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
    
    private void buscaProdutoEventAction() {
        ControllerBuscaCaracteristicaProduto con = new ControllerBuscaCaracteristicaProduto(cp-> {
            addRow(cp);
        });
    }

    private void onEnterBarraEventAction() {
        CaracteristicaProduto produto = caracteristicaProdutoService.findByBarra(tela.getCodigoBarraProdutoTextField().getText());
        
        addRow(produto);
    }
    
    private void addRow(CaracteristicaProduto produto) {
        if (produto != null) {
            try {
                DefaultTableModel tabela = (DefaultTableModel) tela.getTableProdutos().getModel();
                Integer quantidade = Integer.valueOf(tela.getQuantidadeTextField().getText());
            
                tabela.addRow(new Object[] {
                item,
                produto.getProduto().getDescricao(),
                quantidade,
                produto.getProduto().getValor(),
                quantidade * produto.getProduto().getValor()
            });
                item++;
                atualizaValor(produto.getProduto().getValor()* quantidade);
            } catch (Exception e) {}
            tela.getCodigoBarraProdutoTextField().setText("");
            tela.getQuantidadeTextField().setText("1");
        }
    }
    
    private void atualizaValor(float valor) {
        total += valor;
        tela.getValotTotal().setText(String.format("R$%.2f", total));
    }
    
    private void selectBarraProdutoEventAction() {
        tela.getCodigoBarraProdutoTextField().requestFocus();
    }

    private void cancelarItemFaturadoEventAction() {
       try {
          tela.getTableProdutos().requestFocus();
          tela.getTableProdutos().setRowSelectionInterval(0,0);
       } catch (Exception e) {
         JOptionPane.showMessageDialog(tela, String.format("Nenhum produto para selecionar", e.getMessage()));
       }
    }

    private void removeRowTableEventAction() {
       int index = tela.getTableProdutos().getSelectedRow();

       DefaultTableModel table = (DefaultTableModel) tela.getTableProdutos().getModel();
       Float value = (Float) table.getValueAt(index, 4);
       total -= value;
       tela.getValotTotal().setText(String.format("R$%.2f", total));
       table.removeRow(index);
    } 

    private void cleanForm() {
        tela.getIdClienteTextField().setText("");
        tela.getIdCondicaoPagamentoTextField().setText("");
        tela.getIdVendedorTextField().setText("");
        tela.getNomeClienteTextField().setText("");
        tela.getNomeVendedorTextField().setText("");
        tela.getQuantidadeTextField().setText("1");
        tela.getDescricaoCondicaoPagamentoTextField().setText("");
        DefaultTableModel tabela = (DefaultTableModel) tela.getTableProdutos().getModel();
        tabela.setNumRows(0);
        tela.getValotTotal().setText("R$ 00,00");
        item = 1;
        total = 0;
    }

    private void setDisabledForms() {
        tela.getIdClienteTextField().setEditable(false);
        tela.getIdCondicaoPagamentoTextField().setEditable(false);
        tela.getIdVendedorTextField().setEditable(false);
        tela.getNomeClienteTextField().setEditable(false);
        tela.getNomeVendedorTextField().setEditable(false);
        tela.getDescricaoCondicaoPagamentoTextField().setEditable(false);
    }
}
