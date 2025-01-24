package com.siagi.simplifica.domain.simplifica;

import java.util.List;
import lombok.Data;

@Data
public class SimplificaDados<T> {

  private List<T> rows;
  private SimplificaPagination pagination;

}
