/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableCollect
 *  io.reactivex.internal.operators.flowable.FlowableCollectSingle$CollectSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableCollect;
import io.reactivex.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class FlowableCollectSingle<T, U>
extends Single<U>
implements FuseToFlowable<U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;
    final Flowable<T> source;

    public FlowableCollectSingle(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.source = flowable;
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }

    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableCollect(this.source, this.initialSupplier, this.collector));
    }

    protected void subscribeActual(SingleObserver<? super U> singleObserver) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull(this.initialSupplier.call(), (String)"The initialSupplier returned a null value");
        }
        catch (Throwable throwable) {
            EmptyDisposable.error((Throwable)throwable, singleObserver);
            return;
        }
        this.source.subscribe((FlowableSubscriber)new CollectSubscriber(singleObserver, object, this.collector));
    }
}
