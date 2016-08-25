package org.dna.model;

/**
 * Aggregate
 * */
public class TaskBidder {
    private Long id;
    private String login;
    private String zone;
    private double rank;

    protected TaskBidder() {}

    public TaskBidder(String login, String zone, double rank) {
        this.login = login;
        this.zone = zone;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }
}
