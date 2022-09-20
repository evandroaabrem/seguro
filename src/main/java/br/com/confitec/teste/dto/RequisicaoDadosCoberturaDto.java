package br.com.confitec.teste.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class RequisicaoDadosCoberturaDto {
    @NotBlank
    private Integer cobertura;
    @NotBlank
    private Double valor;

}
