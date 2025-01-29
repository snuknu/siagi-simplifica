package com.siagi.simplifica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siagi.simplifica.domain.conta.baixada.ContaBaixadaDto;
import com.siagi.simplifica.domain.conta.pendente.ContaPendenteDto;
import com.siagi.simplifica.domain.integracao.IntegracaoDto;
import com.siagi.simplifica.domain.integracao.IntegracaoService;

@RestController
@RequestMapping("integracao")
public class IntegracaoController {

  @Autowired
  private IntegracaoService integracaoService;

  @GetMapping("/conta-pendente")
  public ResponseEntity<IntegracaoDto> integrarContaPendente() {
    return ResponseEntity.ok(integracaoService.integrarContaPendente());
  }

  @GetMapping("/contas-pendentes")
  public ResponseEntity<List<IntegracaoDto>> integrarContasPendentes() {
    return ResponseEntity.ok(integracaoService.integrarContasPendentes());
  }

  @GetMapping("/conta-baixada")
  public ResponseEntity<List<IntegracaoDto>> integrarContaBaixada() {
    return ResponseEntity.ok(integracaoService.integrarContasBaixadas());
  }

  @GetMapping("/contas-baixado")
  public ResponseEntity<List<IntegracaoDto>> integrarContasBaixadas() {
    return ResponseEntity.ok(integracaoService.integrarContasBaixadas());
  }

}
