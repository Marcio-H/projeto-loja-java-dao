package controller.menu;

import controller.cadastro.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.menu.Menu;
import controller.pdv.ControllerPDV;

public class ControllerMenu {
    
    private Menu tela;

    public ControllerMenu() {
        tela = new Menu();
        tela.setVisible(true);
        cadastroBairroEventListener();
        cadastroCaracteristicaProdutoEventListener();
        cadastroCidadeEventListener();
        cadastroClienteEventListener();
        cadastroCondicaoPagamentoEventListener();
        cadastroCorEventListener();
        cadastroEnderecoEventListener();
        cadastroFornecedorEventListener();
        cadastroMarcaEventListener();
        cadastroProdutoEventListener();
        cadastroTamanhoEventListener();
        cadastroTipoProdutoEventListener();
        cadastroVendedorEventListener();
        cadastroPdvEventListener();
    }
    
    private void cadastroBairroEventListener() {
        this.tela.getBotaoBairro().addActionListener(a -> new ControllerCadastroBairro());
    }

    private void cadastroCaracteristicaProdutoEventListener() {
        this.tela.getBotaoCaracteristicaProduto().addActionListener(a -> new ControllerCadastroCaracteristicaProduto());
    }

    private void cadastroCidadeEventListener() {
        this.tela.getBotaoCidade().addActionListener(a -> new ControllerCadastroCidade());
    }

    private void cadastroClienteEventListener() {
        this.tela.getBotaoCliente().addActionListener(a -> new ControllerCadastroCliente());
    }


    private void cadastroCondicaoPagamentoEventListener() {
        this.tela.getBotaoCondicaoPagamento().addActionListener(a -> new ControllerCadastroCondicaoPagamento());
    }

    private void cadastroCorEventListener() {
        this.tela.getBotaoCor().addActionListener(a -> new ControllerCadastroCor());
    }

    private void cadastroEnderecoEventListener() {
        this.tela.getBotaoEndereco().addActionListener(a -> new ControllerCadastroEndereco());
    }

    private void cadastroFornecedorEventListener() {
        this.tela.getBotaoFornecedor().addActionListener(a -> new ControllerCadastroFornecedor());
    }

    private void cadastroMarcaEventListener() {
        this.tela.getBotaoMarca().addActionListener(a -> new ControllerCadastroMarca());
    }

    private void cadastroProdutoEventListener() {
        this.tela.getBotaoProduto().addActionListener(a -> new ControllerCadastroProduto());
    }

    private void cadastroTamanhoEventListener() {
        this.tela.getBotaoTamanho().addActionListener(a -> new ControllerCadastroTamanho());
    }

    private void cadastroTipoProdutoEventListener() {
        this.tela.getBotaoTipoProduto().addActionListener(a -> new ControllerCadastroTipoProduto());
    }

    private void cadastroVendedorEventListener() {
        this.tela.getBotaoVendedor().addActionListener(a -> new ControllerCadastroVendedor());
    }

    private void cadastroPdvEventListener() {
        this.tela.getBotaoPdv().addActionListener(a -> new ControllerPDV());
    }

    public static void main(String[] args) {
       new ControllerMenu();
    }
}
