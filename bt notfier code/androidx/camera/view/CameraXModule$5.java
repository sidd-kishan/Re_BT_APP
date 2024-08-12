/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.view.CameraXModule
 */
package androidx.camera.view;

import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.CameraXModule;

class CameraXModule.5
implements FutureCallback<Void> {
    final CameraXModule this$0;

    CameraXModule.5(CameraXModule cameraXModule) {
        this.this$0 = cameraXModule;
    }

    public void onFailure(Throwable throwable) {
        throw new RuntimeException(throwable);
    }

    public void onSuccess(Void void_) {
    }
}
