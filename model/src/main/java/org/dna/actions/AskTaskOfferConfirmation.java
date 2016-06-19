package org.dna.actions;

import org.dna.model.*;

public class AskTaskOfferConfirmation {
    private final BiddersRepository biddersRepo;
    private TaskerRepository taskersRepo;

    public AskTaskOfferConfirmation(BiddersRepository biddersRepo) {
        this.biddersRepo = biddersRepo;
    }

    public void execute(TaskBidderId bidderId, TaskOffer offer, TaskerId possibleTasker) {
        Tasker tasker = taskersRepo.getByID(possibleTasker);
        tasker.postTaskRequest(offer, bidderId);
    }
}
