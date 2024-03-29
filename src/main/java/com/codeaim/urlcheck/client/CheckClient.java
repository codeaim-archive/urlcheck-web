package com.codeaim.urlcheck.client;

import com.codeaim.urlcheck.configuration.WebConfiguration;
import com.codeaim.urlcheck.model.Check;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        return restTemplate.exchange(
                webConfiguration
                        .getGetChecksByUsernameEndpoint()
                        .replace("{username}", username),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Check>>() {})
                .getBody();
    }

    @HystrixCommand(fallbackMethod = "createCheckFallback")
    public Check createCheck(Check check, String username)
    {
        return restTemplate.exchange(
                webConfiguration
                        .getCreateCheckEndpoint()
                        .replace("{username}", username),
                HttpMethod.POST,
                new HttpEntity<>(check, null),
                Check.class,
                Collections.emptyMap())
                .getBody();
    }

    @HystrixCommand(fallbackMethod = "updateCheckFallback")
    public Check updateCheck(Check check, String username)
    {
        return restTemplate.exchange(
                webConfiguration
                        .getUpdateCheckEndpoint()
                        .replace("{username}", username)
                        .replace("{id}", check.getId().toString()),
                HttpMethod.POST,
                new HttpEntity<>(check, null),
                Check.class,
                Collections.emptyMap())
                .getBody();
    }

    @HystrixCommand(fallbackMethod = "deleteCheckFallback")
    public void deleteCheck(Long id, String username)
    {
        restTemplate.delete(
                webConfiguration
                        .getDeleteCheckEndpoint()
                        .replace("{username}", username)
                        .replace("{id}", id.toString()));
    }

    public List<Check> getChecksByUsernameFallback(String username)
    {
        return Collections.emptyList();
    }

    public Check createCheckFallback(Check check, String username)
    {
        return check;
    }

    public Check updateCheckFallback(Check check, String username)
    {
        return check;
    }

    public void deleteCheckFallback(Long id, String username)
    {
    }
}
