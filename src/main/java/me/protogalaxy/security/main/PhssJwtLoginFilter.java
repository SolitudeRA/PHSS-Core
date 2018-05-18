package me.protogalaxy.security.main;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.protogalaxy.security.resources.PhssLoginObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PhssJwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public PhssJwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Authentication main filter
     *
     * @param request  Client request
     * @param response Server response
     * @return Authentication status
     * @throws AuthenticationException Authentication status
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            PhssLoginObject loginObject = new ObjectMapper().readValue(request.getInputStream(), PhssLoginObject.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginObject.getUsername(), loginObject.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Distribute token when login succeeded
     *
     * @param request    Client request
     * @param response   Server response
     * @param chain      Filter chain
     * @param authResult Authentication result
     * @throws IOException      Exception for jwt
     * @throws ServletException Servlet exception
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("phss")
                .withClaim("principal", authResult.getName())
                .withClaim("authorities", authResult.getAuthorities().toString())
                .sign(algorithm);
        response.addHeader("Authorization", token);
    }
}
