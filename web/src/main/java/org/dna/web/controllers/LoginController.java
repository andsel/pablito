package org.dna.web.controllers;

import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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


    @RequestMapping(value="/tasker/{taskerId}/details")
    public String detail(@PathVariable("taskerId") long taskerId, Model model) {
        Tasker tasker = this.taskerRepository.getByID(taskerId);
        model.addAttribute("tasker", tasker);
        return "tasker_detail";
    }

    @RequestMapping(value="/tasker/{taskerId}/hire", method = RequestMethod.GET)
    public String preHire(@PathVariable("taskerId") long taskerId, Model model) {
        return "hire_tasker";
    }
}
