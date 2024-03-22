package com.lib.poliza.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestInputDTO {
    private Integer tipo_identificacion;
    @NotBlank
    private String nro_identificacion;
    private Integer valor_asegurado;
}
