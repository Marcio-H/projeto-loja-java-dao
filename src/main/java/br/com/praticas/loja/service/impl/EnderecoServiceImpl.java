package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Endereco;
import br.com.praticas.loja.repository.EnderecoRepository;
import br.com.praticas.loja.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@Override
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	@Override
	public Optional<Endereco> findById(Long id) {
		return enderecoRepository.findById(id);
	}

	@Override
	public void delete(Endereco endereco) {
		enderecoRepository.delete(endereco);	
	}
}
