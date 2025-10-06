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

import br.com.foodly.foodly.framework.models.Ingrediente;
import br.com.foodly.foodly.framework.service.IngredienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ingrediente")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Ingrediente>> listarIngrediente() {
        List<Ingrediente> ingredientes = ingredienteService.listarIngredientes();
        return ResponseEntity.ok().body(ingredientes);
    }

    @GetMapping(value = "/{idIngrediente}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Ingrediente> buscarIngredienteById(@PathVariable Long idIngrediente) {
        Ingrediente ingrediente = ingredienteService.buscarIngredienteById(idIngrediente);
        return ResponseEntity.ok().body(ingrediente);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> criarIngrediente(@RequestBody Ingrediente ingrediente) {
        Long idIngrediente = ingredienteService.criarIngrediente(ingrediente);
        return ResponseEntity.ok().body(idIngrediente);
    }

    @PutMapping(value = "/{idIngrediente}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> atualizarIngredienteById(@RequestBody Ingrediente ingrediente,
            @PathVariable Long idIngrediente) {
        ingredienteService.atualizarIngredienteById(ingrediente, idIngrediente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{idIngrediente}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletarIngredienteById(@PathVariable Long idIngrediente) {

        buscarIngredienteById(idIngrediente);

        ingredienteService.deletarIngredienteById(idIngrediente);
        return ResponseEntity.ok().build();
    }

}
