package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Venda;

public interface VendaService {
	
	Venda save(Venda venda);
    List<Venda> findAll();
    Optional<Venda> findById(Long id);
    void delete(Venda venda);
}
