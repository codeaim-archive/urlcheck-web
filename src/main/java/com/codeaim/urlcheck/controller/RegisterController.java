package com.codeaim.urlcheck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "register")
public class RegisterController
{
    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model)
    {
        return "register";
    }
}
