package com.codeaim.urlcheck.client;

import com.codeaim.urlcheck.configuration.WebConfiguration;
import com.codeaim.urlcheck.model.Check;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CheckClient
{
    private final WebConfiguration webConfiguration;
    private final RestTemplate restTemplate;

    @Autowired
    public CheckClient(
            WebConfiguration webConfiguration,
            RestTemplate restTemplate
    )
    {
        this.webConfiguration = webConfiguration;
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getChecksByUsernameFallback")
    public List<Check> getChecksByUsername(String username)
    {
        return restTemplate.exchange(webConfiguration
                        .getGetChecksByUsernameEndpoint()
                        .replace("{username}", username),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Check>>() {})
                .getBody();
    }

    public List<Check> getChecksByUsernameFallback(String username)
    {
        return Collections.emptyList();
    }
}
