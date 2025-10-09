package br.com.foodly.foodly.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.models.Estoque;
import br.com.foodly.foodly.framework.repositories.EstoqueRepository;
import br.com.foodly.foodly.framework.service.EstoqueService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository estoqueRepository;

    @Override
    public List<Estoque> listarEstoque() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque buscarEstoqueByIdIngrediente(Long idIngrediente) {

        return estoqueRepository.findByIngredienteIdIngrediente(idIngrediente)
                .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado"));
    }

    @Override
    public Long criarEstoque(Estoque estoque) {

        return estoqueRepository.save(estoque).getIdEstoque();

    }

    @Override
    public void atualizarEstoqueByIdIngrediente(Estoque estoque, Long idIngrediente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarEstoqueByIdIngrediente'");
    }

    @Override
    public void deletarEstoqueByIdIngrediente(Long idIngrediente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarEstoqueByIdIngrediente'");
    }
}
