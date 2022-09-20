package br.com.confitec.teste.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RespostaDadosDto {

    List<RespostaDadosCampoDto> dados;
}
