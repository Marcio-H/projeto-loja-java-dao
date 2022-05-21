package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Fornecedor;

public interface FornecedorService {
	
	Fornecedor save(Fornecedor fornecedor);
    List<Fornecedor> findAll();
    Optional<Fornecedor> findById(Long id);
    void delete(Fornecedor fornecedor);
}
