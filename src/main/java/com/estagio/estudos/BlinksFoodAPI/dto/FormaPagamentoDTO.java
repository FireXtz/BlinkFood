package com.estagio.estudos.BlinksFoodAPI.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class FormaPagamentoDTO {
    private Long id;
    private String formapagamento;
}
