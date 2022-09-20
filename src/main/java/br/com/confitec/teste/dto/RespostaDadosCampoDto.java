package br.com.confitec.teste.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaDadosCampoDto {
    private Integer quantidadeParcelas;
    private Double valorPrimeiraParcela;
    private Double valorDemaisParcelas;
    private Double valorParcelamentoTotal;
}
