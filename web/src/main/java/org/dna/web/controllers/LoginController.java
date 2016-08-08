package org.dna.web.controllers;

import org.dna.model.SkillType;
import org.dna.model.TaskOffer;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.dna.web.model.TaskerHireRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.singletonList;


@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    TaskerRepository taskerRepository;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam(value="location", required=false) String location,
                         @RequestParam(value="expertise", required=false) String expertise,
                         Model model) {
        SkillType desiredSkill = SkillType.ANY_SKILL;
        if (!StringUtils.isEmpty(expertise)) {
            try {
                desiredSkill = SkillType.valueOf(expertise.toUpperCase());
            } catch (IllegalArgumentException iae) {
                //TODO present the user with an error
                LOG.debug("User choose invalid skill type");
            }
        }

        Set<SkillType> desiredSkills = new HashSet<>(singletonList(desiredSkill));
        List<Tasker> taskers = this.taskerRepository.findAllBySkills(desiredSkills);
        model.addAttribute("taskers", taskers);
        return "search";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        //here come after the POST /logout, gets a redirect to here, present
        LOG.debug("Reached login GET");
        return "login";
    }

    @RequestMapping(value = "/tasker/{taskerId}/details")
    public String detail(@PathVariable("taskerId") long taskerId, Model model) {
        Tasker tasker = this.taskerRepository.getByID(taskerId);
        model.addAttribute("tasker", tasker);
        return "tasker_detail";
    }

    @RequestMapping(value = "/tasker/{taskerId}/hire", method = RequestMethod.GET)
    public String hireForm(@PathVariable("taskerId") long taskerId, Model model) {
        Tasker tasker = this.taskerRepository.getByID(taskerId);
        model.addAttribute("tasker", tasker);
        model.addAttribute("hireRequest", new TaskerHireRequest());
        return "hire_tasker";
    }

    @RequestMapping(value = "/tasker/hire", method = RequestMethod.POST)
    public String hireSubmit(@RequestParam("taskerId") long taskerId,
                             @ModelAttribute TaskerHireRequest taskHire,
                             Model model) {
        LOG.info("taskHire {}", taskHire);
        Tasker tasker = this.taskerRepository.getByID(taskerId);
        TaskOffer offer = new TaskOffer(SkillType.GREENKEEPING); //TODO read from TaskerHireRequest
        tasker.postTaskRequest(offer, 1L); //TODO load the id from the session user
        this.taskerRepository.save(tasker);
        return "redirect:/search";
    }
}
