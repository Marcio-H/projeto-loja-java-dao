package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Cliente;
import br.com.praticas.loja.repository.ClienteRepository;
import br.com.praticas.loja.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);	
	}
}
