package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController
{
    private final UserClient userClient;

    @Autowired
    public UserController(UserClient userClient)
    {
        this.userClient = userClient;
    }

    @RequestMapping(value = "/{username:.+}/verify", method = RequestMethod.GET)
    public String verifyEmail(
            @PathVariable
                    String username,
            @RequestParam(value = "emailVerificationToken", required = true)
                    String emailVerificationToken
    )
    {
        return userClient.verifyEmail(
                username,
                emailVerificationToken) ?
                "/login?verified" :
                "/login";
    }

    @RequestMapping(value = "/{username:.+}/verification", method = RequestMethod.GET)
    public String verificationEmail(@PathVariable String username)
    {
        return userClient.verificationEmail(username) ?
                "/login?emailSent" :
                "/login";
    }
}
