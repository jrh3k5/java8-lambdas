package com.github.jrh3k5.java8.lambdas;

/*-
 * #%L
 * Java 8 Lambdas
 * %%
 * Copyright (C) 2016 jrh3k5
 * %%
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                     Version 2, December 2004
 * 
 *  Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 * 
 *  Everyone is permitted to copy and distribute verbatim or modified
 *  copies of this license document, and changing it is allowed as long
 *  as the name is changed.
 * 
 *             DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 * 
 *   0. You just DO WHAT THE FUCK YOU WANT TO.
 * #L%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A class that demonstrates and compares the sorting of a list (in reverse order) in vanilla, version 7 of Java versus version 8 of Java.
 * 
 * @author jrh3k5
 */

public class ListSorter {
    private static final List<NonComparableObject> VALUES = Collections.unmodifiableList(Arrays.asList(new NonComparableObject("aaa"), new NonComparableObject("bbb"), new NonComparableObject("ccc")));

    /**
     * Sorts the list of values in reverse order using Java-7-compliant code.
     * 
     * @return A {@link List} of {@link NonComparableObject} objects, ordered in reverse.
     */
    public static List<NonComparableObject> sortValuesVanillaJava() {
        final Comparator<NonComparableObject> comparator = new Comparator<NonComparableObject>() {
            @Override
            public int compare(NonComparableObject o1, NonComparableObject o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };

        final List<NonComparableObject> valuesCopy = new ArrayList<>(VALUES);
        Collections.sort(valuesCopy, comparator);
        return valuesCopy;
    }

    /**
     * Sort a list of {@link NonComparableObject} objects in reverse order using Lambdas.
     * 
     * @return A {@link List} of {@link NonComparableObject} objects, sorted in reverse order by their values.
     */
    public static List<NonComparableObject> sortValuesJava8() {
        final List<NonComparableObject> valuesCopy = new ArrayList<>(VALUES);
        valuesCopy.sort((o1, o2) -> { return o2.getValue().compareTo(o1.getValue()); });
        return valuesCopy;
    }

    /**
     * An object that does not implement {@link Comparable} to facilitate testing with {@link Comparator} objects.
     * 
     * @author jrh3k5
     */
    public static final class NonComparableObject {
        private final String value;

        /**
         * Create an object that doesn't implement {@link Comparable}.
         * 
         * @param value
         *            The value to be stored within the object.
         */
        public NonComparableObject(String value) {
            this.value = value;
        }

        /**
         * Gets the value stored in the object.
         * 
         * @return The value stored in the object.
         */
        public String getValue() {
            return value;
        }
    }
}
