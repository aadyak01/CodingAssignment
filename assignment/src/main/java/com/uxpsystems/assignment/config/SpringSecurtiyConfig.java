
package com.uxpsystems.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@SuppressWarnings("deprication")
@Configuration
public class SpringSecurtiyConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Amdocs Techie").password("amdocs").roles("ADMIN");
        //auth.inMemoryAuthentication().withUser("Aadya").password("Candidate").roles("Candidate");
    }

    //Securing ALL APIs
  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
    }
/*
    //URL Based Spring Security-Specific Request
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/rest/auth/**").fullyAuthenticated().and().httpBasic();
    }

 */


    /*    //Security Based on ROLES
       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http.csrf().disable();
           http.authorizeRequests().antMatchers("/getUser/**")
                   .hasAnyRole("Candidate").anyRequest().fullyAuthenticated().and().httpBasic();
       }
       */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
