package com.siagi.simplifica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siagi.simplifica.domain.cliente.ClienteDto;
import com.siagi.simplifica.domain.simplifica.SimplificaService;

@RestController
@RequestMapping("simplifica")
public class SimplificaController {

  @Autowired
  private SimplificaService simplificaService;

  @GetMapping("/cliente")
  public ResponseEntity<List<ClienteDto>> listar() {
    return simplificaService.obterClientes();
  }

  @GetMapping("/cliente/{cnpj}")
  public ResponseEntity<ClienteDto> detalhar(@PathVariable("cnpj") String cnpjCliente) {
    return simplificaService.obterCliente(cnpjCliente);
  }

}
