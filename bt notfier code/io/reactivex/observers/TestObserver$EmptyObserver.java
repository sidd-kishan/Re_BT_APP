/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

static final class TestObserver.EmptyObserver
extends Enum<TestObserver.EmptyObserver>
implements Observer<Object> {
    private static final TestObserver.EmptyObserver[] $VALUES;
    public static final /* enum */ TestObserver.EmptyObserver INSTANCE;

    static {
        TestObserver.EmptyObserver emptyObserver;
        INSTANCE = emptyObserver = new TestObserver.EmptyObserver();
        $VALUES = new TestObserver.EmptyObserver[]{emptyObserver};
    }

    public static TestObserver.EmptyObserver valueOf(String string) {
        return Enum.valueOf(TestObserver.EmptyObserver.class, string);
    }

    public static TestObserver.EmptyObserver[] values() {
        return (TestObserver.EmptyObserver[])$VALUES.clone();
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(Disposable disposable) {
    }
}
