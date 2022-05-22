package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Cor;

public interface CorService {
	
	Cor save(Cor cor);
    List<Cor> findAll();
    Optional<Cor> findById(Long id);
    void delete(Cor cor);
}
