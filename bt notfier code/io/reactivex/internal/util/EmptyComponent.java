/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class EmptyComponent
extends Enum<EmptyComponent>
implements FlowableSubscriber<Object>,
Observer<Object>,
MaybeObserver<Object>,
SingleObserver<Object>,
CompletableObserver,
Subscription,
Disposable {
    private static final EmptyComponent[] $VALUES;
    public static final /* enum */ EmptyComponent INSTANCE;

    static {
        EmptyComponent emptyComponent;
        INSTANCE = emptyComponent = new EmptyComponent();
        $VALUES = new EmptyComponent[]{emptyComponent};
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String string) {
        return Enum.valueOf(EmptyComponent.class, string);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[])$VALUES.clone();
    }

    public void cancel() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(Disposable disposable) {
        disposable.dispose();
    }

    public void onSubscribe(Subscription subscription) {
        subscription.cancel();
    }

    public void onSuccess(Object object) {
    }

    public void request(long l) {
    }
}
