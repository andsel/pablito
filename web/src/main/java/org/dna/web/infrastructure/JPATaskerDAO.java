package org.dna.web.infrastructure;

import org.dna.model.Tasker;
import org.springframework.data.jpa.repository.JpaRepository;

interface JPATaskerDAO extends JpaRepository<Tasker, Long> {
}
