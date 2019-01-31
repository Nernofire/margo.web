package margo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "home"}, name = "/home")
    public String index() {
        return "home";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String actionAccessDenied(Model model) {
        return "errors/access_denied";
    }

    @RequestMapping(value = "/person")
    public String person() {
        return "person";
    }

    @RequestMapping(value = "/notifications")
    public String notifications() {
        return "notifications";
    }

    @RequestMapping("/transactions")
    public String transactions() {
        return "transaction";
    }
}
