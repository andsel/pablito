package org.dna.model;

import java.util.HashSet;
import java.util.Set;

/*
 * Entity
 * */
public class Tasker {
    public enum Skill {
        GREENKEEPING, PLUMBING
    }

    private Set<Skill> skills = new HashSet<>();

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public boolean hasSkill(Skill desiredSkill) {
        return this.skills.contains(desiredSkill);
    }

    public void sendTaskRequest(TaskOffer offer) {
    }
}
