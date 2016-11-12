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

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit tests for {@link ListMutator} that validates consistency of behavior across all methods.
 * 
 * @author jrh3k5
 */

public class ListMutatorTest {
    /**
     * Tests the mutation of values.
     */
    @Test
    public void testMutate() {
        final List<String> values = Arrays.asList("John", "Paul", "George", "Ringo");
        final List<String> expectedMutations = Arrays.asList("J", "P", "G", "R");
        assertThat(ListMutator.mutateVanillaJava(values)).isEqualTo(expectedMutations);
        assertThat(ListMutator.mutateGuava(values)).isEqualTo(expectedMutations);
        assertThat(ListMutator.mutateJava8(values)).isEqualTo(expectedMutations);
    }
}
