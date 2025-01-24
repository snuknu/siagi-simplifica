package com.siagi.simplifica.domain.titulo.baixado;
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
@Table(name = "view_boletos_baixados", catalog = "dbSIAGI_Sansuy", schema = "dbo")
@IdClass(TituloId.class)
public class TituloBaixado {

  @Id
  @Column(name = "cnpj_empresa_emitente")
  private String cnpjEmpresaEmitente;

  @Id
  @Column(name = "numero_documento")
  private String numeroDocumento;

  @Id
  @Column(name = "parcela")
  private String parcela;

}
