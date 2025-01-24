package com.siagi.simplifica.domain.simplifica;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.siagi.simplifica.domain.cliente.Cliente;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SimplificaClienteDto implements Serializable {


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

  public SimplificaClienteDto(Cliente cliente) {
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

}
