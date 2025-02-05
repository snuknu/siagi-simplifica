package com.siagi.simplifica.domain.conta.baixada;

import com.siagi.simplifica.domain.integracao.Conta;
import com.siagi.simplifica.domain.integracao.ContaId;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "vw_boletos_baixados_teste", catalog = "dbSIAGI_Sansuy", schema = "dbo")
@IdClass(ContaId.class)
public class ContaBaixada extends Conta<ContaId> {
  private static final long serialVersionUID = 1L;

  public ContaBaixada(Conta<ContaId> conta) {
    super(conta);
  }

  public static List<ContaBaixada> toList(List<Conta<ContaId>> list) {
    return list.stream().map(ContaBaixada::new).collect(Collectors.toList());
  }
}
