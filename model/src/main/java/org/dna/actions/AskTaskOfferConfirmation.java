package org.dna.actions;

import org.dna.model.*;

public class AskTaskOfferConfirmation {
    private final BiddersRepository biddersRepo;
    private TaskerRepository taskersRepo;

    public AskTaskOfferConfirmation(BiddersRepository biddersRepo) {
        this.biddersRepo = biddersRepo;
    }

    public void execute(String id, TaskOffer offer) {
        //TaskBidder bidder = biddersRepo.getByID(id);

//        Tasker tasker = taskersRepo.getByID(offer.possibleTasker);
//        tasker.postTaskRequest(offer, new TaskBidderId(id));
    }
}
