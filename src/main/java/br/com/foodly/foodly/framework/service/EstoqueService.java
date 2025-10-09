package br.com.foodly.foodly.framework.service;

import java.util.List;

import br.com.foodly.foodly.framework.models.Estoque;

public interface EstoqueService {

    List<Estoque> listarEstoque();

    Estoque buscarEstoqueByIdIngrediente(Long idIngrediente);

    Long criarEstoque(Estoque estoque);
    
    void atualizarEstoqueByIdIngrediente(Estoque estoque, Long idIngrediente);
    
    void deletarEstoqueByIdIngrediente(Long idIngrediente);

}
