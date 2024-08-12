/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public interface AutoDisposingCompletableObserver
extends CompletableObserver,
Disposable {
    public CompletableObserver delegateObserver();
}
