package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.praticas.loja.model.Receber;
import br.com.praticas.loja.repository.ReceberRepository;
import br.com.praticas.loja.service.ReceberService;

public class ReceberServiceImpl implements ReceberService {
	
	@Autowired
	private ReceberRepository receberRepository;

	@Override
	public Receber save(Receber receber) {
		return receberRepository.save(receber);
	}

	@Override
	public List<Receber> findAll() {
		return receberRepository.findAll();
	}

	@Override
	public Optional<Receber> findById(Long id) {
		return receberRepository.findById(id);
	}

	@Override
	public void delete(Receber receber) {
		receberRepository.delete(receber);	
	}
}
