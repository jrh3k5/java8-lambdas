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

/**
 * This is an interface used to demonstrate the lambda integration with libraries that don't use {@link FunctionalInterface}.
 * 
 * @author jrh3k5
 *
 * @param <T>
 *            The type of object handled by this interface.
 */

public interface GiverGetter<T> {
    /**
     * Mutates the given reference.
     * 
     * @param reference
     *            The reference to be mutated.
     * @return The given reference, but mutated somehow.
     */
    T mutate(T reference);
}
