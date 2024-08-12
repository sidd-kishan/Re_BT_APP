/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableSequenceEqual
 *  io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle$EqualCoordinator
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;

public final class FlowableSequenceEqualSingle<T>
extends Single<Boolean>
implements FuseToFlowable<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final Publisher<? extends T> first;
    final int prefetch;
    final Publisher<? extends T> second;

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int n) {
        this.first = publisher;
        this.second = publisher2;
        this.comparer = biPredicate;
        this.prefetch = n;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSequenceEqual(this.first, this.second, this.comparer, this.prefetch));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.prefetch, this.comparer);
        singleObserver.onSubscribe((Disposable)equalCoordinator);
        equalCoordinator.subscribe(this.first, this.second);
    }
}
