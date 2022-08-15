package com.estagio.estudos.BlinksFoodAPI.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "table_products")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private Double sub_total;
    @Column(nullable = false)
    private Double taxaFrete;
    @Column(nullable = false)
    private Boolean status;
    private Double valorTotal;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dataConfirmacao;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataEntrega;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    public Double getValorTotal() {
        return valorTotal = taxaFrete +sub_total;
    }

}
