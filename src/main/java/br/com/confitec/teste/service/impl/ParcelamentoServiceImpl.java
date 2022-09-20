package br.com.confitec.teste.service.impl;

import br.com.confitec.teste.dto.ParcelamentoDto;
import br.com.confitec.teste.dto.RequisicaoDadosDto;
import br.com.confitec.teste.dto.RespostaDadosCampoDto;
import br.com.confitec.teste.dto.RespostaDadosDto;
import br.com.confitec.teste.service.ParcelamentoService;
import br.com.confitec.teste.util.FormatoDado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ParcelamentoServiceImpl implements ParcelamentoService {

    private List<ParcelamentoDto> lstParcelamento = new ArrayList<>();
    @Override
    public List<RespostaDadosDto> calculaApolice(RequisicaoDadosDto requisicaoDadosDto) {

        Double valorSomado = getValorSomado(requisicaoDadosDto);

        populaLista(requisicaoDadosDto, lstParcelamento);

        return getConfiguraLista(lstParcelamento, valorSomado);
    }

    private List<RespostaDadosDto> getConfiguraLista(List<ParcelamentoDto> lstParcelamento, Double valorSomado) {
        List<RespostaDadosCampoDto> lstRespostaDado = lstParcelamento.stream().map(item -> buildResposta(item, valorSomado)).collect(Collectors.toList());
        List<RespostaDadosDto> lstResposta = new ArrayList<>();
        RespostaDadosDto respostaDadosDto = RespostaDadosDto.builder().dados(lstRespostaDado).build();
        lstResposta.add(respostaDadosDto);
        return lstResposta;
    }

    private static void populaLista(RequisicaoDadosDto requisicaoDadosDto, List<ParcelamentoDto> lstParcelamento) {
        requisicaoDadosDto.getListOpcaoParcelamento().forEach(item -> {
            IntStream   stream123 = IntStream.rangeClosed(item.getQuantidadeMinimaParcelas(), item.getQuantidadeMaximaParcelas());
            stream123.forEach(temp1 -> {
                ParcelamentoDto parcelamentoDto = new ParcelamentoDto();
                parcelamentoDto.setParcela(temp1);
                parcelamentoDto.setJuros(item.getJuros());
                lstParcelamento.add(parcelamentoDto);

            });
        });
    }

    private static Double getValorSomado(RequisicaoDadosDto requisicaoDadosDto) {
        return requisicaoDadosDto.getListCobertura().stream()
                .filter(x -> x.getValor() != null)
                .mapToDouble(x -> x.getValor()).sum();
    }


    private RespostaDadosCampoDto buildResposta(ParcelamentoDto parcelamentoDto, Double valorInicial) {
        Double valorFinal = FormatoDado.formataValor(valorInicial * Math.pow((1+parcelamentoDto.getJuros()),parcelamentoDto.getParcela() ));

        return RespostaDadosCampoDto.builder()
                .quantidadeParcelas(parcelamentoDto.getParcela())
                .valorPrimeiraParcela(FormatoDado.formataValor((valorFinal/parcelamentoDto.getParcela().doubleValue())))
                .valorDemaisParcelas(parcelamentoDto.getParcela() > 1 ? FormatoDado.formataValor((valorFinal/parcelamentoDto.getParcela().doubleValue())) : null)
                .valorParcelamentoTotal(FormatoDado.formataValor(valorFinal))
                .build();
    }

}


