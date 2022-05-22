package br.com.praticas.loja.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import config.EnvProperties;

class EnvPropertiesTests {

	@Test
	void getDriverTest() {
		assertEquals("com.mysql.jdbc.Driver", EnvProperties.getDriver());
	}
}
