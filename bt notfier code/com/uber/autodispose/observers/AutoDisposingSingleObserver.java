/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public interface AutoDisposingSingleObserver<T>
extends SingleObserver<T>,
Disposable {
    public SingleObserver<? super T> delegateObserver();
}
