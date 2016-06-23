package org.dna.model;

import java.util.*;

/*
 * Aggregate
 * */
public class Tasker {
    public enum Skill {
        GREENKEEPING, PLUMBING
    }

    private Long id;

    private Set<Skill> skills = new HashSet<>();

    private final List<TaskOffer> pendingOffers = new ArrayList<>();

    public Tasker() {}

    public Long getId() {
        return this.id;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public boolean hasSkill(Skill desiredSkill) {
        return this.skills.contains(desiredSkill);
    }

    public void postTaskRequest(TaskOffer offer, long taskRquesterId) {
        if (!hasSkill(offer.skill)) {
            return;
        }
        offer.requestedBy(taskRquesterId);
        pendingOffers.add(offer);
    }

    public List<TaskOffer> pendingRequests() {
        return new ArrayList<>(pendingOffers);
    }
}
