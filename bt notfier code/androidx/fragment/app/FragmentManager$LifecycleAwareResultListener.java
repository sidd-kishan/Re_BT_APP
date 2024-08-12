/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.fragment.app.FragmentResultListener
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;

private static class FragmentManager.LifecycleAwareResultListener
implements FragmentResultListener {
    private final Lifecycle mLifecycle;
    private final FragmentResultListener mListener;
    private final LifecycleEventObserver mObserver;

    FragmentManager.LifecycleAwareResultListener(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle = lifecycle;
        this.mListener = fragmentResultListener;
        this.mObserver = lifecycleEventObserver;
    }

    public boolean isAtLeast(Lifecycle.State state) {
        return this.mLifecycle.getCurrentState().isAtLeast(state);
    }

    public void onFragmentResult(String string, Bundle bundle) {
        this.mListener.onFragmentResult(string, bundle);
    }

    public void removeObserver() {
        this.mLifecycle.removeObserver((LifecycleObserver)this.mObserver);
    }
}
