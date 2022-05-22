package br.com.praticas.loja.dao.impl;

import org.junit.jupiter.api.Test;

import dao.impl.BairroDAO;
import domain.Bairro;

class BairoDAOTests {

	@Test
	void createBairro() {
		Bairro bairro = Bairro.builder()
				.descricao("TESTE1")
				.build();
		BairroDAO bairroDAO = new BairroDAO();
		
		bairroDAO.create(bairro);
	}
}
