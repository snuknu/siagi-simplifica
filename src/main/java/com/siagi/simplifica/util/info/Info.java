package com.siagi.simplifica.util.info;
import lombok.Getter;

@Getter
public class Info {

  private static Info instance;
  private String projectName;
  private String description;
  private String version;

  private Info(
      String projectName,
      String description,
      String version) {
    this.projectName = projectName;
    this.description = description;
    this.version = version;
  }

  public static Info getInstance() {
    if (instance == null) {
      instance = new Info(
          "SIAGI: API Simplifica",
          "API para inclusão, manutenção e exclusão dos dados apresentados na Plataforma Simplifica",
          "0.0.1-SNAPSHOT");
    }
    return instance;
  }

}

