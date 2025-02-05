package com.siagi.simplifica.domain.integracao;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "fin_simplifica_integracao", catalog = "dbSIAGI_Sansuy", schema = "dbo")
@IdClass(ContaId.class)
public class Integracao extends Conta<ContaId> {
  private static final long serialVersionUID = 1L;

  public Integracao(Conta<ContaId> conta) {
    super(conta);
  }

  public static List<Integracao> toList(List<Conta<ContaId>> list) {
    return list.stream().map(Integracao::new).collect(Collectors.toList());
  }
}
