package com.siagi.simplifica.config;

import java.util.Locale;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class DynamicCustomNamingStrategy implements PhysicalNamingStrategy {

  @Autowired
  private Environment env;

  @Override
  public Identifier toPhysicalCatalogName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    if (logicalName != null) {
      String testeProperty = env.getProperty("aplicacao.teste");
      Integer teste = (testeProperty != null) && !testeProperty.trim().isEmpty() ? Integer.parseInt(testeProperty) : 0;

      if (teste.equals(Ambiente.TESTE.ordinal()))
        logicalName = getIdentifier(logicalName.getText().concat(Ambiente.TESTE.getSufixoBanco()),
            logicalName.isQuoted(), jdbcEnvironment);
      else
        logicalName = apply(logicalName, jdbcEnvironment);
    }
    return logicalName;
  }

  @Override
  public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  @Override
  public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  @Override
  public Identifier toPhysicalSequenceName(Identifier logicalName,
      JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  @Override
  public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
    return apply(logicalName, jdbcEnvironment);
  }

  private Identifier apply(final Identifier name, final JdbcEnvironment jdbcEnvironment) {

    if (name == null) {
      return null;
    }
    StringBuilder builder = new StringBuilder(name.getText().replace('.', '_'));
    for (int i = 1; i < builder.length() - 1; i++) {
      if (isUnderscoreRequired(builder.charAt(i - 1), builder.charAt(i), builder.charAt(i + 1))) {
        builder.insert(i++, '_');
      }
    }
    return getIdentifier(builder.toString(), name.isQuoted(), jdbcEnvironment);
  }

  protected Identifier getIdentifier(String name, final boolean quoted,
      final JdbcEnvironment jdbcEnvironment) {
    if (isCaseInsensitive(jdbcEnvironment)) {
      name = name.toLowerCase(Locale.ROOT);
    }
    return new Identifier(name, quoted);
  }

  protected boolean isCaseInsensitive(JdbcEnvironment jdbcEnvironment) {
    return true;
  }

  private boolean isUnderscoreRequired(final char before, final char current, final char after) {
    return Character.isLowerCase(before) && Character.isUpperCase(current)
        && Character.isLowerCase(after);
  }

}
