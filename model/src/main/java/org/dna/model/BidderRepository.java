package org.dna.model;

public interface BidderRepository {

    TaskBidder getByID(long id);

    TaskBidder getByLogin(String login);

    TaskBidder save(TaskBidder tasker);
}
