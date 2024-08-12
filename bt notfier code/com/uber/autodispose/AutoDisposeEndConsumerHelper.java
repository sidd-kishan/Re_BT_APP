/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposeUtil
 *  com.uber.autodispose.AutoSubscriptionHelper
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.ProtocolViolationException
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposeUtil;
import com.uber.autodispose.AutoSubscriptionHelper;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

final class AutoDisposeEndConsumerHelper {
    private AutoDisposeEndConsumerHelper() {
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
        RxJavaPlugins.onError((Throwable)new ProtocolViolationException(AutoDisposeEndConsumerHelper.composeMessage(clazz.getName())));
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> clazz) {
        AutoDisposeUtil.checkNotNull((Object)disposable, (String)"next is null");
        if (atomicReference.compareAndSet(null, disposable)) return true;
        disposable.dispose();
        if (atomicReference.get() == AutoDisposableHelper.DISPOSED) return false;
        AutoDisposeEndConsumerHelper.reportDoubleSubscription(clazz);
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> clazz) {
        AutoDisposeUtil.checkNotNull((Object)subscription, (String)"next is null");
        if (atomicReference.compareAndSet(null, subscription)) return true;
        subscription.cancel();
        if (atomicReference.get() == AutoSubscriptionHelper.CANCELLED) return false;
        AutoDisposeEndConsumerHelper.reportDoubleSubscription(clazz);
        return false;
    }
}
