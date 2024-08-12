/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.Cancellable
 *  androidx.activity.OnBackPressedCallback
 *  androidx.activity.OnBackPressedDispatcher$LifecycleOnBackPressedCancellable
 *  androidx.activity.OnBackPressedDispatcher$OnBackPressedCancellable
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.activity;

import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {
    private final Runnable mFallbackOnBackPressed;
    final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks = new ArrayDeque();

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.mFallbackOnBackPressed = runnable;
    }

    public void addCallback(OnBackPressedCallback onBackPressedCallback) {
        this.addCancellableCallback(onBackPressedCallback);
    }

    public void addCallback(LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback) {
        if ((lifecycleOwner = lifecycleOwner.getLifecycle()).getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable((Cancellable)new LifecycleOnBackPressedCancellable(this, (Lifecycle)lifecycleOwner, onBackPressedCallback));
    }

    Cancellable addCancellableCallback(OnBackPressedCallback onBackPressedCallback) {
        this.mOnBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable((Cancellable)onBackPressedCancellable);
        return onBackPressedCancellable;
    }

    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> iterator = this.mOnBackPressedCallbacks.descendingIterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!iterator.next().isEnabled());
        return true;
    }

    public void onBackPressed() {
        OnBackPressedCallback onBackPressedCallback;
        Object object = this.mOnBackPressedCallbacks.descendingIterator();
        do {
            if (object.hasNext()) continue;
            object = this.mFallbackOnBackPressed;
            if (object == null) return;
            object.run();
            return;
        } while (!(onBackPressedCallback = object.next()).isEnabled());
        onBackPressedCallback.handleOnBackPressed();
    }
}
