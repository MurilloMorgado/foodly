package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.ProdutoIngrediente;

public interface ProdutoIngredienteRepository extends JpaRepository<ProdutoIngrediente, Long>{
    
}
