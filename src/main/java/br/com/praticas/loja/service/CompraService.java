package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Compra;

public interface CompraService {
	
	Compra save(Compra compra);
    List<Compra> findAll();
    Optional<Compra> findById(Long id);
    void delete(Compra compra);
}
