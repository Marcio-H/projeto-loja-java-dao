package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Cidade;

public interface CidadeService {
        	
	Cidade save(Cidade cidade);
	List<Cidade> findAll();
	Optional<Cidade> findById(Long id);
	void delete(Cidade cidade);
}
