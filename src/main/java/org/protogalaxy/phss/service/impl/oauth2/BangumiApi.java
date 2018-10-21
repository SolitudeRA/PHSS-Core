package org.protogalaxy.phss.service.impl.oauth2;

import org.protogalaxy.phss.service.main.oauth2.ApiBinding;

public class BangumiApi extends ApiBinding {
    private static final String BANGUMI_API_BASE_URL = "https://bgm.tv";

    public BangumiApi(String accessToken) {
        super(accessToken);
    }
}
