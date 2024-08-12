/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.parallel.ParallelFlowable
 */
package io.reactivex.parallel;

import io.reactivex.parallel.ParallelFlowable;

public interface ParallelFlowableConverter<T, R> {
    public R apply(ParallelFlowable<T> var1);
}
