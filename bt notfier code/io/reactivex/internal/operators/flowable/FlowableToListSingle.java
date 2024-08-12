/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableToList
 *  io.reactivex.internal.operators.flowable.FlowableToListSingle$ToListSubscriber
 *  io.reactivex.internal.util.ArrayListSupplier
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.flowable.FlowableToList;
import io.reactivex.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class FlowableToListSingle<T, U extends Collection<? super T>>
extends Single<U>
implements FuseToFlowable<U> {
    final Callable<U> collectionSupplier;
    final Flowable<T> source;

    public FlowableToListSingle(Flowable<T> flowable) {
        this(flowable, ArrayListSupplier.asCallable());
    }

    public FlowableToListSingle(Flowable<T> flowable, Callable<U> callable) {
        this.source = flowable;
        this.collectionSupplier = callable;
    }

    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableToList(this.source, this.collectionSupplier));
    }

    protected void subscribeActual(SingleObserver<? super U> singleObserver) {
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), (String)"The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, singleObserver);
            return;
        }
        this.source.subscribe((FlowableSubscriber)new ToListSubscriber(singleObserver, collection));
    }
}
