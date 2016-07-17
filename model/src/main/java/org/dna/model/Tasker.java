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
    private String name;
    private Set<Skill> skills = new HashSet<>();
    private final List<TaskOffer> pendingOffers = new ArrayList<>();

    private Tasker() {}

    public Tasker(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
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
