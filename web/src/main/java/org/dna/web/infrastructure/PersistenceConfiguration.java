package org.dna.web.infrastructure;

import org.dna.model.TaskerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
    @Bean
    public TaskerRepository taskerRepository(JPATaskerDAO taskerDAO) {
        return new TaskerRepositoryImpl(taskerDAO);
    }
}
