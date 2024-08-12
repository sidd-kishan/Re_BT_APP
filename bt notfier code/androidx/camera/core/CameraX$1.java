/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraX
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import androidx.camera.core.CameraX;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
class CameraX.1
implements FutureCallback<Void> {
    final CameraX val$cameraX;
    final CallbackToFutureAdapter.Completer val$completer;

    CameraX.1(CallbackToFutureAdapter.Completer completer, CameraX cameraX) {
        this.val$completer = completer;
        this.val$cameraX = cameraX;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onFailure(Throwable throwable) {
        Logger.w((String)"CameraX", (String)"CameraX initialize() failed", (Throwable)throwable);
        Object object = CameraX.INSTANCE_LOCK;
        synchronized (object) {
            if (CameraX.sInstance == this.val$cameraX) {
                CameraX.shutdownLocked();
            }
        }
        this.val$completer.setException(throwable);
    }

    public void onSuccess(Void void_) {
        this.val$completer.set(null);
    }
}
