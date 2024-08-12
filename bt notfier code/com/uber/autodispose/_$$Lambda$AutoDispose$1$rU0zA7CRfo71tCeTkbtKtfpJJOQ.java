/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDispose$1
 *  com.uber.autodispose.ParallelFlowableSubscribeProxy
 *  io.reactivex.CompletableSource
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.ParallelFlowableSubscribeProxy;
import io.reactivex.CompletableSource;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

public final class _$$Lambda$AutoDispose$1$rU0zA7CRfo71tCeTkbtKtfpJJOQ
implements ParallelFlowableSubscribeProxy {
    private final ParallelFlowable f$0;
    private final CompletableSource f$1;

    public /* synthetic */ _$$Lambda$AutoDispose$1$rU0zA7CRfo71tCeTkbtKtfpJJOQ(ParallelFlowable parallelFlowable, CompletableSource completableSource) {
        this.f$0 = parallelFlowable;
        this.f$1 = completableSource;
    }

    public final void subscribe(Subscriber[] subscriberArray) {
        AutoDispose.1.lambda$apply$0((ParallelFlowable)this.f$0, (CompletableSource)this.f$1, (Subscriber[])subscriberArray);
    }
}
