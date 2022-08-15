package com.estagio.estudos.BlinksFoodAPI.domain.entity;

import lombok.*;
import javax.persistence.*;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cozinha_tbl")
@Table (name ="cozinha_tbl")
public class Cozinha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String nome;



}
