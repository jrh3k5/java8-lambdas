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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * A set of tests of {@link GiverGetter} that compares mocking of an answer in Java-7-compliant Java to Java 8.
 * 
 * @author jrh3k5
 */

@RunWith(MockitoJUnitRunner.class)
public class GiverGetterTest {
    @Mock
    private GiverGetter<Integer> giverGetter;

    /**
     * Tests the mutation mocking in Java 7 and earlier.
     */
    @Test
    public void testMutateVanillaJava() {
        when(giverGetter.mutate(anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return invocation.<Integer>getArgument(0) * 2;
            }
        });
        assertThat(giverGetter.mutate(2)).isEqualTo(4);
    }

    /**
     * Tests the mutation mocking in Java 8.
     */
    @Test
    public void testMutateJava8() {
        when(giverGetter.mutate(anyInt())).thenAnswer((i) -> { return i.<Integer>getArgument(0) * 2; });
        assertThat(giverGetter.mutate(2)).isEqualTo(4);
    }
}
