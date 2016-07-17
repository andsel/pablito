package org.dna.web.controllers;

import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;


@Controller
public class LoginController {

    @Autowired
    TaskerRepository taskerRepository;

    @RequestMapping(value="/search")
    public String index(Model model) {
//        Tasker savedTasker = this.taskerRepository.save(new Tasker());
//        Tasker newTasker = this.taskerRepository.getByID(savedTasker.getId());
//        model.addAttribute("tasker", newTasker);
        Set<Tasker.Skill> desiredSkills = new HashSet<>(asList(Tasker.Skill.GREENKEEPING));
        List<Tasker> taskers = this.taskerRepository.findAllBySkills(desiredSkills);
        model.addAttribute("taskers", taskers);
        return "search";
    }

}
