package com.siagi.simplifica.domain.simplifica;

import lombok.Data;

@Data
public class SimplificaPagination {
  private Integer currentPage;
  private Integer pageSize;
  private Long totalRecords;
}
