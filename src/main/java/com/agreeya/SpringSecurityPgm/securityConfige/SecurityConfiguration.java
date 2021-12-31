package com.agreeya.SpringSecurityPgm.securityConfige;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder amb) throws Exception
    {
        amb.inMemoryAuthentication()
                .withUser("vin")
                .password(passwordEncoder().encode("vinoth123"))
                .roles("ADMIN")
                .and()

                .withUser("ashok")
                .password(passwordEncoder().encode("ashok123"))
                .roles("ADMIN_MANAGER")
                .and()

                .withUser("roshan")
                .password(passwordEncoder().encode("roshan123"))
                .roles("MANAGER")
                .and()

                .withUser("niranjan")
                .password(passwordEncoder().encode("niranjan123"))
                .roles("CEO")

        ;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeRequests()
               // .antMatchers("/home1/**").authenticated()
                .antMatchers("/home1/homePage").hasAnyRole("ADMIN","MANAGER")
                .antMatchers("/home1/**").hasAnyRole("ADMIN_MANAGER","CEO")
                .and()
                .httpBasic();

    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
