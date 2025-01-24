package com.siagi.simplifica.domain.titulo.pendente;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.siagi.simplifica.domain.titulo.TituloId;
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
@Table(name = "view_boletos_pendentes", catalog = "dbSIAGI_Sansuy", schema = "dbo")
@IdClass(TituloId.class)
public class TituloPendente {

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

}
