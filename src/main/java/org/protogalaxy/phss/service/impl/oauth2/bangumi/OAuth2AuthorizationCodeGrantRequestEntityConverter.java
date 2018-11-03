package org.protogalaxy.phss.service.impl.oauth2.bangumi;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationExchange;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

public class OAuth2AuthorizationCodeGrantRequestEntityConverter implements Converter<OAuth2AuthorizationCodeGrantRequest, RequestEntity<?>> {

    /**
     * Returns the {@link RequestEntity} used for the Access Token Request.
     *
     * @param oAuth2AuthorizationCodeGrantRequest the authorization code grant request
     * @return the {@link RequestEntity} used for the Access Token Request
     */
    @Override
    public RequestEntity<?> convert(OAuth2AuthorizationCodeGrantRequest oAuth2AuthorizationCodeGrantRequest) {
        ClientRegistration clientRegistration = oAuth2AuthorizationCodeGrantRequest.getClientRegistration();
        HttpHeaders headers = httpHeaderConverter(clientRegistration);
        MultiValueMap<String, String> formParameters = this.buildFormParameters(oAuth2AuthorizationCodeGrantRequest);
        URI uri = UriComponentsBuilder.fromUriString(clientRegistration.getProviderDetails().getTokenUri())
                                      .build()
                                      .toUri();

        return new RequestEntity<>(formParameters, headers, HttpMethod.POST, uri);
    }

    private HttpHeaders httpHeaderConverter(ClientRegistration clientRegistration) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        return headers;
    }

    /**
     * Returns a {@link MultiValueMap} of the form parameters used for the Access Token Request body.
     *
     * @param authorizationCodeGrantRequest the authorization code grant request
     * @return a {@link MultiValueMap} of the form parameters used for the Access Token Request body
     */
    private MultiValueMap<String, String> buildFormParameters(OAuth2AuthorizationCodeGrantRequest authorizationCodeGrantRequest) {
        ClientRegistration clientRegistration = authorizationCodeGrantRequest.getClientRegistration();
        OAuth2AuthorizationExchange authorizationExchange = authorizationCodeGrantRequest.getAuthorizationExchange();

        MultiValueMap<String, String> formParameters = new LinkedMultiValueMap<>();
        formParameters.add(OAuth2ParameterNames.GRANT_TYPE, authorizationCodeGrantRequest.getGrantType().getValue());
        formParameters.add(OAuth2ParameterNames.CODE, authorizationExchange.getAuthorizationResponse().getCode());
        formParameters.add(OAuth2ParameterNames.REDIRECT_URI, authorizationExchange.getAuthorizationRequest().getRedirectUri());
        if (ClientAuthenticationMethod.POST.equals(clientRegistration.getClientAuthenticationMethod())) {
            formParameters.add(OAuth2ParameterNames.CLIENT_ID, clientRegistration.getClientId());
            formParameters.add(OAuth2ParameterNames.CLIENT_SECRET, clientRegistration.getClientSecret());
        }

        return formParameters;
    }
}
