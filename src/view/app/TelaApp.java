package view.app;

import javax.swing.JMenuItem;

public class TelaApp extends javax.swing.JFrame {

    public TelaApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botaoBairro = new javax.swing.JMenuItem();
        botaoCaracteristicaProduto = new javax.swing.JMenuItem();
        botaoCidade = new javax.swing.JMenuItem();
        botaoCliente = new javax.swing.JMenuItem();
        botaoCondicaoPagamento = new javax.swing.JMenuItem();
        botaoCor = new javax.swing.JMenuItem();
        botaoEndereco = new javax.swing.JMenuItem();
        botaoFornecedor = new javax.swing.JMenuItem();
        botaoMarca = new javax.swing.JMenuItem();
        botaoProduto = new javax.swing.JMenuItem();
        botaoTamanho = new javax.swing.JMenuItem();
        botaoTipoProduto = new javax.swing.JMenuItem();
        botaoVendedor = new javax.swing.JMenuItem();
        jmenu = new javax.swing.JMenu();
        botaoPdv = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastro");

        botaoBairro.setText("Bairro ");
        jMenu1.add(botaoBairro);

        botaoCaracteristicaProduto.setText("Caracteristica Produto");
        jMenu1.add(botaoCaracteristicaProduto);

        botaoCidade.setText("Cidade ");
        jMenu1.add(botaoCidade);

        botaoCliente.setText("Cliente");
        jMenu1.add(botaoCliente);

        botaoCondicaoPagamento.setText("Condicao Pagamento ");
        jMenu1.add(botaoCondicaoPagamento);

        botaoCor.setText("Cor");
        jMenu1.add(botaoCor);

        botaoEndereco.setText("Endereco");
        jMenu1.add(botaoEndereco);

        botaoFornecedor.setText("Fornecedor");
        jMenu1.add(botaoFornecedor);

        botaoMarca.setText("Marca");
        jMenu1.add(botaoMarca);

        botaoProduto.setText("Produto");
        jMenu1.add(botaoProduto);

        botaoTamanho.setText("Tamanho");
        jMenu1.add(botaoTamanho);

        botaoTipoProduto.setText("Tipo de Produto");
        jMenu1.add(botaoTipoProduto);

        botaoVendedor.setText("Vendedor");
        jMenu1.add(botaoVendedor);

        jMenuBar1.add(jMenu1);

        jmenu.setText("Movimentos");

        botaoPdv.setText("Pdv");
        jmenu.add(botaoPdv);

        jMenuBar1.add(jmenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botaoBairro;
    private javax.swing.JMenuItem botaoCaracteristicaProduto;
    private javax.swing.JMenuItem botaoCidade;
    private javax.swing.JMenuItem botaoCliente;
    private javax.swing.JMenuItem botaoCondicaoPagamento;
    private javax.swing.JMenuItem botaoCor;
    private javax.swing.JMenuItem botaoEndereco;
    private javax.swing.JMenuItem botaoFornecedor;
    private javax.swing.JMenuItem botaoMarca;
    private javax.swing.JMenuItem botaoPdv;
    private javax.swing.JMenuItem botaoProduto;
    private javax.swing.JMenuItem botaoTamanho;
    private javax.swing.JMenuItem botaoTipoProduto;
    private javax.swing.JMenuItem botaoVendedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmenu;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getBotaoBairro() {
        return botaoBairro;
    }

    public JMenuItem getBotaoCaracteristicaProduto() {
        return botaoCaracteristicaProduto;
    }

    public JMenuItem getBotaoCidade() {
        return botaoCidade;
    }

    public JMenuItem getBotaoCliente() {
        return botaoCliente;
    }

    public JMenuItem getBotaoCondicaoPagamento() {
        return botaoCondicaoPagamento;
    }

    public JMenuItem getBotaoCor() {
        return botaoCor;
    }

    public JMenuItem getBotaoEndereco() {
        return botaoEndereco;
    }

    public JMenuItem getBotaoFornecedor() {
        return botaoFornecedor;
    }

    public JMenuItem getBotaoMarca() {
        return botaoMarca;
    }

    public JMenuItem getBotaoPdv() {
        return botaoPdv;
    }

    public JMenuItem getBotaoProduto() {
        return botaoProduto;
    }

    public JMenuItem getBotaoTamanho() {
        return botaoTamanho;
    }

    public JMenuItem getBotaoTipoProduto() {
        return botaoTipoProduto;
    }

    public JMenuItem getBotaoVendedor() {
        return botaoVendedor;
    }
}
