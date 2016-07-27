package org.dna.web.model;

/**
 * Created by andrea on 27/07/16.
 */
public class TaskerHireRequest {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskerHireRequest{" +
                "description='" + description + '\'' +
                '}';
    }
}
