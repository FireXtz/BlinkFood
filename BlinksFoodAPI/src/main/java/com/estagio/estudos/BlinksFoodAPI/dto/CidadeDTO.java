package com.estagio.estudos.BlinksFoodAPI.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CidadeDTO {
    private Long id;
    private String cidade;
}
