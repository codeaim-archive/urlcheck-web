package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.client.UserClient;
import com.codeaim.urlcheck.model.Register;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "register")
public class RegisterController
{
    private final UserClient userClient;

    public RegisterController(UserClient userClient)
    {
        this.userClient = userClient;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register()
    {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(
            @Valid Register register,
            BindingResult bindingResult
    )
    {
        if(bindingResult.hasErrors())
            return "register?error";

        return userClient.registerUser(register) ?
                "redirect:login?registered"
                : "register?error";
    }
}
