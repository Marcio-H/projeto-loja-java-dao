package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.TipoProduto;

public interface TipoProdutoService {
	
	TipoProduto save(TipoProduto tipoProduto);
    List<TipoProduto> findAll();
    Optional<TipoProduto> findById(Long id);
    void delete(TipoProduto tipoProduto);
}
