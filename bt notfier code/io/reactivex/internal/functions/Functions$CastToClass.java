/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Function;

static final class Functions.CastToClass<T, U>
implements Function<T, U> {
    final Class<U> clazz;

    Functions.CastToClass(Class<U> clazz) {
        this.clazz = clazz;
    }

    public U apply(T t) throws Exception {
        return this.clazz.cast(t);
    }
}
