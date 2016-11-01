package com.codeaim.urlcheck.controller;

import com.codeaim.urlcheck.client.CheckClient;
import com.codeaim.urlcheck.model.Check;
import com.codeaim.urlcheck.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

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
    public String dashboardRedirect(Principal principal)
    {
        return "redirect:/dashboard/" + principal.getName();
    }

    @RequestMapping(value = "/{username:.+}", method = RequestMethod.GET)
    public String dashboard(
            @PathVariable(value = "username")
                    String username,
            Model model,
            Principal principal
    )
    {
        if (!Objects.equals(username, principal.getName()))
            return "redirect:/dashboard/" + principal.getName();

        List<Check> checks = checkClient
                .getChecksByUsername(username);

        model.addAttribute("downCount", checks
                .stream()
                .filter(x -> x.getStatus() == Status.DOWN)
                .count());
        model.addAttribute("checks", checks);
        model.addAttribute("username", username);

        return "dashboard";
    }
}
