package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.ItensVenda;
import br.com.praticas.loja.repository.ItensVendaRepository;
import br.com.praticas.loja.service.ItensVendaService;

@Service
public class ItensVendaServiceImpl implements ItensVendaService {
	
	@Autowired
	private ItensVendaRepository itensVendaRepository;

	@Override
	public ItensVenda save(ItensVenda itensVenda) {
		return itensVendaRepository.save(itensVenda);
	}

	@Override
	public List<ItensVenda> findAll() {
		return itensVendaRepository.findAll();
	}

	@Override
	public Optional<ItensVenda> findById(Long id) {
		return itensVendaRepository.findById(id);
	}

	@Override
	public void delete(ItensVenda itensVenda) {
		itensVendaRepository.delete(itensVenda);	
	}
}
