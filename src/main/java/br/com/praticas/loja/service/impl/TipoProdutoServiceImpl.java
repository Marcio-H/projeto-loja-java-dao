package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.TipoProduto;
import br.com.praticas.loja.repository.TipoProdutoRepository;
import br.com.praticas.loja.service.TipoProdutoService;

@Service
public class TipoProdutoServiceImpl implements TipoProdutoService {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;

	@Override
	public TipoProduto save(TipoProduto tipoProduto) {
		return tipoProdutoRepository.save(tipoProduto);
	}

	@Override
	public List<TipoProduto> findAll() {
		return tipoProdutoRepository.findAll();
	}

	@Override
	public Optional<TipoProduto> findById(Long id) {
		return tipoProdutoRepository.findById(id);
	}

	@Override
	public void delete(TipoProduto tipoProduto) {
		tipoProdutoRepository.delete(tipoProduto);	
	}
}
