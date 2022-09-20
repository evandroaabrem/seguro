package br.com.confitec.teste.service;

import br.com.confitec.teste.dto.RequisicaoDadosDto;
import br.com.confitec.teste.dto.RespostaDadosDto;

import java.util.List;

public interface ParcelamentoService {

    public List<RespostaDadosDto> calculaApolice(RequisicaoDadosDto requisicaoDadosDto);
}
