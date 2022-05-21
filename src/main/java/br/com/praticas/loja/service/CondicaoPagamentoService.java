package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.CondicaoPagamento;

public interface CondicaoPagamentoService {
	
	CondicaoPagamento save(CondicaoPagamento condicaoPagamento);
    List<CondicaoPagamento> findAll();
    Optional<CondicaoPagamento> findById(Long id);
    void delete(CondicaoPagamento condicaoPagamento);
}
