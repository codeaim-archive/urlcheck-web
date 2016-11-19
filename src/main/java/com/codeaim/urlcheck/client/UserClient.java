package com.codeaim.urlcheck.client;

import com.codeaim.urlcheck.configuration.WebConfiguration;
import com.codeaim.urlcheck.model.User;
import com.codeaim.urlcheck.model.Verification;
import com.codeaim.urlcheck.model.Verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class UserClient implements UserDetailsService
{
    private final WebConfiguration webConfiguration;
    private final RestTemplate restTemplate;

    @Autowired
    public UserClient(
            WebConfiguration webConfiguration,
            RestTemplate restTemplate
    )
    {
        this.webConfiguration = webConfiguration;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        try
        {
            ResponseEntity<User> response = restTemplate
                    .getForEntity(
                            new URI(webConfiguration
                                    .getGetUserByUsernameEndpoint()
                                    .replace("{username}", username)),
                            User.class);

            return new com.codeaim.urlcheck.model.UserDetails(response.getBody());
        } catch (Exception e)
        {
            throw new UsernameNotFoundException("");
        }
    }

    public boolean verifyEmail(
            String username,
            String emailVerificationToken
    )
    {
        ResponseEntity<Void> response = this.restTemplate.postForEntity(
                webConfiguration
                        .getVerifyUserEmailEndpoint()
                        .replace("{username}", username),
                new Verify().setEmailVerificationToken(emailVerificationToken),
                Void.class);

        return response.getStatusCode().equals(HttpStatus.OK);
    }

    public boolean verificationEmail(
            String username
    )
    {
        ResponseEntity<Void> response = this.restTemplate.postForEntity(
                webConfiguration
                        .getVerifyUserEmailEndpoint()
                        .replace("{username}", username),
                new Verification().setUsername(username),
                Void.class);

        return response.getStatusCode().equals(HttpStatus.OK);
    }
}
