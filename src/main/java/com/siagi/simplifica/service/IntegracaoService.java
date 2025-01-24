package com.siagi.simplifica.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.siagi.simplifica.domain.titulo.baixado.TituloBaixadoDto;
import com.siagi.simplifica.domain.titulo.baixado.TituloBaixadoRepository;
import com.siagi.simplifica.domain.titulo.pendente.TituloPendenteDto;
import com.siagi.simplifica.domain.titulo.pendente.TituloPendenteRepository;

@Service
public class IntegracaoService {

  @Autowired
  private TituloPendenteRepository tituloPendenteRepository;

  @Autowired
  private TituloBaixadoRepository tituloBaixadoRepository;


  public List<TituloPendenteDto> integraTitulosPendentes() {

    List<TituloPendenteDto> result = tituloPendenteRepository.findAll().stream()
        .map(TituloPendenteDto::new).collect(Collectors.toList());

    return result;
  }


  public List<TituloBaixadoDto> integraTitulosBaixados() {

    List<TituloBaixadoDto> result = tituloBaixadoRepository.findAll().stream()
        .map(TituloBaixadoDto::new).collect(Collectors.toList());

    return result;
  }

}
