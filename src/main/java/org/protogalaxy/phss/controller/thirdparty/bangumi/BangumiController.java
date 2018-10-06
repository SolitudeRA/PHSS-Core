package org.protogalaxy.phss.controller.thirdparty.bangumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BangumiController {
    private OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    public BangumiController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @RequestMapping("/bangumi")
    public String bangumi(OAuth2AuthenticationToken authenticationToken) {
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(authenticationToken.getAuthorizedClientRegistrationId(), authenticationToken.getName());
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();

        return accessToken.getTokenValue();
    }
}
