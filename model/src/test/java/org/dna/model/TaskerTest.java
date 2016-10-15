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
    public void testSkills() {
        assertTrue(sut.hasSkill(SkillType.GREENKEEPING));
        assertFalse(sut.hasSkill(SkillType.PLUMBING));
    }
}