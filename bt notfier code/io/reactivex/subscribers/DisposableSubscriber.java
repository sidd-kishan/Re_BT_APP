/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.EndConsumerHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    final AtomicReference<Subscription> upstream = new AtomicReference();

    protected final void cancel() {
        this.dispose();
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.upstream);
    }

    public final boolean isDisposed() {
        boolean bl = this.upstream.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    protected void onStart() {
        this.upstream.get().request(Long.MAX_VALUE);
    }

    public final void onSubscribe(Subscription subscription) {
        if (!EndConsumerHelper.setOnce(this.upstream, (Subscription)subscription, this.getClass())) return;
        this.onStart();
    }

    protected final void request(long l) {
        this.upstream.get().request(l);
    }
}
