package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Marca;

public interface MarcaService {
	
	Marca save(Marca marca);
    List<Marca> findAll();
    Optional<Marca> findById(Long id);
    void delete(Marca marca);
}
