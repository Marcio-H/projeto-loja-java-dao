package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Bairro;

public interface BairroService {

	Bairro save(Bairro bairro);
	List<Bairro> findAll();
	Optional<Bairro> findById(Long id);
	void delete(Bairro bairro);
}
