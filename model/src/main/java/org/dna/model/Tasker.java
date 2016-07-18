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
    private String mainSkill;
    private String city;
    private String nation;
    private String presentation;
    private Set<Skill> skills = new HashSet<>();
    private final List<TaskOffer> pendingOffers = new ArrayList<>();

    private Tasker() {}

    public Tasker(String name, String mainSkill, String city, String nation) {
        this.name = name;
        this.mainSkill = mainSkill;
        this.city = city;
        this.nation = nation;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getMainSkill() {
        return mainSkill;
    }

    public String getPresentation() {
        return presentation;
    }

    public String getCity() {
        return city;
    }

    public String getNation() {
        return nation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
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
