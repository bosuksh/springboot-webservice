package me.doflamingo.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String hello() {
        return "redirect:http://localhost:8080/boards";
    }
}
