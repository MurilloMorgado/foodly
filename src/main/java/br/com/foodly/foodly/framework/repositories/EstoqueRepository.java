package br.com.foodly.foodly.framework.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.foodly.foodly.framework.models.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Optional<Estoque> findByIngredienteIdIngrediente(Long idIngrediente);

    void deleteByIngredienteIdIngrediente(Long idIngrediente);
}
