package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.configuration.WebConfiguration;
import com.codeaim.urlcheck.model.Check;
import com.codeaim.urlcheck.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomeController
{
    private final WebConfiguration webConfiguration;
    private final RestTemplate restTemplate;

    @Autowired
    public HomeController(
            WebConfiguration webConfiguration,
            RestTemplate restTemplate
    )
    {
        this.webConfiguration = webConfiguration;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/")
    public String home(Model model)
    {
        List<Check> checks =
                restTemplate.exchange(webConfiguration.getGetChecksEndpoint(),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Check>>() {})
                        .getBody();

        model.addAttribute("downCount", checks.stream().filter(x -> x.getStatus() == Status.DOWN).count());
        model.addAttribute("checks", checks);

        return "home";
    }
}
