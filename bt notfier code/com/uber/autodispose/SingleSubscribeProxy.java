/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observers.TestObserver
 */
package com.uber.autodispose;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

public interface SingleSubscribeProxy<T> {
    public Disposable subscribe();

    public Disposable subscribe(BiConsumer<? super T, ? super Throwable> var1);

    public Disposable subscribe(Consumer<? super T> var1);

    public Disposable subscribe(Consumer<? super T> var1, Consumer<? super Throwable> var2);

    public void subscribe(SingleObserver<? super T> var1);

    @CheckReturnValue
    public <E extends SingleObserver<? super T>> E subscribeWith(E var1);

    @CheckReturnValue
    public TestObserver<T> test();

    @CheckReturnValue
    public TestObserver<T> test(boolean var1);
}
