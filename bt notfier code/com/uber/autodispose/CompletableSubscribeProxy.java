/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observers.TestObserver
 */
package com.uber.autodispose;

import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

public interface CompletableSubscribeProxy {
    public Disposable subscribe();

    public Disposable subscribe(Action var1);

    public Disposable subscribe(Action var1, Consumer<? super Throwable> var2);

    public void subscribe(CompletableObserver var1);

    @CheckReturnValue
    public <E extends CompletableObserver> E subscribeWith(E var1);

    @CheckReturnValue
    public TestObserver<Void> test();

    @CheckReturnValue
    public TestObserver<Void> test(boolean var1);
}
