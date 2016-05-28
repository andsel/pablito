package org.dna.actions;

import org.dna.model.BiddersRepository;
import org.dna.model.TaskBidder;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;

public class AskTaskOfferConfirmation {
    private final BiddersRepository biddersRepo;
    private TaskerRepository taskersRepo;

    public AskTaskOfferConfirmation(BiddersRepository biddersRepo) {
        this.biddersRepo = biddersRepo;
    }

    public void execute(String id, TaskOffer offer) {
        TaskBidder bidder = biddersRepo.getByID(id);
        bidder.offerTask(offer);

        Tasker tasker = taskersRepo.getByID(offer.possibleTasker);
        tasker.notifyTaskOffered(offer);
    }
}
