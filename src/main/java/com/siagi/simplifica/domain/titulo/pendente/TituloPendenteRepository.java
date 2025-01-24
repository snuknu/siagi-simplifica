package com.siagi.simplifica.domain.titulo.pendente;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siagi.simplifica.domain.titulo.TituloId;

public interface TituloPendenteRepository extends JpaRepository<TituloPendente, TituloId> {

}
