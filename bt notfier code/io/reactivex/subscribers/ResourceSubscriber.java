/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.ListCompositeDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.EndConsumerHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class ResourceSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    private final AtomicLong missedRequested;
    private final ListCompositeDisposable resources;
    private final AtomicReference<Subscription> upstream = new AtomicReference();

    public ResourceSubscriber() {
        this.resources = new ListCompositeDisposable();
        this.missedRequested = new AtomicLong();
    }

    public final void add(Disposable disposable) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"resource is null");
        this.resources.add(disposable);
    }

    public final void dispose() {
        if (!SubscriptionHelper.cancel(this.upstream)) return;
        this.resources.dispose();
    }

    public final boolean isDisposed() {
        boolean bl = this.upstream.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    protected void onStart() {
        this.request(Long.MAX_VALUE);
    }

    public final void onSubscribe(Subscription subscription) {
        if (!EndConsumerHelper.setOnce(this.upstream, (Subscription)subscription, this.getClass())) return;
        long l = this.missedRequested.getAndSet(0L);
        if (l != 0L) {
            subscription.request(l);
        }
        this.onStart();
    }

    protected final void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.missedRequested, (long)l);
    }
}
