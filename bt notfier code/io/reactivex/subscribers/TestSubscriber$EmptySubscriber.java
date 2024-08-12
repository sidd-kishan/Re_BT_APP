/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscription;

static final class TestSubscriber.EmptySubscriber
extends Enum<TestSubscriber.EmptySubscriber>
implements FlowableSubscriber<Object> {
    private static final TestSubscriber.EmptySubscriber[] $VALUES;
    public static final /* enum */ TestSubscriber.EmptySubscriber INSTANCE;

    static {
        TestSubscriber.EmptySubscriber emptySubscriber;
        INSTANCE = emptySubscriber = new TestSubscriber.EmptySubscriber();
        $VALUES = new TestSubscriber.EmptySubscriber[]{emptySubscriber};
    }

    public static TestSubscriber.EmptySubscriber valueOf(String string) {
        return Enum.valueOf(TestSubscriber.EmptySubscriber.class, string);
    }

    public static TestSubscriber.EmptySubscriber[] values() {
        return (TestSubscriber.EmptySubscriber[])$VALUES.clone();
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(Subscription subscription) {
    }
}
