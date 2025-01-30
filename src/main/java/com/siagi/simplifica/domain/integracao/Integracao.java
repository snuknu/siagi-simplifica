package com.siagi.simplifica.domain.integracao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.siagi.simplifica.domain.conta.pendente.ContaPendente;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"})
@Entity
@Table(name = "fin_simplifica_integracao", catalog = "dbSIAGI_Sansuy", schema = "dbo")
@IdClass(ContaId.class)
public class Integracao {

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
  private String cnpjEmpresaEmitente;

  @Id
  private String numeroDocumento;

  @Id
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

  public Integracao(IntegracaoDto dto) {

    this.cnpjEmpresaEmitente = dto.getCnpjEmpresaEmitente();
    this.numeroDocumento = dto.getNumeroDocumento();
    this.parcela = dto.getParcela();

    this.codigoEmpresaEmitente = dto.getCodigoEmpresaEmitente();
    this.enderecoEmpresaEmitente = dto.getEnderecoEmpresaEmitente();
    this.razaoSocialEmpresaEmitente = dto.getRazaoSocialEmpresaEmitente();
    this.cnpjCliente = dto.getCnpjCliente();
    this.codigoCliente = dto.getCodigoCliente();
    this.razaoSocialCliente = dto.getRazaoSocialCliente();
    this.codigoDocumento = dto.getCodigoDocumento();
    this.dataEmissao = dto.getDataEmissao();
    this.dataVencimento = dto.getDataVencimento();
    this.agencia = dto.getAgencia();
    this.agenciaDv = dto.getAgenciaDv();
    this.conta = dto.getConta();
    this.contaDv = dto.getContaDv();
    this.codigoBeneficiario = dto.getCodigoBeneficiario();
    this.carteira = dto.getCarteira();
    this.numeroBancario = dto.getNumeroBancario();
    this.numeroBancarioDv = dto.getNumeroBancarioDv();
    this.codigoBacen = dto.getCodigoBacen();
    this.descricaoBacen = dto.getDescricaoBacen();
    this.valor = dto.getValor();
    this.valorMulta = dto.getValorMulta();
    this.valorJuros = dto.getValorJuros();
    this.percentualMulta = dto.getPercentualMulta();
    this.percentualJuros = dto.getPercentualJuros();
    this.chaveNf = dto.getChaveNf();
    this.numeroNf = dto.getNumeroNf();

    this.status = dto.getStatus();
    this.dataEnvio = dto.getDataEnvio();
    this.jsonRetornoEnvio = dto.getJsonRetornoEnvio();
    this.dataBaixa = dto.getDataBaixa();
    this.jsonRetornoBaixa = dto.getJsonRetornoBaixa();
  }


  public Integracao(ContaPendente dto) {
    
    this.cnpjEmpresaEmitente = dto.getCnpjEmpresaEmitente();
    this.numeroDocumento = dto.getNumeroDocumento();
    this.parcela = dto.getParcela();

    this.codigoEmpresaEmitente = dto.getCodigoEmpresaEmitente();
    this.enderecoEmpresaEmitente = dto.getEnderecoEmpresaEmitente();
    this.razaoSocialEmpresaEmitente = dto.getRazaoSocialEmpresaEmitente();
    this.cnpjCliente = dto.getCnpjCliente();
    this.codigoCliente = dto.getCodigoCliente();
    this.razaoSocialCliente = dto.getRazaoSocialCliente();
    this.codigoDocumento = dto.getCodigoDocumento();
    this.dataEmissao = dto.getDataEmissao();
    this.dataVencimento = dto.getDataVencimento();
    this.agencia = dto.getAgencia();
    this.agenciaDv = dto.getAgenciaDv();
    this.conta = dto.getConta();
    this.contaDv = dto.getContaDv();
    this.codigoBeneficiario = dto.getCodigoBeneficiario();
    this.carteira = dto.getCarteira();
    this.numeroBancario = dto.getNumeroBancario();
    this.numeroBancarioDv = dto.getNumeroBancarioDv();
    this.codigoBacen = dto.getCodigoBacen();
    this.descricaoBacen = dto.getDescricaoBacen();
    this.valor = dto.getValor();
    this.valorMulta = dto.getValorMulta();
    this.valorJuros = dto.getValorJuros();
    this.percentualMulta = dto.getPercentualMulta();
    this.percentualJuros = dto.getPercentualJuros();
    this.chaveNf = dto.getChaveNf();
    this.numeroNf = dto.getNumeroNf();

  }

  public static List<Integracao> listaIntegracaoDtoParaListaIntegracao(List<IntegracaoDto> list) {
    return list.stream().map(Integracao::new).collect(Collectors.toList());
  }

  public static List<Integracao> listaContaPendenteParaListaIntegracao(List<ContaPendente> list) {
    return list.stream().map(Integracao::new).collect(Collectors.toList());
  }
}
