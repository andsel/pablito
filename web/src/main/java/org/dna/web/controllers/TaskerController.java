package org.dna.web.controllers;

import org.dna.model.SkillType;
import org.dna.model.TaskOffer;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.dna.web.model.CustomUser;
import org.dna.web.model.TaskerHireRequest;
import org.dna.web.model.TaskerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for the Tasker entity.
 *
 * Created by andrea on 30/08/16.
 */
@Controller
public class TaskerController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskerController.class);

    @Autowired
    TaskerRepository taskerRepository;

    @RequestMapping(value = "/tasker/{taskerId}/details")
    public String detail(@PathVariable("taskerId") long taskerId, Model model) {
        Tasker tasker = this.taskerRepository.getByID(taskerId);
        model.addAttribute("tasker", new TaskerView(tasker));
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
                             @ModelAttribute TaskerHireRequest taskerHireRequest,
                             Model model, Authentication authentication) {
        LOG.info("taskHire {}", taskerHireRequest);
        Tasker tasker = this.taskerRepository.getByID(taskerId);
        TaskOffer offer = new TaskOffer(SkillType.GREENKEEPING, taskerHireRequest.getDescription());
        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
        tasker.postTaskRequest(offer, userDetails.getEntityId());
        this.taskerRepository.save(tasker);
        return "redirect:/search";
    }

    @RequestMapping(value = "/tasker/requests", method = RequestMethod.GET)
    public String listRequests(Model model, Authentication authentication) {
        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
        LOG.info("listRequests for user {}", userDetails);
        Tasker tasker = this.taskerRepository.getByID(userDetails.getEntityId());
        model.addAttribute("tasker", tasker);
        model.addAttribute("pendingRequests", tasker.pendingRequests());
        model.addAttribute("countRequests", tasker.pendingRequests().size());
        return "tasker_requests";
    }
}
