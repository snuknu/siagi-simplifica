package com.siagi.simplifica.domain.integracao;

import com.siagi.simplifica.domain.conta.baixada.ContaBaixadaRepository;
import com.siagi.simplifica.domain.conta.pendente.ContaPendente;
import com.siagi.simplifica.domain.conta.pendente.ContaPendenteRepository;
import com.siagi.simplifica.domain.integracao.Conta.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegracaoService {
  @Autowired
  private IntegracaoRepository integracaoRepository;

  @Autowired
  private ContaPendenteRepository contaPendenteRepository;

  @Autowired
  private ContaBaixadaRepository contaBaixadoRepository;

  public ContaDto integrarContaPendente(ContaDto dto) {
    ContaPendente contaPendente;
    Integracao integracao = null;

    Optional<ContaPendente> optional = contaPendenteRepository.findById(
      new ContaId(
        dto.getCnpjEmpresaEmitente(),
        dto.getNumeroDocumento(),
        dto.getParcela()
      )
    );

    if (optional.isPresent()) {
      contaPendente = optional.get();
      integracao = new Integracao(contaPendente);
      integracao.setStatus(Status.PENDENTE_DE_ENVIO);
      integracaoRepository.save(integracao);
    }

    return integracao != null ? new ContaDto(integracao) : null;
  }

  public List<ContaDto> integrarContasPendentes() {
    List<ContaPendente> contasPendentes = contaPendenteRepository.findAll();
    List<ContaDto> list = new ArrayList<ContaDto>();

    contasPendentes.forEach(
      contasPendente -> {
        Integracao integracao = new Integracao(contasPendente);
        integracao.setStatus(Status.PENDENTE_DE_ENVIO);
        list.add(new ContaDto(integracaoRepository.save(integracao)));
      }
    );

    return list;
  }

  public ContaDto integrarContaBaixada() {
    List<ContaDto> result = contaBaixadoRepository
      .findAll()
      .stream()
      .map(ContaDto::new)
      .collect(Collectors.toList());

    return null;
  }

  public List<ContaDto> integrarContasBaixadas() {
    List<ContaDto> result = contaBaixadoRepository
      .findAll()
      .stream()
      .map(ContaDto::new)
      .collect(Collectors.toList());

    return null;
  }
}
