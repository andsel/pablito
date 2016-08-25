package org.dna.actions;

import org.dna.model.*;

public class AskTaskOfferConfirmation {
    private final BidderRepository biddersRepo;
    private TaskerRepository taskersRepo;

    public AskTaskOfferConfirmation(BidderRepository biddersRepo) {
        this.biddersRepo = biddersRepo;
    }

    public void execute(long bidderId, TaskOffer offer, long possibleTasker) {
        Tasker tasker = taskersRepo.getByID(possibleTasker);
        tasker.postTaskRequest(offer, bidderId);
    }
}
