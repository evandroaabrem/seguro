package br.com.confitec.teste;

import br.com.confitec.teste.dto.RequisicaoDadosCoberturaDto;
import br.com.confitec.teste.dto.RequisicaoDadosDto;
import br.com.confitec.teste.dto.RequisicaoDadosParcelamentoDto;
import br.com.confitec.teste.service.ParcelamentoService;
import br.com.confitec.teste.service.impl.ParcelamentoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
public class ApoliceTest {

    @InjectMocks
    private ParcelamentoService parcelamentoService  = new ParcelamentoServiceImpl();

    @Test
    public void calculaApoliceOkTest() {
        RequisicaoDadosDto requisicaoDadosDto = buildRequisicaoDadosDto();
        assertTrue(parcelamentoService.calculaApolice(requisicaoDadosDto).size() > 0);

    }

    @Test
    public void calculaApoliceNotNullPointerTest() {
        RequisicaoDadosDto requisicaoDadosDto = buildRequisicaoDadosDto();
        assertNotNull(parcelamentoService.calculaApolice(requisicaoDadosDto));

    }

    @Test
    public void calculaApoliceValorTotalDaPrimeiraParcelaTest() {
        RequisicaoDadosDto requisicaoDadosDto =  buildRequisicaoDadosDto();
         assertEquals(468.57, parcelamentoService.calculaApolice(requisicaoDadosDto).get(0).getDados().get(0).getValorParcelamentoTotal());
    }


    private RequisicaoDadosDto buildRequisicaoDadosDto() {
        List<RequisicaoDadosCoberturaDto> listCobertura = new ArrayList<>();
        RequisicaoDadosCoberturaDto requisicaoDadosCoberturaDtoObj1 =
                                               RequisicaoDadosCoberturaDto.builder()
                                                       .cobertura(1)
                                                       .valor(123.12)
                                               .build();
        listCobertura.add(requisicaoDadosCoberturaDtoObj1);
        RequisicaoDadosCoberturaDto requisicaoDadosCoberturaDtoObj2 =
                RequisicaoDadosCoberturaDto.builder()
                        .cobertura(4)
                        .valor(345.45)
                        .build();
        listCobertura.add(requisicaoDadosCoberturaDtoObj2);
        RequisicaoDadosDto requisicaoDadosDto = RequisicaoDadosDto.builder().listCobertura(listCobertura)
                .listOpcaoParcelamento(buildRequisicaoDadosParcelamentoDto())
                .build();
        return requisicaoDadosDto;

    }

    private List<RequisicaoDadosParcelamentoDto> buildRequisicaoDadosParcelamentoDto(){
        List<RequisicaoDadosParcelamentoDto> listRequisicaoDadosParcelamentoDto = new ArrayList<>();
        RequisicaoDadosParcelamentoDto obj1 = RequisicaoDadosParcelamentoDto.builder()
                .quantidadeMinimaParcelas(1)
                .quantidadeMaximaParcelas(6)
                .juros(0.0)
                .build();
        listRequisicaoDadosParcelamentoDto.add(obj1);
        RequisicaoDadosParcelamentoDto obj2 = RequisicaoDadosParcelamentoDto.builder()
                .quantidadeMinimaParcelas(7)
                .quantidadeMaximaParcelas(9)
                .juros(0.01)
                .build();
        listRequisicaoDadosParcelamentoDto.add(obj2);
        RequisicaoDadosParcelamentoDto obj3 = RequisicaoDadosParcelamentoDto.builder()
                .quantidadeMinimaParcelas(10)
                .quantidadeMaximaParcelas(12)
                .juros(0.03)
                .build();
        listRequisicaoDadosParcelamentoDto.add(obj3);
        return listRequisicaoDadosParcelamentoDto;

    }



}
