package com.siagi.simplifica.config;

public enum Ambiente {

  PRODUCAO("Produção", ""),
  TESTE("Teste", "_teste");

  private String descricao;
  private String sufixoBanco;

  private Ambiente(String descricao, String sufixoBanco) {
    this.descricao = descricao;
    this.sufixoBanco = sufixoBanco;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public String getSufixoBanco() {
    return this.sufixoBanco;
  }

}
