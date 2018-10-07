package org.protogalaxy.phss.security.config;

import org.protogalaxy.phss.security.main.AjaxAuthFailHandler;
import org.protogalaxy.phss.security.main.AjaxAuthSuccessHandler;
import org.protogalaxy.phss.security.oauth2.PhssAuthorizationCodeTokenResponseClient;
import org.protogalaxy.phss.security.user.PhssUserDetailsService;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class PhssMainSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AjaxAuthSuccessHandler ajaxAuthSuccessHandler;
    private final AjaxAuthFailHandler ajaxAuthFailHandler;

    @Autowired
    public PhssMainSecurityConfig(AjaxAuthSuccessHandler ajaxAuthSuccessHandler, AjaxAuthFailHandler ajaxAuthFailHandler) {
        this.ajaxAuthSuccessHandler = ajaxAuthSuccessHandler;
        this.ajaxAuthFailHandler = ajaxAuthFailHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and()
            //--------------------------Url filter config-------------------------//
            .authorizeRequests()
            .antMatchers("/", "/index", "/user/register", "/user/login").permitAll()
            .anyRequest().authenticated()

            //--------------------- ----OAuth2 config-----------------------------//
            .and().oauth2Login()
            //.tokenEndpoint()
            //.accessTokenResponseClient(accessTokenResponseClient())
            //.and()

            //--------------------------Login config------------------------------//
            .and()
            .formLogin()
            .loginProcessingUrl("/user/login")
            .failureHandler(ajaxAuthFailHandler)
            .successHandler(ajaxAuthSuccessHandler)
            .permitAll()


            //--------------------------Logout config-----------------------------//
            .and()
            .logout()
            .logoutUrl("/user/logout")
            .logoutSuccessUrl("/index")


            //------------------------Remember-me config--------------------------//
            .and()
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
