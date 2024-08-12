/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function6
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import io.reactivex.functions.Function6;

static final class Functions.Array6Func<T1, T2, T3, T4, T5, T6, R>
implements Function<Object[], R> {
    final Function6<T1, T2, T3, T4, T5, T6, R> f;

    Functions.Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        this.f = function6;
    }

    public R apply(Object[] objectArray) throws Exception {
        if (objectArray.length == 6) {
            return (R)this.f.apply(objectArray[0], objectArray[1], objectArray[2], objectArray[3], objectArray[4], objectArray[5]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 6 expected but got ");
        stringBuilder.append(objectArray.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
