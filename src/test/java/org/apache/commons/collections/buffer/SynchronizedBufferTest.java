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
package org.apache.commons.collections.buffer;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.AbstractCollectionTest;

/**
 * Extension of {@link AbstractCollectionTest} for exercising the
 * {@link SynchronizedBuffer} implementation.
 *
 * @since 3.1
 * @version $Id$
 */
public class SynchronizedBufferTest<E> extends AbstractCollectionTest<E> {

    public SynchronizedBufferTest(String testName) {
        super(testName);
    }

    //-----------------------------------------------------------------------
    @Override
    public Buffer<E> makeObject() {
        return SynchronizedBuffer.synchronizedBuffer(new UnboundedFifoBuffer<E>());
    }

    @Override
    public Collection<E> makeFullCollection() {
        Buffer<E> buffer = new UnboundedFifoBuffer<E>();
        buffer.addAll(Arrays.asList(getFullElements()));
        return SynchronizedBuffer.synchronizedBuffer(buffer);
    }

    @Override
    public Collection<E> makeConfirmedCollection() {
        return new ArrayStack<E>();
    }

    @Override
    public Collection<E> makeConfirmedFullCollection() {
        ArrayStack<E> list = new ArrayStack<E>();
        list.addAll(Arrays.asList(getFullElements()));
        return list;
    }

    @Override
    public boolean isNullSupported() {
        return false;
    }

    @Override
    public String getCompatibilityVersion() {
        return "3.1";
    }

//    public void testCreate() throws Exception {
//        resetEmpty();
//        writeExternalFormToDisk((java.io.Serializable) collection, "D:/dev/collections/data/test/SynchronizedBuffer.emptyCollection.version3.1.obj");
//        resetFull();
//        writeExternalFormToDisk((java.io.Serializable) collection, "D:/dev/collections/data/test/SynchronizedBuffer.fullCollection.version3.1.obj");
//    }

}
