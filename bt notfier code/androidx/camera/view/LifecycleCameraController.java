/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  androidx.camera.core.Camera
 *  androidx.camera.core.UseCaseGroup
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.view.CameraController
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.camera.view;

import android.content.Context;
import android.util.Log;
import androidx.camera.core.Camera;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.CameraController;
import androidx.lifecycle.LifecycleOwner;

public final class LifecycleCameraController
extends CameraController {
    private static final String TAG = "CamLifecycleController";
    private LifecycleOwner mLifecycleOwner;

    public LifecycleCameraController(Context context) {
        super(context);
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        Threads.checkMainThread();
        this.mLifecycleOwner = lifecycleOwner;
        this.startCameraAndTrackStates();
    }

    void shutDownForTests() {
        if (this.mCameraProvider == null) return;
        this.mCameraProvider.unbindAll();
        this.mCameraProvider.shutdown();
    }

    Camera startCamera() {
        if (this.mLifecycleOwner == null) {
            Log.d((String)TAG, (String)"Lifecycle is not set.");
            return null;
        }
        if (this.mCameraProvider == null) {
            Log.d((String)TAG, (String)"CameraProvider is not ready.");
            return null;
        }
        UseCaseGroup useCaseGroup = this.createUseCaseGroup();
        if (useCaseGroup != null) return this.mCameraProvider.bindToLifecycle(this.mLifecycleOwner, this.mCameraSelector, useCaseGroup);
        return null;
    }

    public void unbind() {
        Threads.checkMainThread();
        this.mLifecycleOwner = null;
        this.mCamera = null;
        if (this.mCameraProvider == null) return;
        this.mCameraProvider.unbindAll();
    }
}
