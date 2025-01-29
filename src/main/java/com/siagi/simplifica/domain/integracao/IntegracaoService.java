package com.siagi.simplifica.domain.integracao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.siagi.simplifica.domain.conta.baixada.ContaBaixadaDto;
import com.siagi.simplifica.domain.conta.baixada.ContaBaixadaRepository;
import com.siagi.simplifica.domain.conta.pendente.ContaPendente;
import com.siagi.simplifica.domain.conta.pendente.ContaPendenteDto;
import com.siagi.simplifica.domain.conta.pendente.ContaPendenteRepository;

@Service
public class IntegracaoService {

  @Autowired
  private IntegracaoRepository integracaoRepository;

  @Autowired
  private ContaPendenteRepository contaPendenteRepository;

  @Autowired
  private ContaBaixadaRepository contaBaixadoRepository;

  public IntegracaoDto integrarContaPendente() {

    ContaPendente contaPendente;
    Integracao integracao = null;

    Optional<ContaPendente> optional = contaPendenteRepository.findById(new ContaId("14807945000558", "300093915", ""));

    if (optional.isPresent()) {
      contaPendente = optional.get();
      integracao = integracaoRepository.save(new Integracao(contaPendente));
    }

    return integracao != null ? new IntegracaoDto(integracao) : null;
  }

  public List<IntegracaoDto> integrarContasPendentes() {

    List<ContaPendenteDto> result = contaPendenteRepository.findAll().stream()
        .map(ContaPendenteDto::new).collect(Collectors.toList());

    return null;
  }

  public IntegracaoDto integrarContaBaixada() {

    List<ContaBaixadaDto> result = contaBaixadoRepository.findAll().stream()
        .map(ContaBaixadaDto::new).collect(Collectors.toList());

    return null;
  }

  public List<IntegracaoDto> integrarContasBaixadas() {

    List<ContaBaixadaDto> result = contaBaixadoRepository.findAll().stream()
        .map(ContaBaixadaDto::new).collect(Collectors.toList());

    return null;
  }

}
