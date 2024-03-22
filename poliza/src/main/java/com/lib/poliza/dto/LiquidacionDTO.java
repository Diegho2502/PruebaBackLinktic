package com.lib.poliza.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LiquidacionDTO {
    private Integer codigo_amparo;
    private String nombre_amparo;
    private Double valor_prima;
}
