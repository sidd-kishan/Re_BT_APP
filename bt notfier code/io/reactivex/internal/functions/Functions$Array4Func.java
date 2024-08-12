/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function4
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;

static final class Functions.Array4Func<T1, T2, T3, T4, R>
implements Function<Object[], R> {
    final Function4<T1, T2, T3, T4, R> f;

    Functions.Array4Func(Function4<T1, T2, T3, T4, R> function4) {
        this.f = function4;
    }

    public R apply(Object[] objectArray) throws Exception {
        if (objectArray.length == 4) {
            return (R)this.f.apply(objectArray[0], objectArray[1], objectArray[2], objectArray[3]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 4 expected but got ");
        stringBuilder.append(objectArray.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
