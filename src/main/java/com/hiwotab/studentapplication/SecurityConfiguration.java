package com.hiwotab.studentapplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws  Exception{
        auth .inMemoryAuthentication().withUser("admin").password("password").roles("USER");
        //to add additional accounts, remove  the semicolon at the end of the previous command and add an additional user like below:

        auth .inMemoryAuthentication().withUser("hiwi").password("alex").roles("USER");

    }


    @Override
    protected void configure(HttpSecurity http)throws  Exception{

        http
                .authorizeRequests()
                .antMatchers("/css/**","/js/**","/lib/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .httpBasic();

    }
}
