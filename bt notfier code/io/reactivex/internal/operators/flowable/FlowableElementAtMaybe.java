/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableElementAt
 *  io.reactivex.internal.operators.flowable.FlowableElementAtMaybe$ElementAtSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableElementAt;
import io.reactivex.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableElementAtMaybe<T>
extends Maybe<T>
implements FuseToFlowable<T> {
    final long index;
    final Flowable<T> source;

    public FlowableElementAtMaybe(Flowable<T> flowable, long l) {
        this.source = flowable;
        this.index = l;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableElementAt(this.source, this.index, null, false));
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((FlowableSubscriber)new ElementAtSubscriber(maybeObserver, this.index));
    }
}
