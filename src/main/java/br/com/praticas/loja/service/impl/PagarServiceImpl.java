package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Pagar;
import br.com.praticas.loja.repository.PagarRepository;
import br.com.praticas.loja.service.PagarService;

@Service
public class PagarServiceImpl implements PagarService {
	
	@Autowired
	private PagarRepository pagarRepository;

	@Override
	public Pagar save(Pagar pagar) {
		return pagarRepository.save(pagar);
	}

	@Override
	public List<Pagar> findAll() {
		return pagarRepository.findAll();
	}

	@Override
	public Optional<Pagar> findById(Long id) {
		return pagarRepository.findById(id);
	}

	@Override
	public void delete(Pagar pagar) {
		pagarRepository.delete(pagar);	
	}
}
