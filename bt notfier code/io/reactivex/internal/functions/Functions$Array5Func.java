/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function5
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import io.reactivex.functions.Function5;

static final class Functions.Array5Func<T1, T2, T3, T4, T5, R>
implements Function<Object[], R> {
    private final Function5<T1, T2, T3, T4, T5, R> f;

    Functions.Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
        this.f = function5;
    }

    public R apply(Object[] objectArray) throws Exception {
        if (objectArray.length == 5) {
            return (R)this.f.apply(objectArray[0], objectArray[1], objectArray[2], objectArray[3], objectArray[4]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 5 expected but got ");
        stringBuilder.append(objectArray.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
