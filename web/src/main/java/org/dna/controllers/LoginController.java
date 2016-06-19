package org.dna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class LoginController {

    @RequestMapping(value="/greeting")
    public String index(Model model) {
        return "greeting";
    }

}
