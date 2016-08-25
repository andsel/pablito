package org.dna.web.infrastructure;

import org.dna.model.TaskBidder;
import org.springframework.data.jpa.repository.JpaRepository;

interface JPABidderDAO extends JpaRepository<TaskBidder, Long> {

    TaskBidder findByLogin(String login);
}
