/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function3
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;

static final class Functions.Array3Func<T1, T2, T3, R>
implements Function<Object[], R> {
    final Function3<T1, T2, T3, R> f;

    Functions.Array3Func(Function3<T1, T2, T3, R> function3) {
        this.f = function3;
    }

    public R apply(Object[] objectArray) throws Exception {
        if (objectArray.length == 3) {
            return (R)this.f.apply(objectArray[0], objectArray[1], objectArray[2]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 3 expected but got ");
        stringBuilder.append(objectArray.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
