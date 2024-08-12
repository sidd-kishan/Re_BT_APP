/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  io.reactivex.CompletableObserver
 *  io.reactivex.android.MainThreadDisposable
 */
package com.uber.autodispose.android;

import android.view.View;
import io.reactivex.CompletableObserver;
import io.reactivex.android.MainThreadDisposable;

static final class DetachEventCompletable.Listener
extends MainThreadDisposable
implements View.OnAttachStateChangeListener {
    private final CompletableObserver observer;
    private final View view;

    DetachEventCompletable.Listener(View view, CompletableObserver completableObserver) {
        this.view = view;
        this.observer = completableObserver;
    }

    protected void onDispose() {
        this.view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        if (this.isDisposed()) return;
        this.observer.onComplete();
    }
}
