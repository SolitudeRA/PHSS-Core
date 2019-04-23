package org.protogalaxy.phss.controller.thirdparty.bangumi;

import org.protogalaxy.phss.manager.bangumi.BangumiApi;
import org.protogalaxy.phss.manager.bangumi.BangumiConsts;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BangumiController {
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    public BangumiController(OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping("/bangumi")
    @ResponseBody
    public String bangumi() {
        BangumiApi bangumiApi = new BangumiApi(oAuth2AuthorizedClientService.loadAuthorizedClient("bangumi", "alpha").getAccessToken().getTokenValue());
        return bangumiApi.getSubject(90815, BangumiConsts.RESPONSE_GROUP_LARGE).toJSONString();
    }
}
