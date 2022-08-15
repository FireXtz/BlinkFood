package com.estagio.estudos.BlinksFoodAPI.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Entity(name = "tbl_produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_produto",nullable = false)
    private String nome;
    @Column(name = "descricao_produto",nullable = false)
    private String descricao;
    @Column(name = "preco_produto", nullable = false)
    private BigDecimal preco;
    @Column(name = "ativo_produto",nullable = false)
    private Boolean ativo;
}
