package br.com.praticas.loja;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LojaApplicationTests {

	@Test
	void contextLoads() {
		assertThat(true).isEqualTo(true);
	}
}
