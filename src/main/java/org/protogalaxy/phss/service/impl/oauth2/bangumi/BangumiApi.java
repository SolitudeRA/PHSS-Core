package org.protogalaxy.phss.service.impl.oauth2.bangumi;

import org.json.simple.JSONObject;
import org.protogalaxy.phss.service.main.oauth2.ApiBinding;


public class BangumiApi extends ApiBinding {
    private static final String BANGUMI_API_BASE_URL = "https://bgm.tv";

    public BangumiApi(String accessToken) {
        super(accessToken);
    }

    public JSONObject getSubject(String subjectId) {
        return restTemplate.getForObject(
                BANGUMI_API_BASE_URL + "/subject/" + subjectId, JSONObject.class);
    }
}
