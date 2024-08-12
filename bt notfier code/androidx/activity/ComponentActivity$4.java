/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.ComponentActivity
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class ComponentActivity.4
implements LifecycleEventObserver {
    final ComponentActivity this$0;

    ComponentActivity.4(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) return;
        this.this$0.mContextAwareHelper.clearAvailableContext();
        if (this.this$0.isChangingConfigurations()) return;
        this.this$0.getViewModelStore().clear();
    }
}
