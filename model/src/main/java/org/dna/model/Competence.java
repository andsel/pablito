package org.dna.model;

/**
 * A Tasker competence acknowledged by the Bidders. For example
 * 'in time', 'clean', 'professionalism'.
 * These competences are added by Bidders to the profile of a Tasker.
 *
 * A competence has number of Bidders voters.
 *
 * Value object
 */
public class Competence {
    private String name;
    private int votes;

    private Competence() {}

    public Competence(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competence that = (Competence) o;

        if (votes != that.votes) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + votes;
        return result;
    }
}
