package org.dna.web.infrastructure;

import org.dna.actions.CreateOffer;
import org.dna.model.BidderRepository;
import org.dna.model.TaskOfferRepository;
import org.dna.model.TaskerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

    @Bean
    public TaskerRepository taskerRepository(JPATaskerDAO taskerDAO) {
        return new TaskerRepositoryImpl(taskerDAO);
    }

    @Bean
    public BidderRepository bidderRepository(JPABidderDAO bidderDAO) {
        return new BidderRepositoryImpl(bidderDAO);
    }

    @Bean
    public TaskOfferRepository taskOfferRepository(JPATaskOfferDAO taskOfferDAO) {
        return new TaskOfferRepositoryImpl(taskOfferDAO);
    }

    @Bean
    public CreateOffer createOffer(BidderRepository bidderRepository, TaskOfferRepository taskOfferRepository,
                                   TaskerRepository taskerRepository) {
        return new CreateOffer(bidderRepository, taskOfferRepository, taskerRepository);
    }
}
