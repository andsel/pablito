package org.dna.web.infrastructure;

import org.dna.model.SkillType;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Used to bootstrap some data into dev DB (like grails Bootstrap.groovy)
 */
@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger LOG = LoggerFactory.getLogger(BootstrapData.class);

    @Autowired
    private TaskerRepository taskerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.debug("Populating bootstrap data");
        Tasker greenKeeper = new Tasker("Mario", "Gardening", "Trento", "IT");
        greenKeeper.setPresentation("I have the passion for gardening and usually I cut the grass and take care of" +
                "my friends gardens. I decided to use my passion to help other people gardens to shine. I'm able" +
                "cut trees and have minimal landscape design abilities.");
        greenKeeper.addSkill(SkillType.GREENKEEPING);
        taskerRepository.save(greenKeeper);

        Tasker plumber = new Tasker("Giovanna", "Glass cleaning", "Trento", "IT");
        plumber.addSkill(SkillType.PLUMBING);
        greenKeeper.setPresentation("I'm Giovanna and I came from a family of plumbers. I'm the first woman " +
                "in my family to get engaged in this field. I'm able to repair the tubes, install and fix heating boilers" +
                "and do minimal mural jobs.");
        taskerRepository.save(plumber);
        LOG.debug("Finished populate bootstrap data");
    }
}
