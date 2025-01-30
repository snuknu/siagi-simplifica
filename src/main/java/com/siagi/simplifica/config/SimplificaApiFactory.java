package com.siagi.simplifica.config;

import java.util.Collections;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@PropertySource("classpath:application.properties")
public class SimplificaApiFactory implements FactoryBean<RestTemplate>, InitializingBean {

  @Autowired
  private Environment env;

  @Autowired
  private ObjectMapper mapper;

  private RestTemplate restTemplate;
  private SimplificaApiConfig api;
  private HttpHeaders headers;

  public RestTemplate getObject() {
    return restTemplate;
  }

  public Class<RestTemplate> getObjectType() {
    return RestTemplate.class;
  }

  public boolean isSingleton() {
    return true;
  }

  public void afterPropertiesSet() {

    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(
        new AuthScope(
            env.getProperty("aplicacao.proxy.ip"),
            Integer.valueOf(env.getProperty("aplicacao.proxy.porta"))),
        new UsernamePasswordCredentials(
            env.getProperty("aplicacao.proxy.username"),
            env.getProperty("aplicacao.proxy.password")));

    HttpClientBuilder clientBuilder = HttpClientBuilder.create();
    clientBuilder.useSystemProperties();
    clientBuilder.setProxy(new HttpHost("10.1.10.5", 3128));
    clientBuilder.setDefaultCredentialsProvider(credsProvider);
    clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());
    CloseableHttpClient client = clientBuilder.build();

    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setHttpClient(client);

    restTemplate = new RestTemplate();
    restTemplate.setRequestFactory(factory);

    api = SimplificaApiConfig.getInstance();

    headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set(api.getKeyHeaderName(), api.getKeyHeaderValue());
  }

  public <T> ResponseEntity<T> get(String servicePath, Class<T> clazz) {

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);

    return restTemplate.exchange(
        api.getUrl(servicePath),
        HttpMethod.GET,
        request,
        clazz);
  }


  public <T> ResponseEntity<T> get(String servicePath, TypeReference<T> typeReference) {

    T obj = null;
    ResponseEntity<String> response = get(servicePath, String.class);

    try {
      JsonNode root = mapper.readTree(response.getBody());
      obj = mapper.readValue(root.toString(), typeReference);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return ResponseEntity.ok(obj);
  }
  
  public <T> ResponseEntity<T> post(String servicePath, TypeReference<T> typeReference) {

    T obj = null;
    ResponseEntity<String> response = get(servicePath, String.class);

    try {
      JsonNode root = mapper.readTree(response.getBody());
      obj = mapper.readValue(root.toString(), typeReference);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return ResponseEntity.ok(obj);
  }
}


