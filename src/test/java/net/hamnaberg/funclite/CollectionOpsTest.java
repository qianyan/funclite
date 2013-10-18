package net.hamnaberg.funclite;

import org.junit.Test;

import java.util.Set;

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
}
