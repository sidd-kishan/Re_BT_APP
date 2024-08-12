/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.Fragment
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class Fragment.5
implements LifecycleEventObserver {
    final Fragment this$0;

    Fragment.5(Fragment fragment) {
        this.this$0 = fragment;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_STOP) return;
        if (this.this$0.mView == null) return;
        this.this$0.mView.cancelPendingInputEvents();
    }
}
