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
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUTO_PROMOCAO")
public class ProdutoPromocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO_PROMOCAO")
    Long idProdutoPromocao;

    @ManyToOne
    @JoinColumn(name = "ID_PROMOCAO")
    Promocao promocao;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    Produto produto;
}
