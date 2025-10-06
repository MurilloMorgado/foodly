package br.com.foodly.foodly.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodly.foodly.framework.models.Cardapio;
import br.com.foodly.foodly.framework.service.CardapioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cardapio")
public class CardapioController {

    private final CardapioService cardapioService;

    @GetMapping
    @PreAuthorize("hasAnyRole ('ADMIN', 'USER')")
    public ResponseEntity<List<Cardapio>> listarCardapio() {
        List<Cardapio> listaCardapio = cardapioService.listarCardapio();
        return ResponseEntity.ok().body(listaCardapio);
    }
}
