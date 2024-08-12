/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureCallbacks$NoOpCameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureFailure
 *  androidx.camera.core.impl.CameraCaptureResult
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public static final class CameraCaptureCallbacks.ComboCameraCaptureCallback
extends CameraCaptureCallback {
    private final List<CameraCaptureCallback> mCallbacks = new ArrayList<CameraCaptureCallback>();

    CameraCaptureCallbacks.ComboCameraCaptureCallback(List<CameraCaptureCallback> object) {
        object = object.iterator();
        while (object.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)object.next();
            if (cameraCaptureCallback instanceof CameraCaptureCallbacks.NoOpCameraCaptureCallback) continue;
            this.mCallbacks.add(cameraCaptureCallback);
        }
    }

    public List<CameraCaptureCallback> getCallbacks() {
        return this.mCallbacks;
    }

    public void onCaptureCancelled() {
        Iterator<CameraCaptureCallback> iterator = this.mCallbacks.iterator();
        while (iterator.hasNext()) {
            iterator.next().onCaptureCancelled();
        }
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        Iterator<CameraCaptureCallback> iterator = this.mCallbacks.iterator();
        while (iterator.hasNext()) {
            iterator.next().onCaptureCompleted(cameraCaptureResult);
        }
    }

    public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
        Iterator<CameraCaptureCallback> iterator = this.mCallbacks.iterator();
        while (iterator.hasNext()) {
            iterator.next().onCaptureFailed(cameraCaptureFailure);
        }
    }
}
