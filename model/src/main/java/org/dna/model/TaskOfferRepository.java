package org.dna.model;

import java.util.List;

public interface TaskOfferRepository {

    TaskOffer getByID(long offerId);

    TaskOffer save(TaskOffer offer);

    List<TaskOffer> pendingRequests(Tasker tasker);
}
