package org.dna.web.infrastructure;

import org.dna.model.Feedback;
import org.dna.model.SkillType;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import static java.lang.Math.random;
import static java.lang.Math.round;

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
        //stores 12 greenkeepers
        String[] greenKeepers = {"Mario", "Andrea", "Alessandro", "Marco", "Antonio", "Carlo", "Davide", "Italo",
                "Enrico", "Federico", "Giacomo", "Luigi", "Mimmo"};

        for (String taskerName : greenKeepers) {
            Tasker greenKeeper = new Tasker(taskerName, "Gardening", "Trento", "IT");
            greenKeeper.setPresentation("I have the passion for gardening and usually I cut the grass and take care of" +
                    "my friends gardens. I decided to use my passion to help other people gardens to shine. I'm able" +
                    "cut trees and have minimal landscape design abilities.");
            greenKeeper.addSkill(SkillType.GREENKEEPING);
            greenKeeper.setFeedback(new Feedback((int)round(random() * 100), random() * 5));
            taskerRepository.save(greenKeeper);
        }

        Tasker plumber = new Tasker("Giovanna", "Glass cleaning", "Trento", "IT");
        plumber.addSkill(SkillType.PLUMBING);
        plumber.setPresentation("I'm Giovanna and I came from a family of plumbers. I'm the first woman " +
                "in my family to get engaged in this field. I'm able to repair the tubes, install and fix heating boilers" +
                "and do minimal mural jobs.");
        taskerRepository.save(plumber);
        LOG.debug("Finished populate bootstrap data");
    }
}
