/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function7
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import io.reactivex.functions.Function7;

static final class Functions.Array7Func<T1, T2, T3, T4, T5, T6, T7, R>
implements Function<Object[], R> {
    final Function7<T1, T2, T3, T4, T5, T6, T7, R> f;

    Functions.Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        this.f = function7;
    }

    public R apply(Object[] objectArray) throws Exception {
        if (objectArray.length == 7) {
            return (R)this.f.apply(objectArray[0], objectArray[1], objectArray[2], objectArray[3], objectArray[4], objectArray[5], objectArray[6]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 7 expected but got ");
        stringBuilder.append(objectArray.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
