package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Tamanho;
import br.com.praticas.loja.repository.TamanhoRepository;
import br.com.praticas.loja.service.TamanhoService;

@Service
public class TamanhoServiceImpl implements TamanhoService {
	
	@Autowired
	private TamanhoRepository tamanhoRepository;

	@Override
	public Tamanho save(Tamanho tamanho) {
		return tamanhoRepository.save(tamanho);
	}

	@Override
	public List<Tamanho> findAll() {
		return tamanhoRepository.findAll();
	}

	@Override
	public Optional<Tamanho> findById(Long id) {
		return tamanhoRepository.findById(id);
	}

	@Override
	public void delete(Tamanho tamanho) {
		tamanhoRepository.delete(tamanho);	
	}
}
