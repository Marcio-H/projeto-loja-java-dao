package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Pagar;

public interface PagarService {
	
	Pagar save(Pagar pagar);
    List<Pagar> findAll();
    Optional<Pagar> findById(Long id);
    void delete(Pagar pagar);
}
