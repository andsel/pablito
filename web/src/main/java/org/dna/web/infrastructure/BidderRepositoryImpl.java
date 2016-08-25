package org.dna.web.infrastructure;

import org.dna.model.BidderRepository;
import org.dna.model.TaskBidder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by andrea on 24/08/16.
 */
public class BidderRepositoryImpl implements BidderRepository {

    private final JPABidderDAO bidderDAO;

    @Autowired
    public BidderRepositoryImpl(JPABidderDAO bidderDAO) {
        this.bidderDAO = bidderDAO;
    }

    @Override
    public TaskBidder getByID(long id) {
        return this.bidderDAO.getOne(id);
    }

    @Override
    public TaskBidder getByLogin(String login) {
        return this.bidderDAO.findByLogin(login);
    }

    @Override
    public TaskBidder save(TaskBidder bidder) {
        return this.bidderDAO.save(bidder);
    }
}
