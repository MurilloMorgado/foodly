package br.com.foodly.foodly.framework.service;

import java.util.List;

import br.com.foodly.foodly.domain.security.models.ProdutoRequest;
import br.com.foodly.foodly.framework.models.Produto;

public interface ProdutoService {

    List<Produto> listarProdutos();

    Produto buscarProdutoById(Long idProduto);

    Long criarProduto(ProdutoRequest produtoRequest);

    void atualizarProdutoById(ProdutoRequest produtoRequest, Long idProduto);

    void deletarProdutoById(Long idProduto);
}
