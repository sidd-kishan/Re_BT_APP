/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T>
extends CountDownLatch
implements FlowableSubscriber<T> {
    volatile boolean cancelled;
    Throwable error;
    Subscription upstream;
    T value;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T blockingGet() {
        Throwable throwable;
        if (this.getCount() != 0L) {
            try {
                BlockingHelper.verifyNonBlocking();
                this.await();
            }
            catch (InterruptedException interruptedException) {
                Subscription subscription = this.upstream;
                this.upstream = SubscriptionHelper.CANCELLED;
                if (subscription == null) throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
                subscription.cancel();
                throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
            }
        }
        if ((throwable = this.error) != null) throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        return this.value;
    }

    public final void onComplete() {
        this.countDown();
    }

    public final void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (this.cancelled) return;
        subscription.request(Long.MAX_VALUE);
        if (!this.cancelled) return;
        this.upstream = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }
}
