/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

public final class ArrayCompositeSubscription
extends AtomicReferenceArray<Subscription>
implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int n) {
        super(n);
    }

    public void dispose() {
        int n = 0;
        if (this.get(0) == SubscriptionHelper.CANCELLED) return;
        int n2 = this.length();
        while (n < n2) {
            Subscription subscription;
            if ((Subscription)this.get(n) != SubscriptionHelper.CANCELLED && (subscription = (Subscription)this.getAndSet(n, SubscriptionHelper.CANCELLED)) != SubscriptionHelper.CANCELLED && subscription != null) {
                subscription.cancel();
            }
            ++n;
        }
    }

    public boolean isDisposed() {
        boolean bl = false;
        if (this.get(0) != SubscriptionHelper.CANCELLED) return bl;
        bl = true;
        return bl;
    }

    public Subscription replaceResource(int n, Subscription subscription) {
        Subscription subscription2;
        do {
            if ((subscription2 = (Subscription)this.get(n)) != SubscriptionHelper.CANCELLED) continue;
            if (subscription == null) return null;
            subscription.cancel();
            return null;
        } while (!this.compareAndSet(n, subscription2, subscription));
        return subscription2;
    }

    public boolean setResource(int n, Subscription subscription) {
        Subscription subscription2;
        do {
            if ((subscription2 = (Subscription)this.get(n)) != SubscriptionHelper.CANCELLED) continue;
            if (subscription == null) return false;
            subscription.cancel();
            return false;
        } while (!this.compareAndSet(n, subscription2, subscription));
        if (subscription2 == null) return true;
        subscription2.cancel();
        return true;
    }
}
