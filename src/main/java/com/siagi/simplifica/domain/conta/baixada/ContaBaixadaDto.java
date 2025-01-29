package com.siagi.simplifica.domain.conta.baixada;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"})
@AllArgsConstructor
@NoArgsConstructor
public class ContaBaixadaDto {

  private String cnpjEmpresaEmitente;
  private String numeroDocumento;
  private String parcela;

  public ContaBaixadaDto(ContaBaixada entity) {
    this.cnpjEmpresaEmitente = entity.getCnpjEmpresaEmitente();
    this.numeroDocumento = entity.getNumeroDocumento();
    this.parcela = entity.getParcela();
  }

}
