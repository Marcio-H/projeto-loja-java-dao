package br.com.praticas.loja.service;

import java.util.List;
import java.util.Optional;

import br.com.praticas.loja.model.Receber;

public interface ReceberService {
	
	Receber save(Receber receber);
    List<Receber> findAll();
    Optional<Receber> findById(Long id);
    void delete(Receber receber);
}
