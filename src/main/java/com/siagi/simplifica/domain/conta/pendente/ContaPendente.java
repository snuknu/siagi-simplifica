package com.siagi.simplifica.domain.conta.pendente;

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
@Table(name = "vw_boletos_pendentes_teste", catalog = "dbSIAGI_Sansuy", schema = "dbo")
@IdClass(ContaId.class)
public class ContaPendente extends Conta<ContaId> {
  private static final long serialVersionUID = 1L;

  public ContaPendente(Conta<ContaId> conta) {
    super(conta);
  }

  public static List<ContaPendente> toList(List<Conta<ContaId>> list) {
    return list.stream().map(ContaPendente::new).collect(Collectors.toList());
  }
}
