package org.protogalaxy.phss.security.config;

import org.protogalaxy.phss.security.main.AjaxAuthFailHandler;
import org.protogalaxy.phss.security.main.AjaxAuthSuccessHandler;
import org.protogalaxy.phss.security.main.PhssUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


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
                .authorizeRequests()
                .antMatchers("/", "/index", "/user/register", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(ajaxAuthSuccessHandler)
                .failureHandler(ajaxAuthFailHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
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
}
