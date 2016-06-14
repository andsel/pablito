package org.dna.model;

/**
 * Created by andrea on 28/05/16.
 */
public class TaskOffer {
    private TaskBidderId requester;
    final Tasker.Skill skill;

    public TaskOffer(Tasker.Skill skill) {
        this.skill = skill;
    }

    void requestedBy(TaskBidderId requester) {
        this.requester = requester;
    }
}
