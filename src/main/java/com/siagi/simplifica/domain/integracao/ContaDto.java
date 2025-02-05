package com.siagi.simplifica.domain.integracao;

import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContaDto extends Conta<ContaId> {
  private static final long serialVersionUID = 1L;

  public ContaDto(Conta<ContaId> conta) {
    super(conta);
  }

  public static List<ContaDto> toList(List<Conta<ContaId>> list) {
    return list.stream().map(ContaDto::new).collect(Collectors.toList());
  }
}
