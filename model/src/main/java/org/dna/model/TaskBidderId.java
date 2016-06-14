package org.dna.model;

public class TaskBidderId {
    private final String id;

    public TaskBidderId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskBidderId)) return false;

        TaskBidderId that = (TaskBidderId) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
