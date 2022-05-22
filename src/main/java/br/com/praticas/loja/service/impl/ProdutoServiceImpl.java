package br.com.praticas.loja.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.praticas.loja.model.Produto;
import br.com.praticas.loja.repository.ProdutoRepository;
import br.com.praticas.loja.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public void delete(Produto produto) {
		produtoRepository.delete(produto);	
	}
}
