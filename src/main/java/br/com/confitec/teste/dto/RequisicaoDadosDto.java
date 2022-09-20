package br.com.confitec.teste.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class RequisicaoDadosDto {
    @NotBlank
    List<RequisicaoDadosCoberturaDto> listCobertura;
    @NotBlank
    List<RequisicaoDadosParcelamentoDto> listOpcaoParcelamento;
}
