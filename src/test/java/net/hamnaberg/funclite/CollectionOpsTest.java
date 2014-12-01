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

import java.util.Set;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class CollectionOpsTest {
    @Test
    public void forAll() {
        Set<Integer> numbers = CollectionOps.setOf(1,2,3,4,5,6,7);

        assertThat(CollectionOps.forall(numbers, Predicates.positive()), is(true));
    }

    @Test
    public void exists() {
        Set<Integer> numbers = CollectionOps.setOf(1,2,3,4,5,6,7);

        assertThat(CollectionOps.exists(numbers, Predicates.positive()), is(true));
        assertThat(CollectionOps.exists(numbers, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input == 3;
            }
        }), is(true));
    }

    @Test
    public void mkString(){
        Set<Integer> numbers = CollectionOps.setOf(1, 2, 3, 4, 5);
        assertThat(CollectionOps.mkString(numbers, ":"), equalTo("1:2:3:4:5"));
    }

    @Test
    public void mkStringWithNullItems(){
        List<Integer> numbers = CollectionOps.of(1, 2, null, 4, 5);
        assertThat(CollectionOps.mkString(numbers, ":"), equalTo("1:2:4:5"));
    }

    @Test
    public void mkStringWithStartAndEnd(){
        Set<Integer> numbers = CollectionOps.setOf(1, 2, 3, 4, 5);
        assertThat(CollectionOps.mkString(numbers, "(", ":", ")"), equalTo("(1:2:3:4:5)"));
    }

    @Test
    public void splitAndJoin(){
        Iterable<String> numbers = CollectionOps.split("1,2,3,4,5,6,7", ",");
        assertThat(CollectionOps.mkString(numbers, "(", ":", ")"), equalTo("(1:2:3:4:5:6:7)"));
    }

    @Test
    public void reduce() throws Exception {
        List<Integer> numbers = CollectionOps.of(1, 2, 3, 4, 5);
        assertThat(CollectionOps.reduce(numbers, sum(), 0), is(15));
    }

    @Test
    public void foldLeft() throws Exception {
        List<Integer> numbers = CollectionOps.of(1, 2, 3, 4, 5);
        assertThat(CollectionOps.foldLeft(numbers, sum(), 0), is(15));
    }

    private Union<Integer> sum() {
        return new Union<Integer>() {
            @Override
            public Integer unite(Integer a, Integer b) {
                return a + b;
            }
        };
    }
}
