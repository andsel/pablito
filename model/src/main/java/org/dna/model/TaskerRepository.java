package org.dna.model;

import java.util.List;
import java.util.Set;

public interface TaskerRepository {
    List<Tasker> findAllBySkills(Set<Tasker.Skill> skills);

    Tasker getByID(long possibleTasker);

    Tasker save(Tasker tasker);
}
