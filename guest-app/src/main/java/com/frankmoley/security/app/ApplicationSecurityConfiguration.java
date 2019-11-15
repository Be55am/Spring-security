package com.frankmoley.security.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //autherise the all these urls
                .antMatchers("/","/index", "/css/*", "/js/*").permitAll()
                //any other request need to be authenticated.
                .anyRequest().authenticated()
                //let it know that i wanna use Http Basic
                .and().httpBasic();
    }
}
