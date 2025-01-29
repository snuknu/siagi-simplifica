package com.siagi.simplifica.domain.conta.pendente;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siagi.simplifica.domain.integracao.ContaId;

public interface ContaPendenteRepository extends JpaRepository<ContaPendente, ContaId> {

}
