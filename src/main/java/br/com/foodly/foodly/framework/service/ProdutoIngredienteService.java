package br.com.foodly.foodly.framework.service;

import java.util.List;

import br.com.foodly.foodly.framework.models.ProdutoIngrediente;

public interface ProdutoIngredienteService {
    
    Long criarProdutoIncrediente(ProdutoIngrediente produtoIngrediente);

    void criarTodosProdutoIncrediente(List<ProdutoIngrediente> produtoIngrediente);
}
