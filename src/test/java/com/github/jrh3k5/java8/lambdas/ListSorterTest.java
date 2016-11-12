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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.jrh3k5.java8.lambdas.ListSorter.NonComparableObject;

/**
 * Unit tests for {@link ListSorter}.
 * 
 * @author jrh3k5
 */

public class ListSorterTest {
    /**
     * Test the sorting of values using vanilla, Java-7-compliant form.
     */
    @Test
    public void testSortValuesVanillaJava() {
        final List<NonComparableObject> sortedValues = ListSorter.sortValuesVanillaJava();
        final List<String> values = new ArrayList<>(sortedValues.size());
        for (NonComparableObject sortedValue : sortedValues) {
            values.add(sortedValue.getValue());
        }
        assertThat(values).containsExactly("ccc", "bbb", "aaa");
    }

    /**
     * Test the sorting of values using Java 8 style.
     */
    @Test
    public void testSortValuesJava8() {
        assertThat(ListSorter.sortValuesJava8()).extracting((e) -> {
            return e.getValue();
        }).containsExactly("ccc", "bbb", "aaa");
    }
}
