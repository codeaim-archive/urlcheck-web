package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.client.CheckClient;
import com.codeaim.urlcheck.model.Check;
import com.codeaim.urlcheck.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/check")
public class CheckController
{
    private final CheckClient checkClient;

    @Autowired
    public CheckController(CheckClient checkClient)
    {
        this.checkClient = checkClient;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createCheck(
            @Valid
            @ModelAttribute
                    Check check,
            BindingResult bindingResult,
            Principal principal
    )
    {
        if(bindingResult.hasErrors())
        {
            return "redirect:dashboard";
        }

        check.setUrl(check.getProtocol() + "://" + check.getPath());
        if(check.getName().isEmpty())
            check.setName(check.getUrl());

        if(check.getHeaderList() != null && check.getHeaderList().size() > 0)
            check.setHeaders(new HashSet<>(check
                    .getHeaderList()
                    .stream()
                    .filter(x -> !x.getName().isEmpty())
                    .collect(Collectors.toList())));

        checkClient.createCheck(check, principal.getName());

        return "redirect:dashboard";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String deleteCheck(
            @PathVariable(value = "id", required = true)
            long id,
            Principal principal
    ) {
        checkClient.deleteCheck(id, principal.getName());
        return "redirect:dashboard";
    }
}
