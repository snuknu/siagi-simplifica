package com.siagi.simplifica.controller;

import com.siagi.simplifica.domain.cliente.ClienteDto;
import com.siagi.simplifica.domain.cliente.ClienteRepository;
import com.siagi.simplifica.domain.conta.baixada.ContaBaixadaRepository;
import com.siagi.simplifica.domain.conta.pendente.ContaPendenteRepository;
import com.siagi.simplifica.domain.integracao.ContaDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("financeiro")
public class AnaliseController {
  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private ContaPendenteRepository tituloPendenteRepository;

  @Autowired
  private ContaBaixadaRepository tituloBaixadoRepository;

  @GetMapping("/cliente")
  public ResponseEntity<List<ClienteDto>> listarClientes() {
    List<ClienteDto> result = clienteRepository
      .findAll()
      .stream()
      .map(ClienteDto::new)
      .collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/cliente/paginar")
  public ResponseEntity<Page<ClienteDto>> paginarClientes(
    @PageableDefault(size = 10, page = 0, sort = { "codigoCliente" }) Pageable pageable
  ) {
    Page<ClienteDto> page = clienteRepository.findAll(pageable).map(ClienteDto::new);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/titulo-baixado")
  public ResponseEntity<List<ContaDto>> buscarTitulosBaixados() {
    List<ContaDto> result = tituloBaixadoRepository
      .findAll()
      .stream()
      .map(ContaDto::new)
      .collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/titulo-baixado/paginar")
  public ResponseEntity<Page<ContaDto>> paginarTitulosBaixados(
    @PageableDefault(
      size = 10,
      page = 0,
      sort = { "cnpjEmpresaEmitente", "numeroDocumento", "parcela" }
    ) Pageable pageable
  ) {
    Page<ContaDto> page = tituloBaixadoRepository.findAll(pageable).map(ContaDto::new);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/titulo-pendente")
  public ResponseEntity<List<ContaDto>> buscarTitulosPendentes() {
    List<ContaDto> result = tituloPendenteRepository
      .findAll()
      .stream()
      .map(ContaDto::new)
      .collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/titulo-pendente/paginar")
  public ResponseEntity<Page<ContaDto>> paginarTitulosPendentes(
    @PageableDefault(
      size = 10,
      page = 0,
      sort = { "cnpjEmpresaEmitente", "numeroDocumento", "parcela" }
    ) Pageable pageable
  ) {
    Page<ContaDto> page = tituloPendenteRepository.findAll(pageable).map(ContaDto::new);
    return ResponseEntity.ok(page);
  }
}
