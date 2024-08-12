/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableError<T>
extends Flowable<T> {
    final Callable<? extends Throwable> errorSupplier;

    public FlowableError(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable throwable;
        try {
            throwable = (Throwable)ObjectHelper.requireNonNull((Object)this.errorSupplier.call(), (String)"Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
        }
        EmptySubscription.error((Throwable)throwable, subscriber);
    }
}
