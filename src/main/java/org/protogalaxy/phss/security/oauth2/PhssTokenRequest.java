package org.protogalaxy.phss.security.oauth2;

import com.nimbusds.oauth2.sdk.*;
import com.nimbusds.oauth2.sdk.auth.ClientAuthentication;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.http.CommonContentTypes;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.oauth2.sdk.util.MapUtils;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.nimbusds.oauth2.sdk.util.URLUtils;
import net.jcip.annotations.Immutable;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Immutable
public class PhssTokenRequest extends AbstractOptionallyIdentifiedRequest {


    /**
     * The authorisation grant.
     */
    private final AuthorizationGrant authzGrant;


    /**
     * The requested scope, {@code null} if not specified.
     */
    private final Scope scope;


    /**
     * Additional custom request parameters.
     */
    private final Map<String,String> customParams;


    /**
     * Creates a new token request with the specified client
     * authentication.
     *
     * @param uri        The URI of the token endpoint. May be
     *                   {@code null} if the {@link #toHTTPRequest} method
     *                   will not be used.
     * @param clientAuth The client authentication. Must not be
     *                   {@code null}.
     * @param authzGrant The authorisation grant. Must not be {@code null}.
     * @param scope      The requested scope, {@code null} if not
     *                   specified.
     */
    public PhssTokenRequest(final URI uri,
                        final ClientAuthentication clientAuth,
                        final AuthorizationGrant authzGrant,
                        final Scope scope) {

        this(uri, clientAuth, authzGrant, scope, null);
    }


    /**
     * Creates a new token request with the specified client
     * authentication and additional custom parameters.
     *
     * @param uri          The URI of the token endpoint. May be
     *                     {@code null} if the {@link #toHTTPRequest}
     *                     method will not be used.
     * @param clientAuth   The client authentication. Must not be
     *                     {@code null}.
     * @param authzGrant   The authorisation grant. Must not be
     *                     {@code null}.
     * @param scope        The requested scope, {@code null} if not
     *                     specified.
     * @param customParams Additional custom parameters to be included in
     *                     the request body, empty map or {@code null} if
     *                     none.
     */
    public PhssTokenRequest(final URI uri,
                        final ClientAuthentication clientAuth,
                        final AuthorizationGrant authzGrant,
                        final Scope scope,
                        final Map<String,String> customParams) {

        super(uri, clientAuth);

        if (clientAuth == null)
            throw new IllegalArgumentException("The client authentication must not be null");

        this.authzGrant = authzGrant;

        this.scope = scope;

        if (MapUtils.isNotEmpty(customParams)) {
            this.customParams = customParams;
        } else {
            this.customParams = Collections.emptyMap();
        }
    }


    /**
     * Creates a new token request with the specified client
     * authentication.
     *
     * @param uri        The URI of the token endpoint. May be
     *                   {@code null} if the {@link #toHTTPRequest} method
     *                   will not be used.
     * @param clientAuth The client authentication. Must not be
     *                   {@code null}.
     * @param authzGrant The authorisation grant. Must not be {@code null}.
     */
    public PhssTokenRequest(final URI uri,
                        final ClientAuthentication clientAuth,
                        final AuthorizationGrant authzGrant) {

        this(uri, clientAuth, authzGrant, null);
    }


    /**
     * Creates a new token request, with no explicit client authentication
     * (may be present in the grant depending on its type).
     *
     * @param uri        The URI of the token endpoint. May be
     *                   {@code null} if the {@link #toHTTPRequest} method
     *                   will not be used.
     * @param clientID   The client identifier, {@code null} if not
     *                   specified.
     * @param authzGrant The authorisation grant. Must not be {@code null}.
     * @param scope      The requested scope, {@code null} if not
     *                   specified.
     */
    public PhssTokenRequest(final URI uri,
                        final ClientID clientID,
                        final AuthorizationGrant authzGrant,
                        final Scope scope) {

        this(uri, clientID, authzGrant, scope, null);
    }


