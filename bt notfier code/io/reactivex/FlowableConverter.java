/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 */
package io.reactivex;

import io.reactivex.Flowable;

public interface FlowableConverter<T, R> {
    public R apply(Flowable<T> var1);
}
