package com.siagi.simplifica.domain.conta.baixada;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siagi.simplifica.domain.integracao.ContaId;


public interface ContaBaixadaRepository extends JpaRepository<ContaBaixada, ContaId> {

}
