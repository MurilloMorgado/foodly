package br.com.foodly.foodly.framework.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    Long idPessoa;

    @Column(name = "NOME_COMPLETO")
    String nomeCompleto;

    @Column(name = "CODE_DEPARTAMENTO_EXTERNO")
    String codeDepartamentoExterno;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "SITUACAO")
    boolean situacao;

    @Column(name = "USUARIO")
    String usuario;

}
