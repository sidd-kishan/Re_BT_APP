/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class EmptySubscription
extends Enum<EmptySubscription>
implements QueueSubscription<Object> {
    private static final EmptySubscription[] $VALUES;
    public static final /* enum */ EmptySubscription INSTANCE;

    static {
        EmptySubscription emptySubscription;
        INSTANCE = emptySubscription = new EmptySubscription();
        $VALUES = new EmptySubscription[]{emptySubscription};
    }

    public static void complete(Subscriber<?> subscriber) {
        subscriber.onSubscribe((Subscription)INSTANCE);
        subscriber.onComplete();
    }

    public static void error(Throwable throwable, Subscriber<?> subscriber) {
        subscriber.onSubscribe((Subscription)INSTANCE);
        subscriber.onError(throwable);
    }

    public static EmptySubscription valueOf(String string) {
        return Enum.valueOf(EmptySubscription.class, string);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[])$VALUES.clone();
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object object) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object object, Object object2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }

    public void request(long l) {
        SubscriptionHelper.validate((long)l);
    }

    public int requestFusion(int n) {
        return n & 2;
    }

    public String toString() {
        return "EmptySubscription";
    }
}
