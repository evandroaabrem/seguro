package br.com.confitec.teste.controller;

import br.com.confitec.teste.dto.RequisicaoDadosDto;
import br.com.confitec.teste.service.ParcelamentoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/confitec/teste")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApoliceController {

    @Autowired
    private ParcelamentoService parcelamento;

    @PostMapping("/parcelamento")
    public ResponseEntity<Object> calculaParcelamento(@RequestBody RequisicaoDadosDto requisicaoDadosDto){
        return ResponseEntity.status(HttpStatus.OK).body(parcelamento.calculaApolice(requisicaoDadosDto));
    }
}
