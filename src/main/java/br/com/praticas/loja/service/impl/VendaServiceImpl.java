package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Venda;
import br.com.praticas.loja.repository.VendaRepository;
import br.com.praticas.loja.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	@Override
	public Venda save(Venda venda) {
		return vendaRepository.save(venda);
	}

	@Override
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}

	@Override
	public Optional<Venda> findById(Long id) {
		return vendaRepository.findById(id);
	}

	@Override
	public void delete(Venda venda) {
		vendaRepository.delete(venda);	
	}
}
