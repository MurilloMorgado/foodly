package br.com.foodly.foodly.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodly.foodly.framework.models.Estoque;
import br.com.foodly.foodly.framework.service.EstoqueService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Estoque>> listarEstoque() {
        List<Estoque> listaEstoque = estoqueService.listarEstoque();
        return ResponseEntity.ok().body(listaEstoque);
    }

    @GetMapping(value = "/{idIngrediente}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Estoque> buscarEstoqueByIdIngrediente(Long idIngrediente) {
        Estoque estoque = estoqueService.buscarEstoqueByIdIngrediente(idIngrediente);
        return ResponseEntity.ok().body(estoque);
    }

    @PostMapping
    public ResponseEntity<Long> criarEstoque(@RequestBody Estoque estoque) {
        Long idEstoque = estoqueService.criarEstoque(estoque);
        return ResponseEntity.ok().body(idEstoque);
    }

    @PutMapping(value = "/{idIngrediente}")
    public ResponseEntity<Long> atualizarEstoque(@RequestBody Estoque estoque, @PathVariable Long idIngrediente) {
        estoqueService.atualizarEstoqueByIdIngrediente(estoque, idIngrediente);
        return ResponseEntity.ok().build();
    }

}
