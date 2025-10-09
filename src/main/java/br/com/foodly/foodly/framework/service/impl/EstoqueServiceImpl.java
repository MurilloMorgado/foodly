package br.com.foodly.foodly.framework.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.models.Estoque;
import br.com.foodly.foodly.framework.repositories.EstoqueRepository;
import br.com.foodly.foodly.framework.service.EstoqueService;
import jakarta.persistence.EntityExistsException;
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

        // Verificar se já existe um estoque para o ingrediente
        Long idIngrediente = estoque.getIngrediente().getIdIngrediente();
        Optional<Estoque> estoqueExiste = estoqueRepository.findByIngredienteIdIngrediente(idIngrediente);

        if (estoqueExiste.isPresent()) {
            throw new EntityExistsException("Já existe um estoque para o ingrediente com ID: " + idIngrediente);
        }

        // Caso não exista estoque, salva o novo estoque
        return estoqueRepository.save(estoque).getIdEstoque();

    }

    @Override
    public void atualizarEstoqueByIdIngrediente(Estoque estoque, Long idIngrediente) {

        Estoque estoqueDB = buscarEstoqueByIdIngrediente(idIngrediente);

        BeanUtils.copyProperties(estoque, estoqueDB, "idEstoque");

        estoqueRepository.save(estoqueDB);

    }

    @Override
    public void deletarEstoqueByIdIngrediente(Long idIngrediente) {
        
        estoqueRepository.deleteByIngredienteIdIngrediente(idIngrediente);
        
    }
}
