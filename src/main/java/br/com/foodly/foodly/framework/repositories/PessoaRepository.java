package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
