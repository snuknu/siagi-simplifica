package com.siagi.simplifica.domain.titulo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class TituloHistoricoDto {

  // IDENTIFICADOR
  private String cnpjEmpresaEmitente;
  private String numeroDocumento;
  private String parcela;

  // DETALHAMENTOF
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

  // HISTORICO
  private TituloHistorico.Status status;
  private LocalDateTime dataEnvio;
  private String jsonRetornoEnvio;
  private LocalDateTime dataBaixa;
  private String jsonRetornoBaixa;

}
