package com.springboot.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    

    @Bean
    public PasswordEncoder passwordEncoder() { 
       return NoOpPasswordEncoder.getInstance(); 
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/products").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/products/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/products/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();
    }

    @Override 
    @Bean 
    public AuthenticationManager authenticationManagerBean() throws Exception { 
       return super.authenticationManagerBean(); 
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
        .and()
        .withUser("admin").password("password").roles("USER", "ADMIN");
        ;
    }
}
