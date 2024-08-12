/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 */
package io.reactivex;

import io.reactivex.Single;

public interface SingleConverter<T, R> {
    public R apply(Single<T> var1);
}
