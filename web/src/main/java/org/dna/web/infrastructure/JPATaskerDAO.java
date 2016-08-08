package org.dna.web.infrastructure;

import org.dna.model.SkillType;
import org.dna.model.Tasker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface JPATaskerDAO extends JpaRepository<Tasker, Long> {

    //Iterable<Tasker> findBySkill(Tasker.Skill skill);

    //@Query("select t from Tasker t where :skill member t.skills")
    Page<Tasker> findBySkillsContaining(/*@Param("skill")*/ SkillType skill, Pageable pageable);
}
