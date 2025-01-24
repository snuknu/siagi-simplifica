package com.siagi.simplifica.domain.titulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.siagi.simplifica.domain.titulo.pendente.TituloPendente;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"cnpjEmpresaEmitente", "numeroDocumento", "parcela"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fin_simplifica_titulo", catalog = "dbSIAGI_Sansuy", schema = "dbo")
@IdClass(TituloId.class)
public class TituloHistorico {

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


  public TituloHistorico(TituloPendente entity) {
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
    this.status = TituloHistorico.Status.ENVIADO;
    this.dataEnvio = LocalDateTime.now();
  }
}
