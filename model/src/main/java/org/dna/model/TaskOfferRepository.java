package org.dna.model;

import java.util.List;

public interface TaskOfferRepository {

    TaskOffer save(TaskOffer tasker);

    List<TaskOffer> pendingRequests(Tasker tasker);
}
