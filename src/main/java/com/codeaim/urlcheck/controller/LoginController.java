package com.codeaim.urlcheck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "login")
public class LoginController
{
    @RequestMapping(method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }
}
