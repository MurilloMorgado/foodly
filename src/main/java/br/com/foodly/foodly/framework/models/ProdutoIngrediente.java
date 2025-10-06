package br.com.foodly.foodly.framework.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "PRODUTO_INGREDIENTE")
public class ProdutoIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO_INGREDIENTE")
    Long idProdutoIngrediente;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    Produto produto;

    @ManyToOne
    @JoinColumn(name = "ID_INGREDIENTE")
    Ingrediente ingrediente;

    @Column(name = "QUANTIDADE")
    String quantidade;

}
