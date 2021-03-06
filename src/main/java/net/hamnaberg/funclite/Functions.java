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

public final class Functions {
    private Functions() {
    }

    public static <A> Function<A, A> identity() {
        return new Function<A, A>() {
            @Override
            public A apply(A input) {
                return input;
            }
        };
    }

    public static <A, B, C> Function<A, C> compose(final Function<A, B> f, final Function<B, C> f2) {
        return new Function<A, C>() {
            @Override
            public C apply(A input) {
                return f2.apply(f.apply(input));
            }
        };
    }

    public static <A> Function<A, String> asString() {
        return new Function<A, String>() {
            @Override
            public String apply(A input) {
                return input.toString();
            }
        };
    }

    public static <A,B> com.google.common.base.Function<A, B> toGuava(final Function<A, B> f) {
        return new com.google.common.base.Function<A, B>() {
            @Override
            public B apply(A input) {
                return f.apply(input);
            }
        };
    }

    public static <A,B> Function<A, B> fromGuava(final com.google.common.base.Function<A, B> f) {
        return new Function<A, B>() {
            @Override
            public B apply(A input) {
                return f.apply(input);
            }
        };
    }
}
