/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class AsyncSubscription
extends AtomicLong
implements Subscription,
Disposable {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<Subscription> actual;
    final AtomicReference<Disposable> resource = new AtomicReference();

    public AsyncSubscription() {
        this.actual = new AtomicReference();
    }

    public AsyncSubscription(Disposable disposable) {
        this();
        this.resource.lazySet(disposable);
    }

    public void cancel() {
        this.dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    public boolean isDisposed() {
        boolean bl = this.actual.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public boolean replaceResource(Disposable disposable) {
        return DisposableHelper.replace(this.resource, (Disposable)disposable);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.actual, (AtomicLong)this, (long)l);
    }

    public boolean setResource(Disposable disposable) {
        return DisposableHelper.set(this.resource, (Disposable)disposable);
    }

    public void setSubscription(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.actual, (AtomicLong)this, (Subscription)subscription);
    }
}
