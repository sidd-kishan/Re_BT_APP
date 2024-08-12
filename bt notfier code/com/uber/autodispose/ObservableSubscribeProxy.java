/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observers.TestObserver
 */
package com.uber.autodispose;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

public interface ObservableSubscribeProxy<T> {
    public Disposable subscribe();

    public Disposable subscribe(Consumer<? super T> var1);

    public Disposable subscribe(Consumer<? super T> var1, Consumer<? super Throwable> var2);

    public Disposable subscribe(Consumer<? super T> var1, Consumer<? super Throwable> var2, Action var3);

    public Disposable subscribe(Consumer<? super T> var1, Consumer<? super Throwable> var2, Action var3, Consumer<? super Disposable> var4);

    public void subscribe(Observer<? super T> var1);

    @CheckReturnValue
    public <E extends Observer<? super T>> E subscribeWith(E var1);

    @CheckReturnValue
    public TestObserver<T> test();

    @CheckReturnValue
    public TestObserver<T> test(boolean var1);
}
