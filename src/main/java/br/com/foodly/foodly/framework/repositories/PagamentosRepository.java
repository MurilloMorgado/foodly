package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Pagamento;

public interface PagamentosRepository extends JpaRepository<Pagamento, Long> {

}
