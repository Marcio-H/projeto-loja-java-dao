package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.praticas.loja.model.Cor;
import br.com.praticas.loja.repository.CorRepository;
import br.com.praticas.loja.service.CorService;

public class CorServiceImpl implements CorService {
	
	@Autowired
	private CorRepository corRepository;

	@Override
	public Cor save(Cor cor) {
		return corRepository.save(cor);
	}

	@Override
	public List<Cor> findAll() {
		return corRepository.findAll();
	}

	@Override
	public Optional<Cor> findById(Long id) {
		return corRepository.findById(id);
	}

	@Override
	public void delete(Cor cor) {
		corRepository.delete(cor);	
	}
}
