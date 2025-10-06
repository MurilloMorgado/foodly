package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import br.com.foodly.foodly.framework.models.ProdutoIngrediente;
import jakarta.transaction.Transactional;

public interface ProdutoIngredienteRepository extends JpaRepository<ProdutoIngrediente, Long> {

    @Modifying
    @Transactional
    void deleteByProdutoId(Long idProduto);
}
