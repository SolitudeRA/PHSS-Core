package org.protogalaxy.phss.security.config;

import org.protogalaxy.phss.security.main.AjaxAuthFailHandler;
import org.protogalaxy.phss.security.main.AjaxAuthSuccessHandler;
import org.protogalaxy.phss.service.main.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MainSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    private final AjaxAuthSuccessHandler ajaxAuthSuccessHandler;
    private final AjaxAuthFailHandler ajaxAuthFailHandler;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private final OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;
    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
    private final AuthorizationRequestRepository<OAuth2AuthorizationRequest> oAuth2AuthorizationRequestRepository;
    private final OAuth2AuthorizationRequestResolver oAuth2AuthorizationRequestResolver;
    private final OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> oAuth2AccessTokenResponseClient;

    @Autowired
    public MainSecurityConfig(AjaxAuthSuccessHandler ajaxAuthSuccessHandler,
                              AjaxAuthFailHandler ajaxAuthFailHandler,
                              ClientRegistrationRepository clientRegistrationRepository,
                              OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository,
                              OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
                              AuthorizationRequestRepository<OAuth2AuthorizationRequest> oAuth2AuthorizationRequestRepository,
                              OAuth2AuthorizationRequestResolver oAuth2AuthorizationRequestResolver,
                              OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> oAuth2AccessTokenResponseClient) {
        this.ajaxAuthSuccessHandler = ajaxAuthSuccessHandler;
        this.ajaxAuthFailHandler = ajaxAuthFailHandler;
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.oAuth2AuthorizedClientRepository = oAuth2AuthorizedClientRepository;
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
        this.oAuth2AuthorizationRequestRepository = oAuth2AuthorizationRequestRepository;
        this.oAuth2AuthorizationRequestResolver = oAuth2AuthorizationRequestResolver;
        this.oAuth2AccessTokenResponseClient = oAuth2AccessTokenResponseClient;
    }

    public void configure(HttpSecurity http) throws Exception {
        http
                //-----------------------------CSRF config------------------------------//
                .csrf().disable()


                //-----------------------------CORS config------------------------------//
                .cors().and()


                //--------------------------Url filter config---------------------------//
                .authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/index").permitAll()
                .and()
                .authorizeRequests().antMatchers("/account/login").permitAll()
                .and()
                .authorizeRequests().antMatchers("/account/register").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()


                //--------------------------Login config--------------------------------//
                .formLogin()
                .loginProcessingUrl("/account/login")
                .successHandler(ajaxAuthSuccessHandler)
                .failureHandler(ajaxAuthFailHandler)
                .permitAll()
                .and()


                //--------------------------Logout config-------------------------------//
                .logout()
                .logoutUrl("/account/logout")
                .logoutSuccessUrl("/index")
                .and()


                //------------------------Remember-me config----------------------------//
                .rememberMe()
                .key("key")
                .and()


                //-----------------------Oauth2 Client config---------------------------//
                .oauth2Client()
                .authorizedClientService(oAuth2AuthorizedClientService)
                .clientRegistrationRepository(clientRegistrationRepository)
                .authorizedClientRepository(oAuth2AuthorizedClientRepository)
                .authorizationCodeGrant()
                .accessTokenResponseClient(oAuth2AccessTokenResponseClient)
                .authorizationRequestResolver(oAuth2AuthorizationRequestResolver)
                .authorizationRequestRepository(oAuth2AuthorizationRequestRepository);
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
    public UserDetailsService userDetailsService() {
        return new AccountServiceImpl();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
        return daoAuthenticationProvider;
    }
}
