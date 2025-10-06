package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Ingrediente;

public interface IngredienteRespository extends JpaRepository<Ingrediente, Long>{
    
}
