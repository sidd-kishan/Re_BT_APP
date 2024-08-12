/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.parallel.ParallelFlowable
 */
package io.reactivex.parallel;

import io.reactivex.parallel.ParallelFlowable;

public interface ParallelTransformer<Upstream, Downstream> {
    public ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> var1);
}
