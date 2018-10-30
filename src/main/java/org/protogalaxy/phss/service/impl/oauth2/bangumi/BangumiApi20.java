package org.protogalaxy.phss.service.impl.oauth2.bangumi;

import com.github.scribejava.apis.openid.OpenIdJsonTokenExtractor;
import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;

public class BangumiApi20 extends DefaultApi20 {
    private BangumiApi20() {
    }

    public static BangumiApi20 instance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * Returns the URL that receives the access token requests.
     *
     * @return access token URL
     */
    @Override
    public String getAccessTokenEndpoint() {
        return "https://bgm.tv/oauth/access_token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://bgm.tv/oauth/authorize";
    }

    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return OpenIdJsonTokenExtractor.instance();
    }

    private static class InstanceHolder {
        private static final BangumiApi20 INSTANCE = new BangumiApi20();

        private InstanceHolder() {
        }
    }
}
