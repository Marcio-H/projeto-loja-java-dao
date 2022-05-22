package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Vendedor;

public interface VendedorService {
	
	Vendedor save(Vendedor vendedor);
    List<Vendedor> findAll();
    Optional<Vendedor> findById(Long id);
    void delete(Vendedor vendedor);
}
