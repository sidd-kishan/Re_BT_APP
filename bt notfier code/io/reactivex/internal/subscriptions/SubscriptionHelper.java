/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.ProtocolViolationException
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class SubscriptionHelper
extends Enum<SubscriptionHelper>
implements Subscription {
    private static final SubscriptionHelper[] $VALUES;
    public static final /* enum */ SubscriptionHelper CANCELLED;

    static {
        SubscriptionHelper subscriptionHelper;
        CANCELLED = subscriptionHelper = new SubscriptionHelper();
        $VALUES = new SubscriptionHelper[]{subscriptionHelper};
    }

    public static boolean cancel(AtomicReference<Subscription> subscription) {
        SubscriptionHelper subscriptionHelper;
        Subscription subscription2 = subscription.get();
        if (subscription2 == (subscriptionHelper = CANCELLED)) return false;
        if ((subscription = subscription.getAndSet((Subscription)subscriptionHelper)) == CANCELLED) return false;
        if (subscription == null) return true;
        subscription.cancel();
        return true;
    }

    public static void deferredRequest(AtomicReference<Subscription> subscription, AtomicLong atomicLong, long l) {
        Subscription subscription2 = subscription.get();
        if (subscription2 != null) {
            subscription2.request(l);
        } else {
            if (!SubscriptionHelper.validate(l)) return;
            BackpressureHelper.add((AtomicLong)atomicLong, (long)l);
            subscription = subscription.get();
            if (subscription == null) return;
            l = atomicLong.getAndSet(0L);
            if (l == 0L) return;
            subscription.request(l);
        }
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (!SubscriptionHelper.setOnce(atomicReference, subscription)) return false;
        long l = atomicLong.getAndSet(0L);
        if (l == 0L) return true;
        subscription.request(l);
        return true;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            if ((subscription2 = atomicReference.get()) != CANCELLED) continue;
            if (subscription == null) return false;
            subscription.cancel();
            return false;
        } while (!atomicReference.compareAndSet(subscription2, subscription));
        return true;
    }

    public static void reportMoreProduced(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("More produced than requested: ");
        stringBuilder.append(l);
        RxJavaPlugins.onError((Throwable)new ProtocolViolationException(stringBuilder.toString()));
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError((Throwable)new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            if ((subscription2 = atomicReference.get()) != CANCELLED) continue;
            if (subscription == null) return false;
            subscription.cancel();
            return false;
        } while (!atomicReference.compareAndSet(subscription2, subscription));
        if (subscription2 == null) return true;
        subscription2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.requireNonNull((Object)subscription, (String)"s is null");
        if (atomicReference.compareAndSet(null, subscription)) return true;
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) return false;
        SubscriptionHelper.reportSubscriptionSet();
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, long l) {
        if (!SubscriptionHelper.setOnce(atomicReference, subscription)) return false;
        subscription.request(l);
        return true;
    }

    public static boolean validate(long l) {
        if (l > 0L) return true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("n > 0 required but it was ");
        stringBuilder.append(l);
        RxJavaPlugins.onError((Throwable)new IllegalArgumentException(stringBuilder.toString()));
        return false;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.onError((Throwable)new NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) return true;
        subscription2.cancel();
        SubscriptionHelper.reportSubscriptionSet();
        return false;
    }

    public static SubscriptionHelper valueOf(String string) {
        return Enum.valueOf(SubscriptionHelper.class, string);
    }

    public static SubscriptionHelper[] values() {
        return (SubscriptionHelper[])$VALUES.clone();
    }

    public void cancel() {
    }

    public void request(long l) {
    }
}
