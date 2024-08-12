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

class ComponentActivity.3
implements LifecycleEventObserver {
    final ComponentActivity this$0;

    ComponentActivity.3(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_STOP) return;
        object = this.this$0.getWindow();
        object = object != null ? object.peekDecorView() : null;
        if (object == null) return;
        object.cancelPendingInputEvents();
    }
}
