package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Tamanho;

public interface TamanhoService {
	
	Tamanho save(Tamanho tamanho);
    List<Tamanho> findAll();
    Optional<Tamanho> findById(Long id);
    void delete(Tamanho tamanho);
}
