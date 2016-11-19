package com.codeaim.urlcheck.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class AuthenticationFailureConfiguration extends SimpleUrlAuthenticationFailureHandler
{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
    {
        if(exception.getClass().isAssignableFrom(LockedException.class))
            this.setDefaultFailureUrl("/login?locked=" + request.getParameter("username"));

        if(exception.getClass().isAssignableFrom(BadCredentialsException.class))
            this.setDefaultFailureUrl("/login?error");

        super.onAuthenticationFailure(request, response, exception);
    }
}
