package com.codeaim.urlcheck.client;

import com.codeaim.urlcheck.configuration.WebConfiguration;
import com.codeaim.urlcheck.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

}
