/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.bo.Cidade;
import service.CidadeService;
import view.cadastro.TelaCadastroCidade;

/**
 *
 * @author marcio.junior
 */
public class ControllerCadastroCidade implements ActionListener {
    
    private TelaCadastroCidade telaCadastroCidade;

    public ControllerCadastroCidade() {
        this.telaCadastroCidade = new TelaCadastroCidade();
        this.adicionaEventosParaOuvir();
    }

    public ControllerCadastroCidade(TelaCadastroCidade telaCadastroCidade) {
        this.telaCadastroCidade = telaCadastroCidade;
        this.adicionaEventosParaOuvir();        
    }

    public TelaCadastroCidade getTelaCadastroCidade() {
        return telaCadastroCidade;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private void adicionaEventosParaOuvir() {
        this.telaCadastroCidade.getBotaoGravar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                gravarCidade();
            }
        });
    }
    
    private void gravarCidade() {
        Cidade cidade = new Cidade();
        
        cidade.setDescricao(this.telaCadastroCidade.getDescricaoTextField().getText());
        cidade.setUf(this.telaCadastroCidade.getUfTextField().getText());
        
        CidadeService cidadeService = new CidadeService();
        
        cidadeService.salvar(cidade);
    }
    
    public static void main(String[] args) {
        ControllerCadastroCidade controllerCadastroCidade = new ControllerCadastroCidade();
        
        controllerCadastroCidade.telaCadastroCidade.setVisible(true);
    }
}
