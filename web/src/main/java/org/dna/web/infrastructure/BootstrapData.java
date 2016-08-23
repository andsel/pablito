package org.dna.web.infrastructure;

import org.dna.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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

        String[] abilities = {"Arieggiatura prato", "Potatura siepi e piccoli cespugli", "Piantumazione siepi e piccoli alberi",
                "Potatura di mantenimento", "Attrezzatura propria", "Smaltimento sfalci", "Pacciamatura",
                "Preparazione e semina del prato"};

        String[] competences = {"Precisione", "Competenza", "Puntualità", "Flessibilità orario"};

        for (String taskerName : greenKeepers) {
            Tasker greenKeeper = new Tasker(taskerName, "Gardening", "Trento", "IT");
            greenKeeper.setPresentation("I have the passion for gardening and usually I cut the grass and take care of" +
                    "my friends gardens. I decided to use my passion to help other people gardens to shine. I'm able" +
                    "cut trees and have minimal landscape design abilities.");
            greenKeeper.addSkill(SkillType.GREENKEEPING);
            greenKeeper.setFeedback(new FeedbackSummary((int)round(random() * 100), random() * 5));

            //Add random abilities
            Set<Ability> abilitiesForTasker = new HashSet<>();
            while (abilitiesForTasker.size() < 6) {
                abilitiesForTasker.add(new Ability(abilities[(int)(random() * abilities.length)]));
            }
            abilitiesForTasker.forEach(greenKeeper::addAbility);

            //Add random competences
            Set<Competence> competencesForTasker = new HashSet<>();
            while (competencesForTasker.size() < 4) {
                int randomCompetenceIdx = (int)(random() * competences.length);
                int competenceVotes = (int)(random() * 20);
                competencesForTasker.add(new Competence(competences[randomCompetenceIdx], competenceVotes));
            }
            competencesForTasker.forEach(greenKeeper::addCompetence);

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
