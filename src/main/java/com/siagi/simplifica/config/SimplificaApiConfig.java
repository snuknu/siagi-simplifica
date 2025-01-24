package com.siagi.simplifica.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class SimplificaApiConfig {

  private static SimplificaApiConfig instance;
  private String domain;
  private String apiPath;
  private String appId;
  private String keyHeaderName;
  private String keyHeaderValue;

  private SimplificaApiConfig(
      String domain,
      String apiPath,
      String appId,
      String keyHeaderName,
      String keyHeaderValue) {
    this.domain = domain;
    this.apiPath = apiPath;
    this.appId = appId;
    this.keyHeaderName = keyHeaderName;
    this.keyHeaderValue = keyHeaderValue;
  }

  public static SimplificaApiConfig getInstance() {
    if (instance == null) {
      instance = new SimplificaApiConfig(
          "https://api.simplificamais.com.br",
          "/api/data-integration/v1/app",
          "sansuy",
          "x-api-key",
          "dImOZg1RLU6xkJ2RUjvY26WI2xLMMyrH7ld0g5Ez");
    }
    return instance;
  }

  public String getUrl(String servicePath) {
    return this.domain + this.apiPath + "/" + this.appId + servicePath;
  }
}
