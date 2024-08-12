/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.ProtocolViolationException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static String composeMessage(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("It is not allowed to subscribe with a(n) ");
        stringBuilder.append(string);
        stringBuilder.append(" multiple times. Please create a fresh instance of ");
        stringBuilder.append(string);
        stringBuilder.append(" and subscribe that to the target source instead.");
        return stringBuilder.toString();
    }

    public static void reportDoubleSubscription(Class<?> clazz) {
        RxJavaPlugins.onError((Throwable)new ProtocolViolationException(EndConsumerHelper.composeMessage(clazz.getName())));
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> clazz) {
        ObjectHelper.requireNonNull((Object)disposable, (String)"next is null");
        if (atomicReference.compareAndSet(null, disposable)) return true;
        disposable.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) return false;
        EndConsumerHelper.reportDoubleSubscription(clazz);
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> clazz) {
        ObjectHelper.requireNonNull((Object)subscription, (String)"next is null");
        if (atomicReference.compareAndSet(null, subscription)) return true;
        subscription.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) return false;
        EndConsumerHelper.reportDoubleSubscription(clazz);
        return false;
    }

    public static boolean validate(Disposable disposable, Disposable disposable2, Class<?> clazz) {
        ObjectHelper.requireNonNull((Object)disposable2, (String)"next is null");
        if (disposable == null) return true;
        disposable2.dispose();
        if (disposable == DisposableHelper.DISPOSED) return false;
        EndConsumerHelper.reportDoubleSubscription(clazz);
        return false;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2, Class<?> clazz) {
        ObjectHelper.requireNonNull((Object)subscription2, (String)"next is null");
        if (subscription == null) return true;
        subscription2.cancel();
        if (subscription == SubscriptionHelper.CANCELLED) return false;
        EndConsumerHelper.reportDoubleSubscription(clazz);
        return false;
    }
}
