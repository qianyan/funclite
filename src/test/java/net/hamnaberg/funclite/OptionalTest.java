/*
 * Copyright 2013 Erlend Hamnaberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.hamnaberg.funclite;

import org.junit.Test;

import static org.junit.Assert.*;

public class OptionalTest {

    @Test(expected = IllegalArgumentException.class)
    public void failWhenAddingNullToSome() {
        Optional.some(null);
    }

    @Test
    public void iterableIsWorkingCorrectly() {
        int count = 0;
        for (String s : Optional.some("hello")) {
            assertEquals("hello", s);
            count++;
        }

        assertEquals("Iterator of Some did not produce values", 1, count);
    }
    @Test
    public void iterableOfNoneIsWorkingCorrectly() {
        for (String s : Optional.<String>none()) {
            fail("Iterator of none produced values");
        }
    }
}
