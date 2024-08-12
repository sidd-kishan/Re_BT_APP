/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function9
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import io.reactivex.functions.Function9;

static final class Functions.Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>
implements Function<Object[], R> {
    final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f;

    Functions.Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        this.f = function9;
    }

    public R apply(Object[] objectArray) throws Exception {
        if (objectArray.length == 9) {
            return (R)this.f.apply(objectArray[0], objectArray[1], objectArray[2], objectArray[3], objectArray[4], objectArray[5], objectArray[6], objectArray[7], objectArray[8]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 9 expected but got ");
        stringBuilder.append(objectArray.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
