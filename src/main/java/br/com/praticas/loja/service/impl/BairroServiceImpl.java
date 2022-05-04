package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Bairro;
import br.com.praticas.loja.repository.BairroRepository;
import br.com.praticas.loja.service.BairroService;

@Service
public class BairroServiceImpl implements BairroService {

	@Autowired
	private BairroRepository bairroRepository;

	@Override
	public Bairro save(Bairro bairro) {
		return bairroRepository.save(bairro);
	}

	@Override
	public List<Bairro> findAll() {
		return bairroRepository.findAll();
	}

	@Override
	public Optional<Bairro> findById(Long id) {
		return bairroRepository.findById(id);
	}

	@Override
	public void delete(Bairro bairro) {
		bairroRepository.delete(bairro);	
	}
}
