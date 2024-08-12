/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public interface AutoDisposingObserver<T>
extends Observer<T>,
Disposable {
    public Observer<? super T> delegateObserver();
}
