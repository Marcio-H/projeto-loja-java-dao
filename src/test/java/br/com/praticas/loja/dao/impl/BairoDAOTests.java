package br.com.praticas.loja.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.impl.BairroDAO;
import domain.Bairro;

class BairoDAOTests {

	@Test
	void createBairroTest() {
		Bairro bairro = Bairro.builder()
				.descricao("TESTE 1")
				.build();
		BairroDAO bairroDAO = new BairroDAO();
		Bairro saved = bairroDAO.create(bairro);

		assertNotNull(saved.getId());
	}
	
	@Test
	void readBairrosTest() {
		BairroDAO bairroDAO = new BairroDAO();
		List<Bairro> bairros = bairroDAO.read();

		assertThat(bairros).hasSizeGreaterThan(0);
	}
	
	@Test
	void readBairroByIdTest() {
		BairroDAO bairroDAO = new BairroDAO();
		Bairro bairro = bairroDAO.read(1L);

		assertThat(bairro).extracting(Bairro::getId).isEqualTo(1L);
	}
	
	@Test
	void deleteBairroTest() {
		Bairro bairro = Bairro.builder()
				.id(2L)
				.build();
		BairroDAO bairroDAO = new BairroDAO();

		bairroDAO.delete(bairro);
		
		Bairro bairroDeleted = bairroDAO.read(1L);
		
		assertThat(bairroDeleted).isNull();
	}
	
	@Test
	void updateBairroTest() {
		Bairro bairro = Bairro.builder()
				.id(3L)
				.descricao("ALTERADO")
				.build();
		BairroDAO bairroDAO = new BairroDAO();
		Bairro bairroAtualizado = bairroDAO.update(bairro);
		
		assertThat(bairroAtualizado)
			.extracting(Bairro::getId, Bairro::getDescricao)
			.contains(bairro.getId(), bairro.getDescricao());
	}
}
