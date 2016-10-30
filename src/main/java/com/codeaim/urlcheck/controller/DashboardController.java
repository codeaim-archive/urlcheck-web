package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.client.CheckClient;
import com.codeaim.urlcheck.configuration.WebConfiguration;
import com.codeaim.urlcheck.model.Check;
import com.codeaim.urlcheck.model.Status;
import com.codeaim.urlcheck.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController
{
    private final CheckClient checkClient;

    @Autowired
    public DashboardController(CheckClient checkClient)
    {
        this.checkClient = checkClient;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(Model model, Principal principal)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        List<Check> checks = checkClient.getChecks();

        model.addAttribute("downCount", checks.stream().filter(x -> x.getStatus() == Status.DOWN).count());
        model.addAttribute("checks", checks);
        model.addAttribute("username", userDetails.getUsername());

        return "dashboard";
    }
}
