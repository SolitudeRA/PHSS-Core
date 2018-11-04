package org.protogalaxy.phss.security.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseOAuth2AuthorizedClientRepository implements OAuth2AuthorizedClientRepository {
    /**
     * Returns the {@link OAuth2AuthorizedClient} associated to the
     * provided client registration identifier and End-User {@link Authentication} (Resource Owner)
     * or {@code null} if not available.
     *
     * @param clientRegistrationId the identifier for the client's registration
     * @param principal            the End-User {@link Authentication} (Resource Owner)
     * @param request              the {@code HttpServletRequest}
     * @return the {@link OAuth2AuthorizedClient} or {@code null} if not available
     */
    @Override
    public <T extends OAuth2AuthorizedClient> T loadAuthorizedClient(String clientRegistrationId, Authentication principal, HttpServletRequest request) {
        return null;
    }

    /**
     * Saves the {@link OAuth2AuthorizedClient} associating it to
     * the provided End-User {@link Authentication} (Resource Owner).
     *
     * @param authorizedClient the authorized client
     * @param principal        the End-User {@link Authentication} (Resource Owner)
     * @param request          the {@code HttpServletRequest}
     * @param response         the {@code HttpServletResponse}
     */
    @Override
    public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal, HttpServletRequest request, HttpServletResponse response) {
        Assert.notNull(authorizedClient, "authorizedClient cannot be null");
        Assert.notNull(request, "request cannot be null");
        Assert.notNull(response, "response cannot be null");
    }

    /**
     * Removes the {@link OAuth2AuthorizedClient} associated to the
     * provided client registration identifier and End-User {@link Authentication} (Resource Owner).
     *
     * @param clientRegistrationId the identifier for the client's registration
     * @param principal            the End-User {@link Authentication} (Resource Owner)
     * @param request              the {@code HttpServletRequest}
     * @param response             the {@code HttpServletResponse}
     */
    @Override
    public void removeAuthorizedClient(String clientRegistrationId, Authentication principal, HttpServletRequest request, HttpServletResponse response) {

    }
}
