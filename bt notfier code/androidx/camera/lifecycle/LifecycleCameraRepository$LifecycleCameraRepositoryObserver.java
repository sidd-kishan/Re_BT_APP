/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.lifecycle.LifecycleCameraRepository
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.OnLifecycleEvent
 */
package androidx.camera.lifecycle;

import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

private static class LifecycleCameraRepository.LifecycleCameraRepositoryObserver
implements LifecycleObserver {
    private final LifecycleCameraRepository mLifecycleCameraRepository;
    private final LifecycleOwner mLifecycleOwner;

    LifecycleCameraRepository.LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, LifecycleCameraRepository lifecycleCameraRepository) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLifecycleCameraRepository = lifecycleCameraRepository;
    }

    LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.unregisterLifecycle(lifecycleOwner);
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.setActive(lifecycleOwner);
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.setInactive(lifecycleOwner);
    }
}
