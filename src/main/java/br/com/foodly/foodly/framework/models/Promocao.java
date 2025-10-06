package br.com.foodly.foodly.framework.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROMOCAO")
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROMOCAO")
    Long idPromocoes;

    @Column(name = "NOME_PROMOCAO")
    String nomePromocao;

    @Column(name = "TIPO_DE_DESCONTO")
    String tipoDesconto;

    @Column(name = "VALOR_DESCONTO")
    Double valorDesconto;

    @Column(name = "DATA_VALIDADE")
    LocalDateTime dataValidade;
}
