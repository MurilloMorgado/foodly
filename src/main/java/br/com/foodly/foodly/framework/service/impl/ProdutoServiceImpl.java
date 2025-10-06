package br.com.foodly.foodly.framework.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.foodly.foodly.domain.security.models.ProdutoRequest;
import br.com.foodly.foodly.framework.models.Produto;
import br.com.foodly.foodly.framework.models.ProdutoIngrediente;
import br.com.foodly.foodly.framework.repositories.ProdutoRespository;
import br.com.foodly.foodly.framework.service.IngredienteService;
import br.com.foodly.foodly.framework.service.ProdutoIngredienteService;
import br.com.foodly.foodly.framework.service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRespository produtosRespository;
    private final ProdutoIngredienteService produtoIngredienteService;
    private final IngredienteService ingredienteService;

    @Override
    public List<Produto> listarProdutos() {
        return produtosRespository.findAll();
    }

    @Override
    public Produto buscarProdutoById(Long idProduto) {
        return produtosRespository.findById(idProduto)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    @Override
    public Long criarProduto(ProdutoRequest produtoRequest) {

        Produto newProduto = new Produto(produtoRequest);

        Produto produtoSalvo = produtosRespository.save(newProduto);

        // Vinculo
        List<ProdutoIngrediente> vinculos = produtoRequest.getIngrediente().stream()
                .map(item -> {
                    ProdutoIngrediente produtoIngrediente = new ProdutoIngrediente();

                    produtoIngrediente.setProduto(produtoSalvo);
                    produtoIngrediente.setQuantidade("1");

                    produtoIngrediente
                            .setIngrediente(ingredienteService.buscarIngredienteById(item.getIdIngrediente()));

                    return produtoIngrediente;

                }).collect(Collectors.toList());

        produtoIngredienteService.criarTodosProdutoIncrediente(vinculos);

        return produtoSalvo.getId();

    }

    @Override
    public void atualizarProdutoById(ProdutoRequest produtoRequest, Long idProduto) {

        Produto produtoDB = buscarProdutoById(idProduto);
        Produto newProduto = new Produto(produtoRequest);

        BeanUtils.copyProperties(produtoDB, newProduto, "idProduto");
        produtosRespository.save(produtoDB);

        // Deletar Vinculo
        produtoIngredienteService.deletarTodosProdutoIncredienteByIdProduto(idProduto);

        // Vinculo
        List<ProdutoIngrediente> vinculos = produtoRequest.getIngrediente().stream()
                .map(item -> {
                    ProdutoIngrediente produtoIngrediente = new ProdutoIngrediente();

                    produtoIngrediente.setProduto(newProduto);
                    produtoIngrediente.setQuantidade("1");

                    produtoIngrediente
                            .setIngrediente(ingredienteService.buscarIngredienteById(item.getIdIngrediente()));

                    return produtoIngrediente;

                }).collect(Collectors.toList());

        produtoIngredienteService.criarTodosProdutoIncrediente(vinculos);
    }

    @Override
    public void deletarProdutoById(Long idProduto) {
        produtosRespository.deleteById(idProduto);
    }
}
