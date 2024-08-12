/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.ComponentActivity
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

class ComponentActivity.5
implements LifecycleEventObserver {
    final ComponentActivity this$0;

    ComponentActivity.5(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.this$0.ensureViewModelStore();
        this.this$0.getLifecycle().removeObserver((LifecycleObserver)this);
    }
}
