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
import com.siagi.simplifica.domain.titulo.baixado.TituloBaixadoDto;
import com.siagi.simplifica.domain.titulo.baixado.TituloBaixadoRepository;
import com.siagi.simplifica.domain.titulo.pendente.TituloPendenteDto;
import com.siagi.simplifica.domain.titulo.pendente.TituloPendenteRepository;

@RestController
@RequestMapping("financeiro")
public class FinanceiroAnaliseController {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private TituloPendenteRepository tituloPendenteRepository;

  @Autowired
  private TituloBaixadoRepository tituloBaixadoRepository;

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
  public ResponseEntity<List<TituloBaixadoDto>> buscarTitulosBaixados() {
    List<TituloBaixadoDto> result = tituloBaixadoRepository.findAll().stream()
        .map(TituloBaixadoDto::new).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/titulo-baixado/paginar")
  public ResponseEntity<Page<TituloBaixadoDto>> paginarTitulosBaixados(
      @PageableDefault(size = 10, page = 0, sort = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"}) Pageable pageable) {
    Page<TituloBaixadoDto> page = tituloBaixadoRepository.findAll(pageable).map(TituloBaixadoDto::new);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/titulo-pendente")
  public ResponseEntity<List<TituloPendenteDto>> list() {
    List<TituloPendenteDto> result = tituloPendenteRepository.findAll().stream()
        .map(TituloPendenteDto::new).collect(Collectors.toList());
    return ResponseEntity.ok(result);
  }

  @GetMapping("/titulo-pendente/paginar")
  public ResponseEntity<Page<TituloPendenteDto>> paginate(
      @PageableDefault(size = 10, page = 0, sort = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"}) Pageable pageable) {
    Page<TituloPendenteDto> page = tituloPendenteRepository.findAll(pageable).map(TituloPendenteDto::new);
    return ResponseEntity.ok(page);
  }

}
