package org.dna.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
    private final Collection<Message> chat = new ArrayList<>();

    protected TaskOffer() {}

    public TaskOffer(SkillType skill, String description, Tasker worker, TaskBidder bidder) {
        this.skill = skill;
        this.description = description;
        this.worker = worker;
        this.bidder = bidder;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public void messageToBidder(String message) {
        this.chat.add(new Message(message, new Date(), Message.Direction.WORKER_TO_BIDDER));
    }

    public void messageToWorker(String message) {
        this.chat.add(new Message(message, new Date(), Message.Direction.BIDDER_TO_WORKER));
    }

    public List<Message> listMessages() {
        //TODO access the DAO to get the list ordered by time
        return new ArrayList<>(this.chat);
    }

    public TaskBidder getBidder() {
        return bidder;
    }

    public Tasker getWorker() {
        return worker;
    }
}
