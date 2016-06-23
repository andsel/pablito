package org.dna.web.controllers;

import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @Autowired
    TaskerRepository taskerRepository;

    @RequestMapping(value="/greeting")
    public String index(Model model) {
        Tasker savedTasker = this.taskerRepository.save(new Tasker());
        Tasker newTasker = this.taskerRepository.getByID(savedTasker.getId());
        model.addAttribute("tasker", newTasker);
        return "greeting";
    }

}
