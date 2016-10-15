package org.dna.actions;

import org.dna.model.*;

/**
 * Action logic to create a TaskOffer, bind a Tasker and a TaskBidder.
 */
public class CreateOffer {

    private final BidderRepository bidderRepository;
    private final TaskOfferRepository offerRepository;
    private final TaskerRepository taskerRepository;

    public CreateOffer(BidderRepository biddersRepo, TaskOfferRepository offerRepository, TaskerRepository taskerRepository) {
        this.bidderRepository = biddersRepo;
        this.offerRepository = offerRepository;
        this.taskerRepository = taskerRepository;
    }

    public boolean postTaskRequest(long taskerId, long requesterId, String description) {
        Tasker tasker = this.taskerRepository.getByID(taskerId);
        if (tasker.hasSkill(SkillType.GREENKEEPING)) {
            TaskBidder bidder = this.bidderRepository.getByID(requesterId);
            TaskOffer offer = new TaskOffer(SkillType.GREENKEEPING, description, tasker, bidder);
            this.offerRepository.save(offer);
            return true;
        }
        return false;
    }
}
