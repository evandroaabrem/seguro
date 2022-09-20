package br.com.confitec.teste.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class RequisicaoDadosParcelamentoDto {
    @NotBlank
    private Integer quantidadeMinimaParcelas;
    @NotBlank
    private Integer quantidadeMaximaParcelas;
    @NotBlank
    private Double juros;
}
