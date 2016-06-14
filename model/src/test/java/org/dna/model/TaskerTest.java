package org.dna.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskerTest {

    private Tasker sut;

    @Before
    public void setUp() {
        sut = new Tasker();
        sut.addSkill(Tasker.Skill.GREENKEEPING);
    }

    @Test
    public void testRequestForTask() {
        TaskOffer offer = new TaskOffer(Tasker.Skill.GREENKEEPING);
        TaskBidderId requester = new TaskBidderId("abcde");
        sut.postTaskRequest(offer, requester);

        assertEquals(1, sut.pendingRequests().size());
    }

    @Test
    public void testCantRequestForTaskWithoutMatchingSkill() {
        TaskOffer offer = new TaskOffer(Tasker.Skill.PLUMBING);
        TaskBidderId requester = new TaskBidderId("abcde");
        sut.postTaskRequest(offer, requester);

        assertTrue("A PLUMBING tasker can't be presented with requesting GREENKEEPING skills",
                sut.pendingRequests().isEmpty());
    }

    @Test
    public void testSkills() {
        assertTrue(sut.hasSkill(Tasker.Skill.GREENKEEPING));
        assertFalse(sut.hasSkill(Tasker.Skill.PLUMBING));
    }
}