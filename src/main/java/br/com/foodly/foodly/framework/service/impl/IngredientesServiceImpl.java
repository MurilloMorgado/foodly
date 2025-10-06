package br.com.foodly.foodly.framework.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.models.Ingrediente;
import br.com.foodly.foodly.framework.repositories.IngredienteRespository;
import br.com.foodly.foodly.framework.service.IngredienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class IngredientesServiceImpl implements IngredienteService {

    private final IngredienteRespository ingredienteRespository;

    @Override
    public List<Ingrediente> listarIngredientes() {

        List<Ingrediente> ingredientes = ingredienteRespository.findAll();
        return ingredientes;

    }

    @Override
    public Long criarIngrediente(Ingrediente ingrediente) {
        return ingredienteRespository.save(ingrediente).getIdIngrediente();

    }

    @Override
    public Ingrediente buscarIngredienteById(Long idIngrediente) {
        Ingrediente ingrediente = ingredienteRespository.findById(idIngrediente)
                .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado"));
        return ingrediente;
    }

    @Override
    public void atualizarIngredienteById(Ingrediente ingrediente, Long idIngrediente) {
        
        Ingrediente ingredienteDb = buscarIngredienteById(idIngrediente);

        BeanUtils.copyProperties(ingrediente, ingredienteDb, "idIngrediente");
        ingredienteRespository.save(ingredienteDb);
        
    }

    @Override
    public void deletarIngredienteById(Long idIngrediente) {

        ingredienteRespository.deleteById(idIngrediente);

    }
}
