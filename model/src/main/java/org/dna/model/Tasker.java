package org.dna.model;

import java.util.*;

/*
 * Aggregate
 * */
public class Tasker {
    private Long id;
    private String name;
    private String mainSkill;
    private String city;
    private String nation;
    private String presentation;
    private Set<SkillType> skills = new HashSet<>();
    private final List<TaskOffer> pendingOffers = new ArrayList<>();

    protected Tasker() {}

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

    public void addSkill(SkillType skill) {
        this.skills.add(skill);
    }

    public boolean hasSkill(SkillType desiredSkill) {
        return this.skills.contains(desiredSkill);
    }

    public void postTaskRequest(TaskOffer offer, long taskRequesterId) {
        if (!hasSkill(offer.skill)) {
            return;
        }
        offer.requestedBy(taskRequesterId);
        pendingOffers.add(offer);
    }

    public List<TaskOffer> pendingRequests() {
        return new ArrayList<>(pendingOffers);
    }
}
