package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Endereco;

public interface EnderecoService {
	
	Endereco save(Endereco endereco);
    List<Endereco> findAll();
    Optional<Endereco> findById(Long id);
    void delete(Endereco endereco);
}
