package com.siagi.simplifica.domain.integracao;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"})
public class ContaId implements Serializable {

  private static final long serialVersionUID = 1L;

  private String cnpjEmpresaEmitente;
  private String numeroDocumento;
  private String parcela;

}

