package controller.cadastro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import domain.bo.Telefone;
import service.TelefoneService;
import view.cadastro.TelaCadastroTelefone;

public class ControllerCadastroTelefone {
    
    private TelaCadastroTelefone tela;
    private Telefone telefone;
    private TelefoneService telefoneService;
    private Consumer<Telefone> adicionarCallBack;

    public ControllerCadastroTelefone(Consumer<Telefone> adicionarCallBack) {
        this.adicionarCallBack = adicionarCallBack;
        init();
    }

    public Telefone getTelefone() {
        telefone.setTelefone(tela.getTelefoneFormattedTextField().getText());
        return telefone;
    }
    
    private void init() {
        tela = new TelaCadastroTelefone();
        telefoneService = new TelefoneService();
        telefone = new Telefone();
        adicionarEventListener();
        sairEventListener();
        tela.setVisible(true);
    }
    
    private void setTelefone(Telefone telefone) {
        this.telefone.setId(telefone.getId());
        this.telefone.setCliente(telefone.getCliente());
        this.telefone.setFornecedor(telefone.getFornecedor());
        this.telefone.setVendedor(telefone.getVendedor());
        this.telefone.setTelefone(telefone.getTelefone());
        tela.getTelefoneFormattedTextField().setText(telefone.getTelefone());
    }
    
    private void adicionarEventListener() {
        this.tela.getBotaoAdicionar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                adicionarEventAction(evt);
            }
        });
    }
    
    private void adicionarEventAction(MouseEvent evt) {
        if (!tela.getBotaoAdicionar().isEnabled()) {
            return;
        }
        try {
            adicionarCallBack.accept(getTelefone());
            cleanForm();
        } catch (Exception e) {
            //implementar mensagem de erro
            e.printStackTrace();
        }
    }
    
    private void sairEventListener() {
        this.tela.getBotaoSair().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sairEventAction(evt);
            }
        });
    }
    
    private void sairEventAction(MouseEvent evt) {
        this.tela.dispose();
    }
    
    private void cleanForm() {
        this.tela.getTelefoneFormattedTextField().setText("");
    }
}
