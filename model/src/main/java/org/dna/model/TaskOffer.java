package org.dna.model;

public class TaskOffer {
    private long taskRequesterId;
    final SkillType skill;

    public TaskOffer(SkillType skill) {
        this.skill = skill;
    }

    void requestedBy(long requester) {
        this.taskRequesterId = requester;
    }
}
