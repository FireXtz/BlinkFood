package com.estagio.estudos.BlinksFoodAPI.domain.entity;

import lombok.Data;
import javax.persistence.*;
@Data
@Entity(name = "tbl_Item_products")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private Double precoUnitario;
    private Double precoTotal;
    @Column(nullable = false)
    private String observacao;
    @ManyToOne
    private FormaPagamento formaPagamento;
    @ManyToOne
    private Restaurante restaurante;
    private StatusPedido statusPedido;


    public Double getPrecoTotal() {
        return precoTotal = quantidade * precoUnitario;
    }
    public enum StatusPedido {
        CRIADO,CONFIRMADO,ENTREGUE,CANCELADO
    }

}
