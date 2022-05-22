package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Produto;

public interface ProdutoService {
	
	Produto save(Produto produto);
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    void delete(Produto produto);
}
