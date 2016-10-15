package org.dna.web.infrastructure;

import org.dna.model.TaskOffer;
import org.dna.model.TaskOfferRepository;
import org.dna.model.Tasker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskOfferRepositoryImpl implements TaskOfferRepository {

    private JPATaskOfferDAO taskOfferDAO;

    @Autowired
    TaskOfferRepositoryImpl(JPATaskOfferDAO taskOfferDAO) {
        this.taskOfferDAO = taskOfferDAO;
    }

    @Override
    public TaskOffer save(TaskOffer offer) {
        return this.taskOfferDAO.save(offer);
    }

    @Override
    public List<TaskOffer> pendingRequests(Tasker tasker) {
        return this.taskOfferDAO.findAllByWorker(tasker);
    }
}
