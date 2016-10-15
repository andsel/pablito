package org.dna.model;

import java.util.*;

/*
 * Aggregate
 * */
public class Tasker {
    private Long id;
    private String name;
    private String mainSkill;
    private String location;
    private String nation;
    private String presentation;
    private Set<SkillType> skills = new HashSet<>();
    private final Set<Competence> competences = new HashSet<>();
    private final Set<Ability> abilities = new HashSet<>();
    private final List<Review> reviews = new ArrayList<>();

    private FeedbackSummary feedback = new FeedbackSummary(0, 0.0);

    protected Tasker() {}

    public Tasker(String name, String mainSkill, String location, String nation) {
        this.name = name;
        this.mainSkill = mainSkill;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public String getNation() {
        return nation;
    }

    public FeedbackSummary getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedbackSummary feedback) {
        this.feedback = feedback;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void addSkill(SkillType skill) {
        this.skills.add(skill);
    }

    public void addCompetence(Competence competence) {
        this.competences.add(competence);
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public boolean hasSkill(SkillType desiredSkill) {
        return this.skills.contains(desiredSkill);
    }
}
