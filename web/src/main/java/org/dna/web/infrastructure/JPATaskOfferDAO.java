package org.dna.web.infrastructure;

import org.dna.model.TaskOffer;
import org.dna.model.Tasker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface JPATaskOfferDAO extends JpaRepository<TaskOffer, Long> {

    List<TaskOffer> findAllByWorker(Tasker tasker);
}
