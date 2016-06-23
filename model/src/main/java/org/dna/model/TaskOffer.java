package org.dna.model;

public class TaskOffer {
    private long taskRequesterId;
    final Tasker.Skill skill;

    public TaskOffer(Tasker.Skill skill) {
        this.skill = skill;
    }

    void requestedBy(long requester) {
        this.taskRequesterId = requester;
    }
}
