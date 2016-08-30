package org.dna.web.controllers;

import org.dna.model.*;
import org.dna.web.model.CustomUser;
import org.dna.web.model.TaskerHireRequest;
import org.dna.web.model.TaskerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.singletonList;
import static org.dna.web.model.TaskerView.toView;


@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    private static final int PAGE_SIZE = 10;

    @Autowired
    TaskerRepository taskerRepository;

//    @Autowired
//    BidderRepository biddersRepository;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam(value="location", required=false) String location,
                         @RequestParam(value="expertise", required=false) String expertise,
                         @RequestParam(value="max", required=false) Integer pMax,
                         @RequestParam(value="offset", required=false) Integer pOffset,
                         //Add max and offset
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

        Set<SkillType> desiredSkills = desiredSkill == SkillType.ANY_SKILL ?
                Collections.emptySet() :
                new HashSet<>(singletonList(desiredSkill));
        long max = pMax == null ? 0 : pMax;
        int offset = pOffset == null ? PAGE_SIZE : pOffset;
        List<Tasker> taskers = this.taskerRepository.findAllBySkillsAndLocation(desiredSkills, location, max, offset);
        long total = this.taskerRepository.countAllBySkillsAndLocation(desiredSkills, location);
        int current = (int) Math.floor((double)max / offset);
        Pageable pageRequest = new PageRequest(current, offset);
        Page<TaskerView> page = new PageImpl<>(toView(taskers), pageRequest, total);
        model.addAttribute("page", page);
        model.addAttribute("expertise", expertise);
        model.addAttribute("location", location);
        return "search";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        //here come after the POST /logout, gets a redirect to here, present
        LOG.debug("Reached login GET");
        return "login";
    }

}
