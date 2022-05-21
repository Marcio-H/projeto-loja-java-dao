package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.ItensVenda;

public interface ItensVendaService {
	
	ItensVenda save(ItensVenda itensVenda);
    List<ItensVenda> findAll();
    Optional<ItensVenda> findById(Long id);
    void delete(ItensVenda itensVenda);
}
