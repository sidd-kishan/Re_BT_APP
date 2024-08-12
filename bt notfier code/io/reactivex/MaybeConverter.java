/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 */
package io.reactivex;

import io.reactivex.Maybe;

public interface MaybeConverter<T, R> {
    public R apply(Maybe<T> var1);
}
