package com.siagi.simplifica.domain.cliente;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.siagi.simplifica.domain.simplifica.SimplificaClienteDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "codigoCliente")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDto implements Serializable {


  private static final long serialVersionUID = 4908327408700224062L;

  private Long codigoCliente;
  private String cnpjCliente;
  private String razaoSocial;
  private String email;
  private String cidade;
  private String estado;
  private String telefone;
  private String telefone2;
  private String telefone3;

  public ClienteDto(Cliente cliente) {
    this.codigoCliente = cliente.getCodigoCliente();
    this.cnpjCliente = cliente.getCnpjCliente();
    this.razaoSocial = cliente.getRazaoSocial();
    this.email = cliente.getEmail();
    this.cidade = cliente.getCidade();
    this.estado = cliente.getEstado();
    this.telefone = cliente.getTelefone();
    this.telefone2 = cliente.getTelefone2();
    this.telefone3 = cliente.getTelefone3();
  }

  public ClienteDto(SimplificaClienteDto cliente) {
    this.codigoCliente = cliente.getCodigoCliente();
    this.cnpjCliente = cliente.getCnpjCliente();
    this.razaoSocial = cliente.getRazaoSocial();
    this.email = cliente.getEmail();
    this.cidade = cliente.getCidade();
    this.estado = cliente.getEstado();
    this.telefone = cliente.getTelefone();
    this.telefone2 = cliente.getTelefone2();
    this.telefone3 = cliente.getTelefone3();
  }

  public static List<ClienteDto> toList(List<SimplificaClienteDto> list) {
    return list.stream().map(ClienteDto::new).collect(Collectors.toList());
  }

}
