/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose.observers;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public interface AutoDisposingMaybeObserver<T>
extends MaybeObserver<T>,
Disposable {
    public MaybeObserver<? super T> delegateObserver();
}
