package org.protogalaxy.phss.security.oauth2;


import org.protogalaxy.phss.datasource.entity.security.OAuth2AuthorizedClientEntity;
import org.protogalaxy.phss.datasource.repository.jpa.security.PhssOAuth2AuthorizedClientRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.util.Assert;

public class DatabaseOAuth2AuthorizedClientService implements OAuth2AuthorizedClientService {
    private ClientRegistrationRepository clientRegistrationRepository;
    private PhssOAuth2AuthorizedClientRepository authorizedClientRepository;

    public DatabaseOAuth2AuthorizedClientService(ClientRegistrationRepository clientRegistrationRepository,
                                                 PhssOAuth2AuthorizedClientRepository authorizedClientRepository) {
        Assert.notNull(clientRegistrationRepository, "clientRegistrationRepository cannot be null");
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.authorizedClientRepository = authorizedClientRepository;
    }

    /**
     * Returns the {@link OAuth2AuthorizedClient} associated to the
     * provided client registration identifier and End-User's {@code Principal} name
     * or {@code null} if not available.
     *
     * @param clientRegistrationId the identifier for the client's registration
     * @param principalName        the name of the End-User {@code Principal} (Resource Owner)
     * @return the {@link OAuth2AuthorizedClient} or {@code null} if not available
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends OAuth2AuthorizedClient> T loadAuthorizedClient(String clientRegistrationId, String principalName) {
        Assert.hasText(clientRegistrationId, "clientRegistrationId cannot be empty");
        Assert.hasText(principalName, "principalName cannot be empty");
        return (T) authorizedClientRepository.findByClientRegistrationId(clientRegistrationId).getAuthorizedClient(this.clientRegistrationRepository);
    }

    /**
     * Saves the {@link OAuth2AuthorizedClient} associating it to
     * the provided End-User {@link Authentication} (Resource Owner).
     *
     * @param authorizedClient the authorized client
     * @param principal        the End-User {@link Authentication} (Resource Owner)
     */
    @Override
    public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal) {
        Assert.notNull(authorizedClient, "authorizedClient cannot be null");
        Assert.notNull(principal, "principal cannot be null");
        authorizedClientRepository.save(new OAuth2AuthorizedClientEntity(authorizedClient.getClientRegistration(),
                                                                             principal.getName(),
                                                                             authorizedClient.getAccessToken(),
                                                                             authorizedClient.getRefreshToken()));
    }

    /**
     * Removes the {@link OAuth2AuthorizedClient} associated to the
     * provided client registration identifier and End-User's {@code Principal} name.
     *
     * @param clientRegistrationId the identifier for the client's registration
     * @param principalName        the name of the End-User {@code Principal} (Resource Owner)
     */
    @Override
    public void removeAuthorizedClient(String clientRegistrationId, String principalName) {
        Assert.hasText(clientRegistrationId, "clientRegistrationId cannot be empty");
        Assert.hasText(principalName, "principalName cannot be empty");
        authorizedClientRepository.deleteByClientRegistrationId(clientRegistrationId);
    }
}
