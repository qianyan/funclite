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

public final class Predicates {
    private Predicates() {
    }

    public static <A> Predicate<A> not(final Predicate<A> p) {
        return new Predicate<A>() {
            @Override
            public boolean apply(A input) {
                return !p.apply(input);
            }
        };
    }


    public static <A> Predicate<A> and(final Predicate<A> p, final Predicate<A> p2) {
        return new Predicate<A>() {
            @Override
            public boolean apply(A input) {
                return p.apply(input) && p2.apply(input);
            }
        };
    }

    public static <A> Predicate<A> or(final Predicate<A> p, final Predicate<A> p2) {
        return new Predicate<A>() {
            @Override
            public boolean apply(A input) {
                return p.apply(input) || p2.apply(input);
            }
        };
    }


    @SuppressWarnings("unchecked")
    public static <A> Predicate<A> alwaysTrue() {
        return (Predicate<A>) TRUE;
    }

    @SuppressWarnings("unchecked")
    public static <A> Predicate<A> alwaysFalse() {
        return (Predicate<A>) FALSE;
    }

    public static Predicate<Integer> positive() {
        return new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input != null && input > 0;
            }
        };
    }

    public static <A> com.google.common.base.Predicate<A> toGuava(final Predicate<A> f) {
        return new com.google.common.base.Predicate<A>() {
            @Override
            public boolean apply(A input) {
                return f.apply(input);
            }
        };
    }

    public static <A> Predicate<A> fromGuava(final com.google.common.base.Predicate<A> f) {
        return new Predicate<A>() {
            @Override
            public boolean apply(A input) {
                return f.apply(input);
            }
        };
    }


    public static Predicate<Object> TRUE = new Predicate<Object>() {
        @Override
        public boolean apply(Object input) {
            return true;
        }
    };
    public static Predicate<Object> FALSE = new Predicate<Object>() {
        @Override
        public boolean apply(Object input) {
            return false;
        }
    };

}
