package org.protogalaxy.phss.security.oauth2;

import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PhssCookieOAuth2AuthorizationRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

    /**
     * Returns the {@link OAuth2AuthorizationRequest} associated to the provided {@code HttpServletRequest}
     * or {@code null} if not available.
     *
     * @param request the {@code HttpServletRequest}
     * @return the {@link OAuth2AuthorizationRequest} or {@code null} if not available
     */
    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        Assert.notNull(request, "Request cannot be null");
        return null;
    }

    /**
     * Persists the {@link OAuth2AuthorizationRequest} associating it to
     * the provided {@code HttpServletRequest} and/or {@code HttpServletResponse}.
     *
     * @param authorizationRequest the {@link OAuth2AuthorizationRequest}
     * @param request              the {@code HttpServletRequest}
     * @param response             the {@code HttpServletResponse}
     */
    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest request, HttpServletResponse response) {
        Assert.notNull(request, "Request cannot be null");
        Assert.notNull(response, "Response cannot be null");
        if (authorizationRequest == null) {
            this.removeAuthorizationRequest(request);
        }
    }

    /**
     * Removes and returns the {@link OAuth2AuthorizationRequest} associated to the
     * provided {@code HttpServletRequest} or if not available returns {@code null}.
     *
     * @param request the {@code HttpServletRequest}
     * @return the removed {@link OAuth2AuthorizationRequest} or {@code null} if not available
     */
    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request) {
        return null;
    }
}