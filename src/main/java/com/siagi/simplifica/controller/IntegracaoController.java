package com.siagi.simplifica.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siagi.simplifica.domain.integracao.ContaDto;
import com.siagi.simplifica.domain.integracao.IntegracaoRepository;
import com.siagi.simplifica.domain.integracao.IntegracaoService;

@RestController
@RequestMapping("integracao")
public class IntegracaoController {

  @Autowired
  private IntegracaoService integracaoService;

  @Autowired
  private IntegracaoRepository integracaoRepository;

  @PostMapping("/conta-pendente")
  public ResponseEntity<ContaDto> integrarContaPendente(@RequestBody @Valid ContaDto integracaoDto) {
    return ResponseEntity.ok(integracaoService.integrarContaPendente(integracaoDto));
  }

  @GetMapping("/conta-pendente")
  public ResponseEntity<List<ContaDto>> integrarContasPendentes() {
    return ResponseEntity.ok(integracaoService.integrarContasPendentes());
  }

  @GetMapping("/conta-baixada")
  public ResponseEntity<List<ContaDto>> integrarContaBaixada() {
    return ResponseEntity.ok(integracaoService.integrarContasBaixadas());
  }

  @GetMapping("/contas-baixado")
  public ResponseEntity<List<ContaDto>> integrarContasBaixadas() {
    return ResponseEntity.ok(integracaoService.integrarContasBaixadas());
  }

  @GetMapping("/conta-integrada")
  public ResponseEntity<List<ContaDto>> listarContasIntegradas() {
    List<ContaDto> result = integracaoRepository.findAll().stream()
        .map(ContaDto::new).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/conta-integrada/paginar")
  public ResponseEntity<Page<ContaDto>> listarContasIntegradas(
      @PageableDefault(size = 10, page = 0, sort = {"codigoCliente"}) Pageable pageable) {
    Page<ContaDto> page = integracaoRepository.findAll(pageable).map(ContaDto::new);
    return ResponseEntity.ok(page);
  }
}
