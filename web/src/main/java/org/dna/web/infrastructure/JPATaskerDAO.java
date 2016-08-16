package org.dna.web.infrastructure;

import org.dna.model.SkillType;
import org.dna.model.Tasker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface JPATaskerDAO extends JpaRepository<Tasker, Long> {

    Page<Tasker> findBySkillsContainingAndLocation(SkillType skill, String location, Pageable pageable);

    long countBySkillsContainingAndLocation(SkillType skill, String location);
}
