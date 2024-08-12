/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposeBackpressureHelper
 *  com.uber.autodispose.AutoDisposeUtil
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposeBackpressureHelper;
import com.uber.autodispose.AutoDisposeUtil;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

final class AutoSubscriptionHelper
extends Enum<AutoSubscriptionHelper>
implements Subscription {
    private static final AutoSubscriptionHelper[] $VALUES;
    public static final /* enum */ AutoSubscriptionHelper CANCELLED;

    static {
        AutoSubscriptionHelper autoSubscriptionHelper;
        CANCELLED = autoSubscriptionHelper = new AutoSubscriptionHelper();
        $VALUES = new AutoSubscriptionHelper[]{autoSubscriptionHelper};
    }

    static boolean cancel(AtomicReference<Subscription> subscription) {
        AutoSubscriptionHelper autoSubscriptionHelper;
        Subscription subscription2 = subscription.get();
        if (subscription2 == (autoSubscriptionHelper = CANCELLED)) return false;
        if ((subscription = subscription.getAndSet((Subscription)autoSubscriptionHelper)) == CANCELLED) return false;
        if (subscription == null) return true;
        subscription.cancel();
        return true;
    }

    static void deferredRequest(AtomicReference<Subscription> subscription, AtomicLong atomicLong, long l) {
        Subscription subscription2 = subscription.get();
        if (subscription2 != null) {
            subscription2.request(l);
        } else {
            if (!AutoSubscriptionHelper.validate(l)) return;
            AutoDisposeBackpressureHelper.add((AtomicLong)atomicLong, (long)l);
            subscription = subscription.get();
            if (subscription == null) return;
            l = atomicLong.getAndSet(0L);
            if (l == 0L) return;
            subscription.request(l);
        }
    }

    static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (!AutoSubscriptionHelper.setOnce(atomicReference, subscription)) return false;
        long l = atomicLong.getAndSet(0L);
        if (l == 0L) return true;
        subscription.request(l);
        return true;
    }

    static boolean isCancelled(Subscription subscription) {
        boolean bl = subscription == CANCELLED;
        return bl;
    }

    static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            if ((subscription2 = atomicReference.get()) != CANCELLED) continue;
            if (subscription == null) return false;
            subscription.cancel();
            return false;
        } while (!atomicReference.compareAndSet(subscription2, subscription));
        return true;
    }

    static void reportMoreProduced(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("More produced than requested: ");
        stringBuilder.append(l);
        RxJavaPlugins.onError((Throwable)new IllegalStateException(stringBuilder.toString()));
    }

    static void reportSubscriptionSet() {
        RxJavaPlugins.onError((Throwable)new IllegalStateException("Subscription already set!"));
    }

    static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
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

    static boolean setIfNotSet(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        AutoDisposeUtil.checkNotNull((Object)subscription, (String)"s is null");
        return atomicReference.compareAndSet(null, subscription);
    }

    static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        AutoDisposeUtil.checkNotNull((Object)subscription, (String)"s is null");
        if (atomicReference.compareAndSet(null, subscription)) return true;
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) return false;
        AutoSubscriptionHelper.reportSubscriptionSet();
        return false;
    }

    static boolean validate(long l) {
        if (l > 0L) return true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("n > 0 required but it was ");
        stringBuilder.append(l);
        RxJavaPlugins.onError((Throwable)new IllegalArgumentException(stringBuilder.toString()));
        return false;
    }

    static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.onError((Throwable)new NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) return true;
        subscription2.cancel();
        AutoSubscriptionHelper.reportSubscriptionSet();
        return false;
    }

    public static AutoSubscriptionHelper valueOf(String string) {
        return Enum.valueOf(AutoSubscriptionHelper.class, string);
    }

    public static AutoSubscriptionHelper[] values() {
        return (AutoSubscriptionHelper[])$VALUES.clone();
    }

    public void cancel() {
    }

    public void request(long l) {
    }
}
