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
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * A class demonstrating the differences between vanilla, Java-7-compliant Java, Guava, and Java 8 methods to transform a list of strings to the first character of each string.
 * 
 * @author jrh3k5
 */

public class ListMutator {
    /**
     * Mutates a list using vanilla, Java-7-compliant Java code.
     * 
     * @param values
     *            The values to be converted.
     * @return A {@link List} composed of the first character of each string in the given list.
     */
    public static List<String> mutateVanillaJava(List<String> values) {
        final List<String> valuesCopy = new ArrayList<>(values.size());
        for (String value : values) {
            valuesCopy.add(value.substring(0, 1));
        }
        return valuesCopy;
    }

    /**
     * Mutates a list using Guava.
     * 
     * @param values
     *            The values to be converted.
     * @return A {@link List} composed of the first character of each string in the given list.
     */
    public static List<String> mutateGuava(List<String> values) {
        return Lists.transform(values, new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.substring(0, 1);
            }
        });
    }

    /**
     * Mutates a list using Java-8-compliant Java code.
     * 
     * @param values
     *            The values to be converted.
     * @return A {@link List} composed of the first character of each string in the given list.
     */
    public static List<String> mutateJava8(List<String> values) {
        final List<String> valuesCopy = new ArrayList<>(values);
        valuesCopy.replaceAll((s) -> s.substring(0, 1));
        return valuesCopy;
    }
}
