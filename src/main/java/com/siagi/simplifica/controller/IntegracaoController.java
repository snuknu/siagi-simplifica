package com.siagi.simplifica.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siagi.simplifica.domain.titulo.baixado.TituloBaixadoDto;
import com.siagi.simplifica.domain.titulo.baixado.TituloBaixadoRepository;
import com.siagi.simplifica.domain.titulo.pendente.TituloPendenteDto;
import com.siagi.simplifica.domain.titulo.pendente.TituloPendenteRepository;
import com.siagi.simplifica.service.IntegracaoService;

@RestController
@RequestMapping("integracao")
public class IntegracaoController {

  @Autowired
  private IntegracaoService integracaoService;

  @GetMapping("/titulo-pendente")
  public ResponseEntity<List<TituloPendenteDto>> list() {
    return ResponseEntity.ok(integracaoService.integraTitulosPendentes());
  }

  @GetMapping("/titulo-baixado")
  public ResponseEntity<List<TituloBaixadoDto>> buscarTitulosBaixados() {
    return ResponseEntity.ok(integracaoService.integraTitulosBaixados());
  }

}
