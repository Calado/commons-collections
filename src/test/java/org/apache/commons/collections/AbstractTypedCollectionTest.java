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
package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Tests TypedCollection.
 *
 * @version $Revision$
 *
 * @author Stephen Colebourne
 */
public abstract class AbstractTypedCollectionTest<T> extends BulkTest {

    public AbstractTypedCollectionTest(String name) {
        super(name);
    }

    protected abstract Collection<T> typedCollection();

    @SuppressWarnings("unchecked")
    protected Class<T> getType() {
        return (Class<T>) String.class;
    }

    @SuppressWarnings("unchecked")
    public void testIllegalAdd() {
        Collection<T> c = typedCollection();
        Integer i = new Integer(3);
        try {
            c.add((T) i);
            fail("Integer should fail string predicate.");
        } catch (IllegalArgumentException e) {
            // expected
        }
        assertTrue("Collection shouldn't contain illegal element", 
         !c.contains(i));   
    }


    @SuppressWarnings("unchecked")
    public void testIllegalAddAll() {
        Collection<T> c = typedCollection();
        List<Object> elements = new ArrayList<Object>();
        elements.add("one");
        elements.add("two");
        elements.add(new Integer(3));
        elements.add("four");
        try {
            c.addAll((Collection<? extends T>) elements);
            fail("Integer should fail string predicate.");
        } catch (IllegalArgumentException e) {
            // expected
        }
        assertTrue("Collection shouldn't contain illegal element", 
         !c.contains("one"));   
        assertTrue("Collection shouldn't contain illegal element", 
         !c.contains("two"));   
        assertTrue("Collection shouldn't contain illegal element", 
         !c.contains(new Integer(3)));   
        assertTrue("Collection shouldn't contain illegal element", 
         !c.contains("four"));   
    }

}
