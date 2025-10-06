package br.com.foodly.foodly.framework.models;

import br.com.foodly.foodly.domain.security.models.ProdutoRequest;
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
@Table(name = "PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NOME")
    String nome;

    @Column(name = "DESCRICAO")
    String descricao;

    @Column(name = "TIPO")
    String tipo;

    @Column(name = "PRECO")
    Double preco;

    @Column(name = "CATEGORIA")
    String categoria;

    @Column(name = "URL_IMAGEM")
    String urlImagem;

    @Column(name = "STATUS")
    boolean status;

    @ManyToOne
    @JoinColumn(name = "ID_CARDAPIO")
    Cardapio cardapio;

    public Produto(ProdutoRequest produtoRequest) {
        this.nome = produtoRequest.getNome();
        this.descricao = produtoRequest.getDescricao();
        this.tipo = produtoRequest.getTipo();
        this.preco = produtoRequest.getPreco();
        this.categoria = produtoRequest.getCategoria();
        this.urlImagem = produtoRequest.getUrlImagem();
        this.status = produtoRequest.isStatus();
        this.cardapio = produtoRequest.getCardapio();
    }
}
