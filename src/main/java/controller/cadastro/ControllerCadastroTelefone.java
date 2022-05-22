package controller.cadastro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import view.cadastro.TelaCadastroTelefone;

public class ControllerCadastroTelefone {

    private TelaCadastroTelefone tela;
    private Consumer<String> adicionarCallBack;

    public ControllerCadastroTelefone(Consumer<String> adicionarCallBack) {
        this.adicionarCallBack = adicionarCallBack;
        init();
    }

    private void init() {
        tela = new TelaCadastroTelefone();
        adicionarEventListener();
        sairEventListener();
        tela.setVisible(true);
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
            adicionarCallBack.accept(tela.getTelefoneFormattedTextField().getText());
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
