package org.dna.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskerTest {

    private Tasker sut;

    @Before
    public void setUp() {
        sut = new Tasker("Mario", "Gardening", "Trento", "IT");
        sut.addSkill(SkillType.GREENKEEPING);
    }

    @Test
    public void testRequestForTask() {
        TaskOffer offer = new TaskOffer(SkillType.GREENKEEPING);
        sut.postTaskRequest(offer, 1L);

        assertEquals(1, sut.pendingRequests().size());
    }

    @Test
    public void testCantRequestForTaskWithoutMatchingSkill() {
        TaskOffer offer = new TaskOffer(SkillType.PLUMBING);
        sut.postTaskRequest(offer, 1L);

        assertTrue("A PLUMBING tasker can't be presented with requesting GREENKEEPING skills",
                sut.pendingRequests().isEmpty());
    }

    @Test
    public void testSkills() {
        assertTrue(sut.hasSkill(SkillType.GREENKEEPING));
        assertFalse(sut.hasSkill(SkillType.PLUMBING));
    }
}