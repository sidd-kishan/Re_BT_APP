/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay;

static interface FlowableReplay.ReplayBuffer<T> {
    public void complete();

    public void error(Throwable var1);

    public void next(T var1);

    public void replay(FlowableReplay.InnerSubscription<T> var1);
}
