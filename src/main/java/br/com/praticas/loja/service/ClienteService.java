package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    void delete(Cliente cliente);
}
