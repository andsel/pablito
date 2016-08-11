package org.dna.actions;

import org.dna.model.SkillType;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.singletonList;
import static org.dna.model.SkillType.GREENKEEPING;
import static org.dna.model.SkillType.PLUMBING;
import static org.junit.Assert.*;

public class SearchForTaskerTest {

    class InMemoryTaskerRepository implements TaskerRepository {
        @Override
        public List<Tasker> findAllBySkills(Set<SkillType> skills) {
            Tasker greenKeeper = new Tasker("Mario", "Gardening", "Trento", "IT");
            greenKeeper.addSkill(GREENKEEPING);
            Tasker plumber = new Tasker("Giovanna", "Glass cleaning", "Trento", "IT");
            plumber.addSkill(PLUMBING);
            return singletonList(greenKeeper);
        }

        @Override
        public long countAllBySkills(Set<SkillType> desiredSkills) {
            return 1;
        }

        @Override
        public Tasker getByID(long possibleTasker) {
            return null;
        }

        @Override
        public Tasker save(Tasker tasker) {
            return null;
        }
    }

    @Test
    public void workFlowForAction() {
        TaskerRepository repo = new InMemoryTaskerRepository();
        SearchForTasker sut = new SearchForTasker(repo, new HashSet<>(Arrays.asList(GREENKEEPING)));
        List<Tasker> matchingTaskers = sut.execute();

        //Verify
        assertEquals("At least a matching tasker should be present", 1, matchingTaskers.size());
        assertTrue("The matching tasker contains the desired skill", matchingTaskers.get(0).hasSkill(GREENKEEPING));
    }
}