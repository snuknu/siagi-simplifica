package com.siagi.simplifica.controller;

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
import com.siagi.simplifica.domain.cliente.ClienteDto;
import com.siagi.simplifica.domain.cliente.ClienteRepository;
import com.siagi.simplifica.domain.conta.baixada.ContaBaixadaDto;
import com.siagi.simplifica.domain.conta.baixada.ContaBaixadaRepository;
import com.siagi.simplifica.domain.conta.pendente.ContaPendenteDto;
import com.siagi.simplifica.domain.conta.pendente.ContaPendenteRepository;

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
    List<ClienteDto> result = clienteRepository.findAll().stream()
        .map(ClienteDto::new).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/cliente/paginar")
  public ResponseEntity<Page<ClienteDto>> paginarClientes(
      @PageableDefault(size = 10, page = 0, sort = {"codigoCliente"}) Pageable pageable) {
    Page<ClienteDto> page = clienteRepository.findAll(pageable).map(ClienteDto::new);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/titulo-baixado")
  public ResponseEntity<List<ContaBaixadaDto>> buscarTitulosBaixados() {
    List<ContaBaixadaDto> result = tituloBaixadoRepository.findAll().stream()
        .map(ContaBaixadaDto::new).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/titulo-baixado/paginar")
  public ResponseEntity<Page<ContaBaixadaDto>> paginarTitulosBaixados(
      @PageableDefault(size = 10, page = 0, sort = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"}) Pageable pageable) {
    Page<ContaBaixadaDto> page = tituloBaixadoRepository.findAll(pageable).map(ContaBaixadaDto::new);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/titulo-pendente")
  public ResponseEntity<List<ContaPendenteDto>> buscarTitulosPendentes() {
    List<ContaPendenteDto> result = tituloPendenteRepository.findAll().stream()
        .map(ContaPendenteDto::new).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/titulo-pendente/paginar")
  public ResponseEntity<Page<ContaPendenteDto>> paginarTitulosPendentes(
      @PageableDefault(size = 10, page = 0, sort = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"}) Pageable pageable) {
    Page<ContaPendenteDto> page = tituloPendenteRepository.findAll(pageable).map(ContaPendenteDto::new);
    return ResponseEntity.ok(page);
  }

}
