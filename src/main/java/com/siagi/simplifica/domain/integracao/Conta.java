package com.siagi.simplifica.domain.integracao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "cnpjEmpresaEmitente", "numeroDocumento", "parcela" })
@MappedSuperclass
public abstract class Conta<T extends Serializable> implements Serializable {
  private static final long serialVersionUID = 1L;

  public enum Status {
    PENDENTE_DE_ENVIO("Pendente de envio"),
    ENVIADO("Enviado"),
    PENDENTE_DE_BAIXA("Pendente de baixa"),
    BAIXADO("Baixado");

    private String info;

    private Status(String info) {
      this.info = info;
    }

    @Override
    public String toString() {
      return info;
    }
  }

  @Id
  @Column(name = "cnpj_empresa_emitente")
  private String cnpjEmpresaEmitente;

  @Id
  @Column(name = "numero_documento")
  private String numeroDocumento;

  @Id
  @Column(name = "parcela")
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

  private Status status;
  private LocalDateTime dataEnvio;
  private String jsonRetornoEnvio;
  private LocalDateTime dataBaixa;
  private String jsonRetornoBaixa;

  public Conta(Conta<T> conta) {
    this.cnpjEmpresaEmitente = conta.getCnpjEmpresaEmitente();
    this.numeroDocumento = conta.getNumeroDocumento();
    this.parcela = conta.getParcela();
    this.codigoEmpresaEmitente = conta.getCodigoEmpresaEmitente();
    this.enderecoEmpresaEmitente = conta.getEnderecoEmpresaEmitente();
    this.razaoSocialEmpresaEmitente = conta.getRazaoSocialEmpresaEmitente();
    this.cnpjCliente = conta.getCnpjCliente();
    this.codigoCliente = conta.getCodigoCliente();
    this.razaoSocialCliente = conta.getRazaoSocialCliente();
    this.codigoDocumento = conta.getCodigoDocumento();
    this.dataEmissao = conta.getDataEmissao();
    this.dataVencimento = conta.getDataVencimento();
    this.agencia = conta.getAgencia();
    this.agenciaDv = conta.getAgenciaDv();
    this.conta = conta.getConta();
    this.contaDv = conta.getContaDv();
    this.codigoBeneficiario = conta.getCodigoBeneficiario();
    this.carteira = conta.getCarteira();
    this.numeroBancario = conta.getNumeroBancario();
    this.numeroBancarioDv = conta.getNumeroBancarioDv();
    this.codigoBacen = conta.getCodigoBacen();
    this.descricaoBacen = conta.getDescricaoBacen();
    this.valor = conta.getValor();
    this.valorMulta = conta.getValorMulta();
    this.valorJuros = conta.getValorJuros();
    this.percentualMulta = conta.getPercentualMulta();
    this.percentualJuros = conta.getPercentualJuros();
    this.chaveNf = conta.getChaveNf();
    this.numeroNf = conta.getNumeroNf();
    this.status = conta.getStatus();
    this.dataEnvio = conta.getDataEnvio();
    this.jsonRetornoEnvio = conta.getJsonRetornoEnvio();
    this.dataBaixa = conta.getDataBaixa();
    this.jsonRetornoBaixa = conta.getJsonRetornoBaixa();
  }
}
