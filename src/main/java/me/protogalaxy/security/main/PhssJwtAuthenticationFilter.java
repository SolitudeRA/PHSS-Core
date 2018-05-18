package me.protogalaxy.security.main;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import me.protogalaxy.security.config.PhssGrantedAuthority;
import me.protogalaxy.security.resources.PhssLoginObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PhssJwtAuthenticationFilter extends BasicAuthenticationFilter {

    public PhssJwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null) {
            chain.doFilter(request, response);
        }
        try {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null) {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("phss")
                    .acceptLeeway(15)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return new UsernamePasswordAuthenticationToken(new PhssLoginObject(jwt.getClaim("principal").asString()), null, parseAuthorities(jwt.getClaim("authorities").asString()));
        }
        return null;
    }

    private Set<PhssGrantedAuthority> parseAuthorities(String authorities) {
        String[] authoritiesString = authorities.replace("[", "")
                .replace("]", "")
                .split(",");
        Set<PhssGrantedAuthority> authoritiesSet = new HashSet<>();
        for (String anAuthoritiesString : authoritiesString) {
            authoritiesSet.add(new PhssGrantedAuthority(("ROLE_" + anAuthoritiesString)));
        }
        return authoritiesSet;
    }
}