/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

static final class Functions.Array2Func<T1, T2, R>
implements Function<Object[], R> {
    final BiFunction<? super T1, ? super T2, ? extends R> f;

    Functions.Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        this.f = biFunction;
    }

    public R apply(Object[] objectArray) throws Exception {
        if (objectArray.length == 2) {
            return (R)this.f.apply(objectArray[0], objectArray[1]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 2 expected but got ");
        stringBuilder.append(objectArray.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
