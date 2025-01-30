package com.siagi.simplifica.domain.integracao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IntegracaoDto {
  
  @NotNull
  private String cnpjEmpresaEmitente;
  
  @NotNull
  private String numeroDocumento;
  
  @NotNull
  private String parcela;

  private Integer codigoEmpresaEmitente;
  private String enderecoEmpresaEmitente;
  private String razaoSocialEmpresaEmitente;
  private String cnpjCliente;
  private Integer codigoCliente;
  private String razaoSocialCliente;
  private String codigoDocumento;
  private LocalDate dataEmissao;
  private LocalDate dataVencimento;
  private Integer agencia;
  private Integer agenciaDv;
  private Integer conta;
  private Integer contaDv;
  private Integer codigoBeneficiario;
  private String carteira;
  private String numeroBancario;
  private String numeroBancarioDv;
  private Integer codigoBacen;
  private String descricaoBacen;
  private BigDecimal valor;
  private BigDecimal valorMulta;
  private BigDecimal valorJuros;
  private BigDecimal percentualMulta;
  private BigDecimal percentualJuros;
  private String chaveNf;
  private Integer numeroNf;

  private Integracao.Status status;
  private LocalDateTime dataEnvio;
  private String jsonRetornoEnvio;
  private LocalDateTime dataBaixa;
  private String jsonRetornoBaixa;

  public IntegracaoDto(Integracao entity) {
    
    this.cnpjEmpresaEmitente = entity.getCnpjEmpresaEmitente();
    this.numeroDocumento = entity.getNumeroDocumento();
    this.parcela = entity.getParcela();
    
    this.codigoEmpresaEmitente = entity.getCodigoEmpresaEmitente();
    this.enderecoEmpresaEmitente = entity.getEnderecoEmpresaEmitente();
    this.razaoSocialEmpresaEmitente = entity.getRazaoSocialEmpresaEmitente();
    this.cnpjCliente = entity.getCnpjCliente();
    this.codigoCliente = entity.getCodigoCliente();
    this.razaoSocialCliente = entity.getRazaoSocialCliente();
    this.codigoDocumento = entity.getCodigoDocumento();
    this.dataEmissao = entity.getDataEmissao();
    this.dataVencimento = entity.getDataVencimento();
    this.agencia = entity.getAgencia();
    this.agenciaDv = entity.getAgenciaDv();
    this.conta = entity.getConta();
    this.contaDv = entity.getContaDv();
    this.codigoBeneficiario = entity.getCodigoBeneficiario();
    this.carteira = entity.getCarteira();
    this.numeroBancario = entity.getNumeroBancario();
    this.numeroBancarioDv = entity.getNumeroBancarioDv();
    this.codigoBacen = entity.getCodigoBacen();
    this.descricaoBacen = entity.getDescricaoBacen();
    this.valor = entity.getValor();
    this.valorMulta = entity.getValorMulta();
    this.valorJuros = entity.getValorJuros();
    this.percentualMulta = entity.getPercentualMulta();
    this.percentualJuros = entity.getPercentualJuros();
    this.chaveNf = entity.getChaveNf();
    this.numeroNf = entity.getNumeroNf();

    this.status = entity.getStatus();
    this.dataEnvio = entity.getDataEnvio();
    this.jsonRetornoEnvio = entity.getJsonRetornoEnvio();
    this.dataBaixa = entity.getDataBaixa();
    this.jsonRetornoBaixa = entity.getJsonRetornoBaixa();
  }

  public static List<IntegracaoDto> toList(List<Integracao> list) {
    return list.stream().map(IntegracaoDto::new).collect(Collectors.toList());
  }

}
