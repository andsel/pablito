package org.dna.web.infrastructure;

import org.dna.model.BidderRepository;
import org.dna.model.TaskerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public TaskerRepository taskerRepository(JPATaskerDAO taskerDAO) {
        return new TaskerRepositoryImpl(taskerDAO);
    }

    @Bean
    public BidderRepository bidderRepository(JPABidderDAO bidderDAO) {
        return new BidderRepositoryImpl(bidderDAO);
    }
}
