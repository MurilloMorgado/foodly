package br.com.foodly.foodly.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.models.ProdutoIngrediente;
import br.com.foodly.foodly.framework.repositories.ProdutoIngredienteRepository;
import br.com.foodly.foodly.framework.service.ProdutoIngredienteService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoIngredienteServiceImpl implements ProdutoIngredienteService {

    private final ProdutoIngredienteRepository produtoIngredienteRepository;

    @Override
    public Long criarProdutoIncrediente(ProdutoIngrediente produtoIngrediente) {

        return produtoIngredienteRepository.save(produtoIngrediente).getIdProdutoIngrediente();

    }

    @Override
    public void criarTodosProdutoIncrediente(List<ProdutoIngrediente> produtoIngrediente) {

        produtoIngredienteRepository.saveAll(produtoIngrediente);
    }

    @Override
    public void deletarTodosProdutoIncredienteByIdProduto(Long idProduto) {
        
        produtoIngredienteRepository.deleteByProdutoId(idProduto);
        
    }

}
