package controller.cadastro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import controller.busca.ControllerBuscaCondicaoPagamento;
import domain.CondicaoPagamento;
import service.CondicaoPagamentoService;
import view.cadastro.TelaCadastroCondicaoPagamento;

public class ControllerCadastroCondicaoPagamento {
    
    private TelaCadastroCondicaoPagamento tela;
    private CondicaoPagamento condicaoPagamento;
    private CondicaoPagamentoService condicaoPagamentoService;
    
    public ControllerCadastroCondicaoPagamento() {
        tela = new TelaCadastroCondicaoPagamento();
        init();
    }
    
    public CondicaoPagamento getCondicaoPagamento() {
        try {
            condicaoPagamento.setId(Long.parseLong(tela.getId().getText()));
        } catch (Exception e) {
        }
        condicaoPagamento.setDescricao(tela.getDescricao().getText());
        try {
            condicaoPagamento.setNumeroDiasAtePrimeiraParcela(
                Integer.valueOf(tela.getNumeroDiasAtePrimeiraParcela().getText())
            );
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, String.format("O valor \"%s\" é invalido para o campo \"Numero de dias até primeira parcela\"", e.getMessage()));
            throw new Error();
        }
        try {
            condicaoPagamento.setNumeroDiasEntreParcelas(
                Integer.valueOf(tela.getNumeroDiasEntreParcelas().getText())
            );
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(tela, String.format("O valor \"%s\" é invalido para o campo \"Numero de dias entre parcelas\"", e.getMessage()));
            throw new Error();
        }

        return condicaoPagamento;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento.setId(condicaoPagamento.getId());
        tela.getId().setText(String.valueOf(condicaoPagamento.getId()));
        this.condicaoPagamento.setDescricao(condicaoPagamento.getDescricao());
        tela.getDescricao().setText(condicaoPagamento.getDescricao());
        this.condicaoPagamento.setNumeroDiasAtePrimeiraParcela(condicaoPagamento.getNumeroDiasAtePrimeiraParcela());
        tela.getNumeroDiasAtePrimeiraParcela().setText(String.valueOf(condicaoPagamento.getNumeroDiasAtePrimeiraParcela()));
        this.condicaoPagamento.setNumeroDiasEntreParcelas(condicaoPagamento.getNumeroDiasEntreParcelas());
        tela.getNumeroDiasEntreParcelas().setText(String.valueOf(condicaoPagamento.getNumeroDiasEntreParcelas()));
    }
    
    private void init() {
        condicaoPagamentoService = new CondicaoPagamentoService();
        condicaoPagamento = new CondicaoPagamento();
        novoEventListener();
        cancelarEventListener();
        gravarEventListener();
        buscarEventListener();
        sairEventListener();
        this.tela.getId().setEnabled(false);
        setFormStatus(false);
        this.tela.setVisible(true);
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
    
    private void novoEventAction(MouseEvent evt) {
        if (tela.getBotaoNovo().isEnabled()) {
            setFormStatus(true);
        }
    }
    
    private void cancelarEventAction(MouseEvent evt) {
        if (tela.getBotaoCancelar().isEnabled()) {
            setFormStatus(false);
            condicaoPagamento = new CondicaoPagamento();
            cleanForm();
        }
    }
    
    private void gravarEventAction(MouseEvent evt) {
        if (!tela.getBotaoGravar().isEnabled()) {
            return;
        }
        try {
            condicaoPagamentoService.createOrUpdate(getCondicaoPagamento());
            setFormStatus(false);
            condicaoPagamento = new CondicaoPagamento();
            cleanForm();
        } catch (Exception e) {
            //implementar mensagem de erro
            e.printStackTrace();
        }
    }
    
    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }
    
    private void buscarEventAction(MouseEvent evt) {
        ControllerBuscaCondicaoPagamento buscaController = new ControllerBuscaCondicaoPagamento(condicaoPagamento -> {
            setCondicaoPagamento(condicaoPagamento);
            setFormStatus(true);
        });
    }
    
    private void setFormStatus(boolean status) {
        tela.getDescricao().setEnabled(status);
        tela.getNumeroDiasAtePrimeiraParcela().setEnabled(status);
        tela.getNumeroDiasEntreParcelas().setEnabled(status);
        tela.getBotaoNovo().setEnabled(!status);
        tela.getBotaoCancelar().setEnabled(status);
        tela.getBotaoGravar().setEnabled(status);
    }
    
    private void cleanForm() {
        tela.getId().setText("");
        tela.getDescricao().setText("");
        tela.getNumeroDiasAtePrimeiraParcela().setText("");
        tela.getNumeroDiasEntreParcelas().setText("");
    }
}
