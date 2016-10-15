package org.dna.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Aggregate
 * */
public class TaskOffer {

    private Long id;
    private Tasker worker;
    private TaskBidder bidder;
    SkillType skill;
    private String description;
    private final List<Message> chat = new ArrayList<>();

    protected TaskOffer() {}

    public TaskOffer(SkillType skill, String description, Tasker worker, TaskBidder bidder) {
        this.skill = skill;
        this.description = description;
        this.worker = worker;
        this.bidder = bidder;
    }

    public String getDescription() {
        return description;
    }
}
