package org.dna.model;

/**
 * The ability of a tasker to accomplish a task type, for example a Gardener
 * says he can cut the grass, get away the trash the jobs creates and so on.
 *
 * Value object
 */
public class Ability {

    private String name;

    private Ability() {}

    public Ability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ability that = (Ability) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
