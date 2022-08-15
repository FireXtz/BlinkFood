package com.estagio.estudos.BlinksFoodAPI.domain.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity(name ="restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @EqualsAndHashCode.Include
    private String nome;

    @Column(name = "taxa_frete",nullable = false)
    @DecimalMin(value = "5")
    @DecimalMax(value = "300")
    private BigDecimal taxafrete;

    @ManyToOne
    private Cozinha cozinha;
    @Column(nullable = false)

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime dataUdpate;
}
