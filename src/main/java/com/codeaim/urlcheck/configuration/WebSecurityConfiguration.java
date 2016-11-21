package com.codeaim.urlcheck.configuration;

import com.codeaim.urlcheck.client.CheckClient;
import com.codeaim.urlcheck.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ShellProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    private UserClient userClient;
    private PasswordEncoder passwordEncoder;
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    public WebSecurityConfiguration(
            UserClient userClient,
            PasswordEncoder passwordEncoder,
            AuthenticationFailureHandler authenticationFailureHandler
    )
    {
        this.userClient = userClient;
        this.passwordEncoder = passwordEncoder;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers(
                        "/fonts/**",
                        "/register",
                        "/user/{username}/verify",
                        "/user/{username}/verification",
                        "/login**",
                        "/register**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureHandler(authenticationFailureHandler)
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
                .userDetailsService(userClient)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
