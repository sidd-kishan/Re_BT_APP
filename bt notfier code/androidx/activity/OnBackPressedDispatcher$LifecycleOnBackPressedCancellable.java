/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.Cancellable
 *  androidx.activity.OnBackPressedCallback
 *  androidx.activity.OnBackPressedDispatcher
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.activity;

import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

private class OnBackPressedDispatcher.LifecycleOnBackPressedCancellable
implements LifecycleEventObserver,
Cancellable {
    private Cancellable mCurrentCancellable;
    private final Lifecycle mLifecycle;
    private final OnBackPressedCallback mOnBackPressedCallback;
    final OnBackPressedDispatcher this$0;

    OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
        this.this$0 = onBackPressedDispatcher;
        this.mLifecycle = lifecycle;
        this.mOnBackPressedCallback = onBackPressedCallback;
        lifecycle.addObserver((LifecycleObserver)this);
    }

    public void cancel() {
        this.mLifecycle.removeObserver((LifecycleObserver)this);
        this.mOnBackPressedCallback.removeCancellable((Cancellable)this);
        Cancellable cancellable = this.mCurrentCancellable;
        if (cancellable == null) return;
        cancellable.cancel();
        this.mCurrentCancellable = null;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            this.mCurrentCancellable = this.this$0.addCancellableCallback(this.mOnBackPressedCallback);
        } else if (event == Lifecycle.Event.ON_STOP) {
            lifecycleOwner = this.mCurrentCancellable;
            if (lifecycleOwner == null) return;
            lifecycleOwner.cancel();
        } else {
            if (event != Lifecycle.Event.ON_DESTROY) return;
            this.cancel();
        }
    }
}
