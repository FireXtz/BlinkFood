package com.estagio.estudos.BlinksFoodAPI.dto;

import com.estagio.estudos.BlinksFoodAPI.domain.entity.Cozinha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteDTO {
    private Long id;
    private String nome;
    private BigDecimal taxafrete;
    private Cozinha cozinha;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUdpate;
}
