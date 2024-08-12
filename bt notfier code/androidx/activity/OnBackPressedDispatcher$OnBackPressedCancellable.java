/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.Cancellable
 *  androidx.activity.OnBackPressedCallback
 *  androidx.activity.OnBackPressedDispatcher
 */
package androidx.activity;

import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;

private class OnBackPressedDispatcher.OnBackPressedCancellable
implements Cancellable {
    private final OnBackPressedCallback mOnBackPressedCallback;
    final OnBackPressedDispatcher this$0;

    OnBackPressedDispatcher.OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
        this.this$0 = onBackPressedDispatcher;
        this.mOnBackPressedCallback = onBackPressedCallback;
    }

    public void cancel() {
        this.this$0.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
        this.mOnBackPressedCallback.removeCancellable((Cancellable)this);
    }
}
