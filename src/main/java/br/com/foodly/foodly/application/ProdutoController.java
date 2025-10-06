package br.com.foodly.foodly.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodly.foodly.domain.security.models.ProdutoRequest;
import br.com.foodly.foodly.framework.models.Produto;
import br.com.foodly.foodly.framework.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> listaProduto = produtoService.listarProdutos();
        return ResponseEntity.ok().body(listaProduto);
    }

    @GetMapping(value = "/{idProduto}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Produto> buscarProdutoById(@PathVariable Long idProduto) {
        Produto produto = produtoService.buscarProdutoById(idProduto);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> criarProduto(@RequestBody ProdutoRequest produtoRequest) {
        Long idProduto = produtoService.criarProduto(produtoRequest);
        return ResponseEntity.ok().body(idProduto);
    }

    @PutMapping(value = "{idProduto}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> atualizarProdutoById(@RequestBody ProdutoRequest produtoRequest, @PathVariable Long idProduto) {
        produtoService.atualizarProdutoById(produtoRequest, idProduto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{idProduto}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletarProdutoById(@PathVariable Long idProduto) {
        produtoService.deletarProdutoById(idProduto);
        return ResponseEntity.ok().build();
    }
}
