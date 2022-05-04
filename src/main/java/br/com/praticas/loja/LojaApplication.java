package br.com.praticas.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.praticas.loja.model.Bairro;
import br.com.praticas.loja.service.BairroService;

@SpringBootApplication
public class LojaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext config = SpringApplication.run(LojaApplication.class, args);
	}
}
