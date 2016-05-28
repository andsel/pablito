package org.dna.model;

import java.util.List;

public interface TaskerRepository {
    List<Tasker> findAllByCriteria(Criteria<Tasker> searchCriteria);

    Tasker getByID(TaskerId possibleTasker);
}
