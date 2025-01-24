package com.siagi.simplifica.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.siagi.simplifica.util.converter.StringTrimConverter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "codigoCliente")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "view_dados_clientes", catalog = "dbSIAGI_Sansuy", schema = "dbo")
public class Cliente {

  @Id
  @Column(name = "codigo_cliente")
  private Long codigoCliente;

  @Column(name = "cnpj_cliente")
  private String cnpjCliente;

  @Convert(converter = StringTrimConverter.class)
  @Column(name = "razao_social")
  private String razaoSocial;

  @Column(name = "email")
  private String email;

  @Column(name = "cidade")
  private String cidade;

  @Column(name = "estado")
  private String estado;

  @Column(name = "telefone")
  private String telefone;

  @Column(name = "telefone2")
  private String telefone2;

  @Column(name = "telefone3")
  private String telefone3;

}


