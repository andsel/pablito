package org.dna.model;

import java.util.List;
import java.util.Set;

public interface TaskerRepository {
    List<Tasker> findAllBySkillsAndLocation(Set<SkillType> skills, String location, long max, int offset);

    long countAllBySkillsAndLocation(Set<SkillType> desiredSkills, String location);

    Tasker getByID(long possibleTasker);

    Tasker save(Tasker tasker);
}
