package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.configuration.WebConfiguration;
import com.codeaim.urlcheck.model.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/check")
@ResponseBody
public class CheckController
{
    private RestTemplate restTemplate;
    private WebConfiguration webConfiguration;

    @Autowired
    public CheckController(
            RestTemplate restTemplate,
            WebConfiguration webConfiguration
    )
    {
        this.restTemplate = restTemplate;
        this.webConfiguration = webConfiguration;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Check> getChecks()
    {

        return restTemplate.exchange(webConfiguration.getGetChecksEndpoint(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Check>>() {})
                .getBody();
    }
}
