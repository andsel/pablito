package org.dna.actions;

import org.dna.model.Criteria;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.dna.model.Tasker.Skill.GREENKEEPING;
import static org.dna.model.Tasker.Skill.PLUMBING;
import static org.junit.Assert.*;

public class SearchForTaskerTest {

    class InMemoryRepository implements TaskerRepository {
        @Override
        public List<Tasker> findAllByCriteria(Criteria<Tasker> searchCriteria) {
            Tasker greenKeeper = new Tasker();
            greenKeeper.addSkill(GREENKEEPING);
            Tasker plumber = new Tasker();
            plumber.addSkill(PLUMBING);
            return singletonList(greenKeeper);
        }
    }

    @Test
    public void workFlowForAction() {
        TaskerRepository repo = new InMemoryRepository();
        Criteria<Tasker> searchCriteria = new Criteria(Tasker.class).contains("skills", GREENKEEPING.toString());
        SearchForTasker sut = new SearchForTasker(repo, searchCriteria);
        List<Tasker> matchingTaskers = sut.execute();

        //Verify
        assertEquals("At least a matching tasker should be present", 1, matchingTaskers.size());
        assertTrue("The matching tasker contains the desired skill", matchingTaskers.get(0).hasSkill(GREENKEEPING));
    }
}