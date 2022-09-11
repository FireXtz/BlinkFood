package com.estagio.estudos.BlinksFoodAPI.domain.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity(name ="tbl_forma_pagamento")
@Table(name ="tbl_forma_pagamento")
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "formapagamento",nullable = false)
    private String formapagamento;

}

