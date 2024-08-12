/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.lifecycle.ProcessCameraProvider
 *  androidx.camera.view.CameraXModule
 *  androidx.core.util.Preconditions
 */
package androidx.camera.view;

import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraXModule;
import androidx.core.util.Preconditions;

class CameraXModule.2
implements FutureCallback<ProcessCameraProvider> {
    final CameraXModule this$0;

    CameraXModule.2(CameraXModule cameraXModule) {
        this.this$0 = cameraXModule;
    }

    public void onFailure(Throwable throwable) {
        throw new RuntimeException("CameraX failed to initialize.", throwable);
    }

    public void onSuccess(ProcessCameraProvider processCameraProvider) {
        Preconditions.checkNotNull((Object)processCameraProvider);
        this.this$0.mCameraProvider = processCameraProvider;
        if (this.this$0.mCurrentLifecycle == null) return;
        processCameraProvider = this.this$0;
        processCameraProvider.bindToLifecycle(processCameraProvider.mCurrentLifecycle);
    }
}
