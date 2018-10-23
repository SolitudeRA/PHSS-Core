package org.protogalaxy.phss.controller.thirdparty.bangumi;

import org.protogalaxy.phss.service.impl.oauth2.bangumi.BangumiApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BangumiController {
    private BangumiApi bangumiApi;

    public BangumiController(BangumiApi bangumiApi) {
        this.bangumiApi = bangumiApi;
    }

    @RequestMapping("/bangumi")
    public String bangumi() {
        return bangumiApi.getSubject("90815").toJSONString();
    }
}