    /**
     * Creates a new token request, with no explicit client authentication
     * (may be present in the grant depending on its type) and additional
     * custom parameters.
     *
     * @param uri          The URI of the token endpoint. May be
     *                     {@code null} if the {@link #toHTTPRequest}
     *                     method will not be used.
     * @param clientID     The client identifier, {@code null} if not
     *                     specified.
     * @param authzGrant   The authorisation grant. Must not be
     *                     {@code null}.
     * @param scope        The requested scope, {@code null} if not
     *                     specified.
     * @param customParams Additional custom parameters to be included in
     *                     the request body, empty map or {@code null} if
     *                     none.
     */
    public PhssTokenRequest(final URI uri,
                        final ClientID clientID,
                        final AuthorizationGrant authzGrant,
                        final Scope scope,
                        final Map<String,String> customParams) {

        super(uri, clientID);

        if (authzGrant.getType().requiresClientAuthentication()) {
            throw new IllegalArgumentException("The \"" + authzGrant.getType() + "\" grant type requires client authentication");
        }

        if (authzGrant.getType().requiresClientID() && clientID == null) {
            throw new IllegalArgumentException("The \"" + authzGrant.getType() + "\" grant type requires a \"client_id\" parameter");
        }

        this.authzGrant = authzGrant;

        this.scope = scope;

        if (MapUtils.isNotEmpty(customParams)) {
            this.customParams = customParams;
        } else {
            this.customParams = Collections.emptyMap();
        }
    }


    /**
     * Creates a new token request, with no explicit client authentication
     * (may be present in the grant depending on its type).
     *
     * @param uri        The URI of the token endpoint. May be
     *                   {@code null} if the {@link #toHTTPRequest} method
     *                   will not be used.
     * @param clientID   The client identifier, {@code null} if not
     *                   specified.
     * @param authzGrant The authorisation grant. Must not be {@code null}.
     */
    public PhssTokenRequest(final URI uri,
                        final ClientID clientID,
                        final AuthorizationGrant authzGrant) {

        this(uri, clientID, authzGrant, null);
    }


    /**
     * Creates a new token request, without client authentication and a
     * specified client identifier.
     *
     * @param uri        The URI of the token endpoint. May be
     *                   {@code null} if the {@link #toHTTPRequest} method
     *                   will not be used.
     * @param authzGrant The authorisation grant. Must not be {@code null}.
     * @param scope      The requested scope, {@code null} if not
     *                   specified.
     */
    public PhssTokenRequest(final URI uri,
                        final AuthorizationGrant authzGrant,
                        final Scope scope) {

        this(uri, (ClientID)null, authzGrant, scope);
    }


    /**
     * Creates a new token request, without client authentication and a
     * specified client identifier.
     *
     * @param uri        The URI of the token endpoint. May be
     *                   {@code null} if the {@link #toHTTPRequest} method
     *                   will not be used.
     * @param authzGrant The authorisation grant. Must not be {@code null}.
     */
    public PhssTokenRequest(final URI uri,
                        final AuthorizationGrant authzGrant) {

        this(uri, (ClientID)null, authzGrant, null);
    }


    /**
     * Gets the authorisation grant.
     *
     * @return The authorisation grant.
     */
    public AuthorizationGrant getAuthorizationGrant() {

        return authzGrant;
    }


    /**
     * Gets the requested scope.
     *
     * @return The requested scope, {@code null} if not specified.
     */
    public Scope getScope() {

        return scope;
    }


    /**
     * Returns the additional custom parameters included in the request
     * body.
     *
     * <p>Example:
     *
     * <pre>
     * resource=http://xxxxxx/PartyOData
     * </pre>
     *
     * @return The additional custom parameters as a unmodifiable map,
     *         empty map if none.
     */
    public Map<String,String> getCustomParameters () {

        return customParams;
    }


    /**
     * Returns the specified custom parameter included in the request body.
     *
     * @param name The parameter name. Must not be {@code null}.
     *
     * @return The parameter value, {@code null} if not specified.
     */
    public String getCustomParameter(final String name) {

        return customParams.get(name);
    }


