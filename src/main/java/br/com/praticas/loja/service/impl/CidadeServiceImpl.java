package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Cidade;
import br.com.praticas.loja.repository.CidadeRepository;
import br.com.praticas.loja.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@Override
	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	@Override
	public Optional<Cidade> findById(Long id) {
		return cidadeRepository.findById(id);
	}

	@Override
	public void delete(Cidade cidade) {
		cidadeRepository.delete(cidade);	
	}
}
