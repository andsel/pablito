package org.dna.model;

public class TaskOffer {
    private long taskRequesterId;
    SkillType skill;
    private String description;

    private TaskOffer() {}

    public TaskOffer(SkillType skill, String description) {
        this.skill = skill;
        this.description = description;
    }

    void requestedBy(long requester) {
        this.taskRequesterId = requester;
    }
}
