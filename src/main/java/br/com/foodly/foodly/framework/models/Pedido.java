package br.com.foodly.foodly.framework.models;

import java.time.LocalDateTime;

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
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    Long idPedido;

    @Column(name = "STATUS")
    String status;

    @Column(name = "VALOR")
    Double valor;

    @Column(name = "DATA_HORA")
    LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "ID_PAGAMENTO")
    Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    Pessoa pessoa;

}
