package org.protogalaxy.phss.service.main.oauth2;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

public abstract class ApiBinding {
    protected RestTemplate restTemplate;

    public ApiBinding(String accessToken) {
        this.restTemplate = new RestTemplate();
        if (accessToken != null) {
            this.restTemplate.getInterceptors()
                             .add(getBearerTokenInterceptor(accessToken));
        } else {
            this.restTemplate.getInterceptors()
                             .add(getNoTokenInterceptor());
        }
    }

    private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
        return (httpRequest, bytes, clientHttpRequestExecution) -> {
            httpRequest.getHeaders().setBearerAuth(accessToken);
            httpRequest.getHeaders().add("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        };
    }

    private ClientHttpRequestInterceptor getNoTokenInterceptor() {
        return (httpRequest, bytes, clientHttpRequestExecution) -> {
            throw new IllegalStateException("Can't access the API without an access token");
        };
    }
}
