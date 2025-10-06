package br.com.foodly.foodly.domain.security.models;

import java.util.List;

import br.com.foodly.foodly.framework.models.Cardapio;
import br.com.foodly.foodly.framework.models.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoRequest {

    Long id;
    String nome;
    String descricao;
    String tipo;
    Double preco;
    String categoria;
    String urlImagem;
    boolean status;
    Cardapio cardapio;
    List<Ingrediente> ingrediente;

}
