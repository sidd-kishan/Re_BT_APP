/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Camera
 *  androidx.camera.core.CameraControl
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.internal.CameraUseCaseAdapter
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraException
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.OnLifecycleEvent
 */
package androidx.camera.lifecycle;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

final class LifecycleCamera
implements LifecycleObserver,
Camera {
    private final CameraUseCaseAdapter mCameraUseCaseAdapter;
    private volatile boolean mIsActive = false;
    private final LifecycleOwner mLifecycleOwner;
    private final Object mLock = new Object();
    private boolean mReleased = false;
    private boolean mSuspended = false;

    LifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mCameraUseCaseAdapter = cameraUseCaseAdapter;
        if (lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            this.mCameraUseCaseAdapter.attachUseCases();
        } else {
            this.mCameraUseCaseAdapter.detachUseCases();
        }
        lifecycleOwner.getLifecycle().addObserver((LifecycleObserver)this);
    }

    void bind(Collection<UseCase> collection) throws CameraUseCaseAdapter.CameraException {
        Object object = this.mLock;
        synchronized (object) {
            this.mCameraUseCaseAdapter.addUseCases(collection);
            return;
        }
    }

    public CameraControl getCameraControl() {
        return this.mCameraUseCaseAdapter.getCameraControl();
    }

    public CameraInfo getCameraInfo() {
        return this.mCameraUseCaseAdapter.getCameraInfo();
    }

    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraUseCaseAdapter.getCameraInternals();
    }

    public CameraUseCaseAdapter getCameraUseCaseAdapter() {
        return this.mCameraUseCaseAdapter;
    }

    public CameraConfig getExtendedConfig() {
        return this.mCameraUseCaseAdapter.getExtendedConfig();
    }

    public LifecycleOwner getLifecycleOwner() {
        Object object = this.mLock;
        synchronized (object) {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            return lifecycleOwner;
        }
    }

    public List<UseCase> getUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            List<UseCase> list = Collections.unmodifiableList(this.mCameraUseCaseAdapter.getUseCases());
            return list;
        }
    }

    public boolean isActive() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = this.mIsActive;
            return bl;
        }
    }

    public boolean isBound(UseCase useCase) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = this.mCameraUseCaseAdapter.getUseCases().contains(useCase);
            return bl;
        }
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            this.mCameraUseCaseAdapter.removeUseCases((Collection)this.mCameraUseCaseAdapter.getUseCases());
            return;
        }
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner object) {
        object = this.mLock;
        synchronized (object) {
            if (this.mSuspended) return;
            if (this.mReleased) return;
            this.mCameraUseCaseAdapter.attachUseCases();
            this.mIsActive = true;
            return;
        }
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner object) {
        object = this.mLock;
        synchronized (object) {
            if (this.mSuspended) return;
            if (this.mReleased) return;
            this.mCameraUseCaseAdapter.detachUseCases();
            this.mIsActive = false;
            return;
        }
    }

    void release() {
        Object object = this.mLock;
        synchronized (object) {
            this.mReleased = true;
            this.mIsActive = false;
            this.mLifecycleOwner.getLifecycle().removeObserver((LifecycleObserver)this);
            return;
        }
    }

    public void setExtendedConfig(CameraConfig cameraConfig) throws CameraUseCaseAdapter.CameraException {
        this.mCameraUseCaseAdapter.setExtendedConfig(cameraConfig);
    }

    public void suspend() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mSuspended) {
                return;
            }
            this.onStop(this.mLifecycleOwner);
            this.mSuspended = true;
            return;
        }
    }

    void unbind(Collection<UseCase> collection) {
        Object object = this.mLock;
        synchronized (object) {
            ArrayList<UseCase> arrayList = new ArrayList<UseCase>(collection);
            arrayList.retainAll(this.mCameraUseCaseAdapter.getUseCases());
            this.mCameraUseCaseAdapter.removeUseCases(arrayList);
            return;
        }
    }

    void unbindAll() {
        Object object = this.mLock;
        synchronized (object) {
            this.mCameraUseCaseAdapter.removeUseCases((Collection)this.mCameraUseCaseAdapter.getUseCases());
            return;
        }
    }

    public void unsuspend() {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.mSuspended) {
                return;
            }
            this.mSuspended = false;
            if (!this.mLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) return;
            this.onStart(this.mLifecycleOwner);
            return;
        }
    }
}
