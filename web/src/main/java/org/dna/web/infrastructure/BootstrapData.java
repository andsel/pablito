package org.dna.web.infrastructure;

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
        Tasker greenKeeper = new Tasker("Mario");
        greenKeeper.addSkill(Tasker.Skill.GREENKEEPING);
        taskerRepository.save(greenKeeper);

        Tasker plumber = new Tasker("Giovanna");
        plumber.addSkill(Tasker.Skill.PLUMBING);
        taskerRepository.save(plumber);
        LOG.debug("Finished populate bootstrap data");
    }
}
