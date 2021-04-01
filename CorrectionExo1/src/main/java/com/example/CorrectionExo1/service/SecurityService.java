package com.example.CorrectionExo1.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityService extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder encoder;

    public SecurityService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("root"))
                .authorities("ROLE_USER")
                .and()
                .withUser("admin").password(encoder.encode("root"))
                .roles("ADMIN","USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/demo/**").permitAll()
                .antMatchers(HttpMethod.GET).authenticated()
                .antMatchers(HttpMethod.POST).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT).hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .anyRequest().permitAll()
        .and()
        .httpBasic();

    }
}
