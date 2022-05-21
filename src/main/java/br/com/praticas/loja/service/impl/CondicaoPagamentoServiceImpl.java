package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.CondicaoPagamento;
import br.com.praticas.loja.repository.CondicaoPagamentoRepository;
import br.com.praticas.loja.service.CondicaoPagamentoService;

@Service
public class CondicaoPagamentoServiceImpl implements CondicaoPagamentoService {
	
	@Autowired
	private CondicaoPagamentoRepository condicaoPagamentoRepository;

	@Override
	public CondicaoPagamento save(CondicaoPagamento condicaoPagamento) {
		return condicaoPagamentoRepository.save(condicaoPagamento);
	}

	@Override
	public List<CondicaoPagamento> findAll() {
		return condicaoPagamentoRepository.findAll();
	}

	@Override
	public Optional<CondicaoPagamento> findById(Long id) {
		return condicaoPagamentoRepository.findById(id);
	}

	@Override
	public void delete(CondicaoPagamento condicaoPagamento) {
		condicaoPagamentoRepository.delete(condicaoPagamento);	
	}
}
