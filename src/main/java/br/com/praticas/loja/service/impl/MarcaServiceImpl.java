package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Marca;
import br.com.praticas.loja.repository.MarcaRepository;
import br.com.praticas.loja.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public Marca save(Marca marca) {
		return marcaRepository.save(marca);
	}

	@Override
	public List<Marca> findAll() {
		return marcaRepository.findAll();
	}

	@Override
	public Optional<Marca> findById(Long id) {
		return marcaRepository.findById(id);
	}

	@Override
	public void delete(Marca marca) {
		marcaRepository.delete(marca);	
	}
}
