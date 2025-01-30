package com.siagi.simplifica.domain.integracao;

import java.util.ArrayList;
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
import com.siagi.simplifica.domain.integracao.Integracao.Status;

@Service
public class IntegracaoService {

  @Autowired
  private IntegracaoRepository integracaoRepository;

  @Autowired
  private ContaPendenteRepository contaPendenteRepository;

  @Autowired
  private ContaBaixadaRepository contaBaixadoRepository;

  /**
   * Realiza a integração de conta pendente de envio.
   */
  public IntegracaoDto integrarContaPendente(IntegracaoDto dto) {

    ContaPendente contaPendente;
    Integracao integracao = null;

    Optional<ContaPendente> optional = contaPendenteRepository.findById(
        new ContaId(
            dto.getCnpjEmpresaEmitente(),
            dto.getNumeroDocumento(),
            dto.getParcela()));

    if (optional.isPresent()) {
      contaPendente = optional.get();
      integracao = new Integracao(contaPendente);
      integracao.setStatus(Status.PENDENTE_DE_ENVIO);
      integracaoRepository.save(integracao);
    }

    return integracao != null ? new IntegracaoDto(integracao) : null;
  }

  /**
   * Realiza a integração de contas pendentes de envio.
   */
  public List<IntegracaoDto> integrarContasPendentes() {

    List<ContaPendente> contasPendentes = contaPendenteRepository.findAll();
    List<IntegracaoDto> list = new ArrayList<IntegracaoDto>();

    contasPendentes.forEach(contasPendente -> {
      Integracao integracao = new Integracao(contasPendente);
      integracao.setStatus(Status.PENDENTE_DE_ENVIO);
      list.add(new IntegracaoDto(integracaoRepository.save(integracao)));
    });

    return list;
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
