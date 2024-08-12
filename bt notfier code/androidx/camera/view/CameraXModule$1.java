/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.CameraXModule
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.OnLifecycleEvent
 */
package androidx.camera.view;

import androidx.camera.view.CameraXModule;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

class CameraXModule.1
implements LifecycleObserver {
    final CameraXModule this$0;

    CameraXModule.1(CameraXModule cameraXModule) {
        this.this$0 = cameraXModule;
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.this$0.mCurrentLifecycle) return;
        this.this$0.clearCurrentLifecycle();
    }
}
