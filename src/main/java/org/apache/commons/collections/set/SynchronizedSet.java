/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.collections.set;

import java.util.Set;

import org.apache.commons.collections.collection.SynchronizedCollection;

/**
 * Decorates another <code>Set</code> to synchronize its behaviour for a
 * multi-threaded environment.
 * <p>
 * Methods are synchronized, then forwarded to the decorated set.
 * <p>
 * This class is Serializable from Commons Collections 3.1.
 *
 * @since 3.0
 * @version $Id$
 */
public class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {

    /** Serialization version */
    private static final long serialVersionUID = -8304417378626543635L;

    /**
     * Factory method to create a synchronized set.
     * 
     * @param <E> the element type
     * @param set  the set to decorate, must not be null
     * @return a new synchronized set
     * @throws IllegalArgumentException if set is null
     */
    public static <E> SynchronizedSet<E> synchronizedSet(Set<E> set) {
        return new SynchronizedSet<E>(set);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Constructor that wraps (not copies).
     * 
     * @param set  the set to decorate, must not be null
     * @throws IllegalArgumentException if set is null
     */
    protected SynchronizedSet(Set<E> set) {
        super(set);
    }

    /**
     * Constructor that wraps (not copies).
     * 
     * @param set  the set to decorate, must not be null
     * @param lock  the lock object to use, must not be null
     * @throws IllegalArgumentException if set is null
     */
    protected SynchronizedSet(Set<E> set, Object lock) {
        super(set, lock);
    }

    /**
     * Gets the decorated set.
     * 
     * @return the decorated set
     */
    protected Set<E> getSet() {
        return (Set<E>) collection;
    }

}
