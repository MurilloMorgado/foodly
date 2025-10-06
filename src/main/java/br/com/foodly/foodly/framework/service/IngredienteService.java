package br.com.foodly.foodly.framework.service;

import java.util.List;

import br.com.foodly.foodly.framework.models.Ingrediente;

public interface IngredienteService {

    List<Ingrediente> listarIngredientes();

    Ingrediente buscarIngredienteById(Long idIngrediente);

    Long criarIngrediente(Ingrediente ingrediente);

    void atualizarIngredienteById(Ingrediente ingrediente, Long idIngrediente);

    void deletarIngredienteById(Long idIngrediente);
}
