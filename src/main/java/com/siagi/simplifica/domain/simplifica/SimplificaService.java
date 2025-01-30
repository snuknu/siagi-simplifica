package com.siagi.simplifica.domain.simplifica;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.siagi.simplifica.config.SimplificaApiFactory;
import com.siagi.simplifica.domain.cliente.ClienteDto;

@Service
public class SimplificaService {

  @Autowired
  private SimplificaApiFactory simplificaApi;

  private final String PATH_CLIENTE = "/entity";

  private final Integer DEFAULT_PAGE_INDEX = 1;
  private final Integer DEFAULT_PAGE_SIZE = 10;

  public ResponseEntity<ClienteDto> obterCliente(String cnpjCliente) {
    return ResponseEntity.ok(new ClienteDto(simplificaApi.get(PATH_CLIENTE + "/" + cnpjCliente,
        new TypeReference<SimplificaClienteDto>() {}).getBody()));
  }

  public ResponseEntity<List<ClienteDto>> obterClientes() {
    return ResponseEntity.ok(ClienteDto.toList(simplificaApi.get(PATH_CLIENTE + pagination(DEFAULT_PAGE_INDEX, 2),
        new TypeReference<SimplificaDados<SimplificaClienteDto>>() {}).getBody().getRows()));
  }

  private String pagination(Integer pageIndex, Integer pageSize, String... fields) {
    return "?" +
        ((pageIndex != null) ? "pageIndex=" + pageIndex : "pageIndex=" + DEFAULT_PAGE_INDEX) +
        ((pageSize != null) ? "&pageSize=" + pageSize : "&pageSize=" + DEFAULT_PAGE_SIZE) +
        ((fields.length > 0) ? "&fields=" + String.join(",", fields) : "");
  }

}
