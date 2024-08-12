/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.ReferenceDisposable
 *  org.reactivestreams.Subscription
 */
package io.reactivex.disposables;

import io.reactivex.disposables.ReferenceDisposable;
import org.reactivestreams.Subscription;

final class SubscriptionDisposable
extends ReferenceDisposable<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(Subscription subscription) {
        super((Object)subscription);
    }

    protected void onDisposed(Subscription subscription) {
        subscription.cancel();
    }
}