    @Override
    public HTTPRequest toHTTPRequest() {

        if (getEndpointURI() == null)
            throw new SerializeException("The endpoint URI is not specified");

        URL url;

        try {
            url = getEndpointURI().toURL();

        } catch (MalformedURLException e) {

            throw new SerializeException(e.getMessage(), e);
        }

        HTTPRequest httpRequest = new HTTPRequest(HTTPRequest.Method.POST, url);
        httpRequest.setContentType(CommonContentTypes.APPLICATION_URLENCODED);

        if (getClientAuthentication() != null) {
            getClientAuthentication().applyTo(httpRequest);
        }

        Map<String,String> params = httpRequest.getQueryParameters();

        params.putAll(authzGrant.toParameters());

        if (scope != null && ! scope.isEmpty()) {
            params.put("scope", scope.toString());
        }

        if (getClientID() != null) {
            params.put("client_id", getClientID().getValue());
        }

        if (! getCustomParameters().isEmpty()) {
            params.putAll(getCustomParameters());
        }

        httpRequest.setQuery(URLUtils.serializeParameters(params));

        return httpRequest;
    }


    /**
     * Parses a token request from the specified HTTP request.
     *
     * @param httpRequest The HTTP request. Must not be {@code null}.
     *
     * @return The token request.
     *
     * @throws ParseException If the HTTP request couldn't be parsed to a
     *                        token request.
     */
    public static PhssTokenRequest parse(final HTTPRequest httpRequest)
            throws ParseException {

        // Only HTTP POST accepted
        URI uri;

        try {
            uri = httpRequest.getURL().toURI();

        } catch (URISyntaxException e) {

            throw new ParseException(e.getMessage(), e);
        }

        httpRequest.ensureMethod(HTTPRequest.Method.POST);
        httpRequest.ensureContentType(CommonContentTypes.APPLICATION_URLENCODED);

        // Parse client authentication, if any
        ClientAuthentication clientAuth;

        try {
            clientAuth = ClientAuthentication.parse(httpRequest);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), OAuth2Error.INVALID_REQUEST.appendDescription(": " + e.getMessage()));
        }

        // No fragment! May use query component!
        Map<String,String> params = httpRequest.getQueryParameters();

        // Multiple conflicting client auth methods (issue #203)?
        if (clientAuth instanceof ClientSecretBasic) {
            if (StringUtils.isNotBlank(params.get("client_assertion")) || StringUtils.isNotBlank(params.get("client_assertion_type"))) {
                String msg = "Multiple conflicting client authentication methods found: Basic and JWT assertion";
                throw new ParseException(msg, OAuth2Error.INVALID_REQUEST.appendDescription(": " + msg));
            }
        }

        // Parse grant
        AuthorizationGrant grant = AuthorizationGrant.parse(params);

        if (clientAuth == null && grant.getType().requiresClientAuthentication()) {
            String msg = "Missing client authentication";
            throw new ParseException(msg, OAuth2Error.INVALID_CLIENT.appendDescription(": " + msg));
        }

        // Parse client id
        ClientID clientID = null;

        if (clientAuth == null) {

            // Parse optional client ID
            String clientIDString = params.get("client_id");

            if (clientIDString != null && ! clientIDString.trim().isEmpty())
                clientID = new ClientID(clientIDString);

            if (clientID == null && grant.getType().requiresClientID()) {
                String msg = "Missing required \"client_id\" parameter";
                throw new ParseException(msg, OAuth2Error.INVALID_REQUEST.appendDescription(": " + msg));
            }
        }

        // Parse optional scope
        String scopeValue = params.get("scope");

        Scope scope = null;

        if (scopeValue != null) {
            scope = Scope.parse(scopeValue);
        }

        // Parse custom parameters
        Map<String,String> customParams = new HashMap<>();

        for (Map.Entry<String,String> p: params.entrySet()) {

            if (p.getKey().equalsIgnoreCase("grant_type")) {
                continue; // skip
            }

            if (p.getKey().equalsIgnoreCase("client_id")) {
                continue; // skip
            }

            if (p.getKey().equalsIgnoreCase("client_secret")) {
                continue; // skip
            }

            if (p.getKey().equalsIgnoreCase("client_assertion_type")) {
                continue; // skip
            }

            if (p.getKey().equalsIgnoreCase("client_assertion")) {
                continue; // skip
            }

            if (p.getKey().equalsIgnoreCase("scope")) {
                continue; // skip
            }

            if (! grant.getType().getRequestParameterNames().contains(p.getKey())) {
                // We have a custom (non-registered) parameter
                customParams.put(p.getKey(), p.getValue());
            }
        }

        if (clientAuth != null) {
            return new PhssTokenRequest(uri, clientAuth, grant, scope, customParams);
        } else {
            return new PhssTokenRequest(uri, clientID, grant, scope, customParams);
        }
    }
}

