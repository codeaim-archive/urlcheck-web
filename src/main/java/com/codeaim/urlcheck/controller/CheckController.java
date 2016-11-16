package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.client.CheckClient;
import com.codeaim.urlcheck.model.Check;
import com.codeaim.urlcheck.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/check")
public class CheckController
{
    private final CheckClient checkClient;

    private final Validator validator;

    @Autowired
    public CheckController(
            CheckClient checkClient,
            Validator  validator)
    {
        this.checkClient = checkClient;
        this.validator = validator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createCheck(
            @ModelAttribute
                    Check check,
            BindingResult bindingResult,
            Principal principal
    )
    {
        if(!check.getProtocol().isEmpty() && !check.getPath().isEmpty())
            check.setUrl(check.getProtocol() + "://" + check.getPath());

        validator.validate(check, bindingResult);

        if(bindingResult.hasErrors())
        {
            return "redirect:/" + principal.getName() + "/dashboard#create";
        }

        if(check.getName().isEmpty())
            check.setName(check.getUrl());

        if(check.getHeaderList() != null && check.getHeaderList().size() > 0)
            check.setHeaders(new HashSet<>(check
                    .getHeaderList()
                    .stream()
                    .filter(x -> !x.getName().isEmpty())
                    .collect(Collectors.toList())));

        Check createdCheck = checkClient.createCheck(check, principal.getName());

        return "redirect:/" + principal.getName() + "/dashboard#check-" + createdCheck.getId();
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteCheck(
            @PathVariable(value = "id", required = true)
            long id,
            Principal principal
    ) {
        checkClient.deleteCheck(id, principal.getName());
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateCheck(
            @ModelAttribute
                    Check check,
            BindingResult bindingResult,
            Principal principal
    )
    {
        if(check.getProtocol() != null && !check.getProtocol().isEmpty() && check.getPath() != null && !check.getPath().isEmpty())
            check.setUrl(check.getProtocol() + "://" + check.getPath());

        validator.validate(check, bindingResult);

        if(bindingResult.hasErrors())
        {
            return "redirect:/" + principal.getName() + "/dashboard#check-" + check.getId();
        }

        if(check.isDisable())
            check.setDisabled(check.isCheckDisabled() ? null : Instant.now());

        if(check.getName().isEmpty())
            check.setName(check.getUrl());

        checkClient.updateCheck(check, principal.getName());

        return "redirect:/" + principal.getName() + "/dashboard#check-" + check.getId();
    }
}
