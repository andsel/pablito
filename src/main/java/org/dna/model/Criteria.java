package org.dna.model;

import java.util.HashSet;
import java.util.Set;

/*
 * Value object for searching
 */
public class Criteria<T> {
    class ContainsCondition {

        private final String attributeName;
        private final String containedValue;

        public ContainsCondition(String attributeName, String containedValue) {
            this.attributeName = attributeName;
            this.containedValue = containedValue;
        }
    }

    private final Class<T> cls;
    private final Set<ContainsCondition> conditions = new HashSet<>();

    public Criteria(Class<T> cls) {
        this.cls = cls;
    }

    public Criteria<T> contains(String attributeName, String containedValue) {
        this.conditions.add(new ContainsCondition(attributeName, containedValue));
        return this;
    }
}
