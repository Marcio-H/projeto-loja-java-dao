package br.com.praticas.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.praticas.loja.model.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

}
