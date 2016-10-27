package common;

import com.alibaba.fastjson.JSON;
import com.google.common.io.ByteStreams;
import common.Host;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.io.*;

/**
 * 对基础服务进行访问，按照约定
 *
 * Created by jiahao.zhang on 2016/10/27.
 */
public class HttpAccessProvider {
    private RestTemplate restTemplate;
    private Host host;

    public HttpAccessProvider(String host) {
        this.restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.host = new Host(host);
    }

    public <T> T post(String url, String accessToken, Object data, Class<T> clazz) {
        String postUrl = String.format("%s%s", host.getHost(), url);
        String result = restTemplate.postForObject(postUrl, getRequestEntity(accessToken, data), String.class);
        return JSON.parseObject(result, clazz);
    }

    public <T> T exchange(String url, String accessToken, Object data, Class<T> clazz, HttpMethod method) {
        String postUrl = String.format("%s%s", host.getHost(), url);
        ResponseEntity<String> result = restTemplate.exchange(postUrl, method, getRequestEntity(accessToken, data), String.class);
        return JSON.parseObject(result.getBody(), clazz);
    }

    public <T> T upload(String accessToken, InputStream inputStream, String url, Class<T> clazz) {
        String postUrl = String.format("%s%s", host.getHost(), url);
        final RequestCallback requestCallback = request -> {
            request.getHeaders().add("Content-type", "application/octet-stream");
            request.getHeaders().add("accesstoken", accessToken);
            request.getHeaders().add("Accept-Charset", "utf-8");
            ByteStreams.copy(inputStream, request.getBody());
        };
        final RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setBufferRequestBody(false);
        restTemplate.setRequestFactory(requestFactory);
        final HttpMessageConverterExtractor<String> responseExtractor =
                new HttpMessageConverterExtractor<>(String.class, restTemplate.getMessageConverters());

        String result = restTemplate.execute(postUrl, HttpMethod.POST, requestCallback, responseExtractor);
        return JSON.parseObject(result, clazz);
    }

    public String get(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    private HttpEntity<Object> getRequestEntity(String accessToken, Object data) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);

        headers.set("accesstoken", accessToken);
        headers.set("Accept-Charset", "utf-8");
        return new HttpEntity<>(data, headers);
    }

    //region getter and setter

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    //endregion
}
