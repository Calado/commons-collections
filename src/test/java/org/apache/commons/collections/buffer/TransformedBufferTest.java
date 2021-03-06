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

import junit.framework.TestCase;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.TransformedCollectionTest;

/**
 * Extension of {@link TestCase} for exercising the {@link TransformedBuffer}
 * implementation.
 *
 * @since 3.0
 * @version $Id$
 */
public class TransformedBufferTest extends TestCase {
    
    public TransformedBufferTest(String testName) {
        super(testName);
    }

    public void testTransformedBuffer() {
        Buffer<Object> buffer = TransformedBuffer.transformingBuffer(new ArrayStack<Object>(), TransformedCollectionTest.STRING_TO_INTEGER_TRANSFORMER);
        assertEquals(0, buffer.size());
        Object[] els = new Object[] { "1", "3", "5", "7", "2", "4", "6" };
        for (int i = 0; i < els.length; i++) {
            buffer.add(els[i]);
            assertEquals(i + 1, buffer.size());
            assertEquals(true, buffer.contains(new Integer((String) els[i])));
            assertEquals(false, buffer.contains(els[i]));
        }
        
        assertEquals(false, buffer.remove(els[0]));
        assertEquals(true, buffer.remove(new Integer((String) els[0])));
        
    }

    public void testTransformedBuffer_decorateTransform() {
        Buffer originalBuffer = new ArrayStack();
        Object[] els = new Object[] {"1", "3", "5", "7", "2", "4", "6"};
        for (int i = 0; i < els.length; i++) {
            originalBuffer.add(els[i]);
        }
        Buffer buffer = TransformedBuffer.transformedBuffer(originalBuffer, TransformedCollectionTest.STRING_TO_INTEGER_TRANSFORMER);
        assertEquals(els.length, buffer.size());
        for (int i = 0; i < els.length; i++) {
            assertEquals(true, buffer.contains(new Integer((String) els[i])));
            assertEquals(false, buffer.contains(els[i]));
        }
        
        assertEquals(false, buffer.remove(els[0]));
        assertEquals(true, buffer.remove(new Integer((String) els[0])));
    }

    public String getCompatibilityVersion() {
        return "3.1";
    }
}
