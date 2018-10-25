package org.protogalaxy.phss.security.config;

import org.protogalaxy.phss.security.main.AjaxAuthFailHandler;
import org.protogalaxy.phss.security.main.AjaxAuthSuccessHandler;
import org.protogalaxy.phss.security.oauth2.PhssAuthorizationCodeTokenResponseClient;
import org.protogalaxy.phss.security.oauth2.PhssCookieOAuth2AuthorizationRequestRepository;
import org.protogalaxy.phss.security.user.PhssUserDetailsService;
import org.protogalaxy.phss.service.config.PhssOAuth2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.server.AuthenticatedPrincipalServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class PhssMainSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AjaxAuthSuccessHandler ajaxAuthSuccessHandler;
    private final AjaxAuthFailHandler ajaxAuthFailHandler;
    private final PhssOAuth2Config oAuth2Config;

    @Autowired
    public PhssMainSecurityConfig(AjaxAuthSuccessHandler ajaxAuthSuccessHandler,
                                  AjaxAuthFailHandler ajaxAuthFailHandler,
                                  PhssOAuth2Config oAuth2Config) {
        this.ajaxAuthSuccessHandler = ajaxAuthSuccessHandler;
        this.ajaxAuthFailHandler = ajaxAuthFailHandler;
        this.oAuth2Config = oAuth2Config;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and()
            //--------------------------Url filter config---------------------------//
            .authorizeRequests()
            .antMatchers("/", "/index", "/user/register", "/user/login", "/login/oauth2/code/*").permitAll()
            .anyRequest().authenticated()
            .and()


            //------------------------OAuth2 login config---------------------------//
            .oauth2Login()
            .clientRegistrationRepository(oAuth2Config.clientRegistrationRepository())
            .authorizedClientRepository(oAuth2Config.oAuth2AuthorizedClientRepository())
            .authorizationEndpoint()
            .baseUri("/login/oauth2/authorization")
            .authorizationRequestRepository(oAuth2Config.sessionAuthorizationRequestRepository())
            .and()
            .redirectionEndpoint()
            .baseUri("/login/oauth2/callback/*")
            .and()
            .tokenEndpoint()
            .accessTokenResponseClient(accessTokenResponseClient())
            .and().and()

            //--------------------------Login config--------------------------------//
            .formLogin()
            .loginProcessingUrl("/user/login")
            .failureHandler(ajaxAuthFailHandler)
            .successHandler(ajaxAuthSuccessHandler)
            .permitAll()
            .and()


            //--------------------------Logout config-------------------------------//
            .logout()
            .logoutUrl("/user/logout")
            .logoutSuccessUrl("/index")
            .and()


            //------------------------Remember-me config----------------------------//
            .rememberMe()
            .key("key");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected PhssUserDetailsService userDetailsService() {
        return new PhssUserDetailsService();
    }

    private OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        return new PhssAuthorizationCodeTokenResponseClient();
    }
}
