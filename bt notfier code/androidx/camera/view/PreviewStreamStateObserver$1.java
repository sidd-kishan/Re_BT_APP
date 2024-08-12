/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.view.PreviewStreamStateObserver
 */
package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.PreviewStreamStateObserver;
import java.util.List;

class PreviewStreamStateObserver.1
implements FutureCallback<Void> {
    final PreviewStreamStateObserver this$0;
    final List val$callbacksToClear;
    final CameraInfo val$cameraInfo;

    PreviewStreamStateObserver.1(PreviewStreamStateObserver previewStreamStateObserver, List list, CameraInfo cameraInfo) {
        this.this$0 = previewStreamStateObserver;
        this.val$callbacksToClear = list;
        this.val$cameraInfo = cameraInfo;
    }

    public void onFailure(Throwable object) {
        this.this$0.mFlowFuture = null;
        if (this.val$callbacksToClear.isEmpty()) return;
        object = this.val$callbacksToClear.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.val$callbacksToClear.clear();
                return;
            }
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)object.next();
            ((CameraInfoInternal)this.val$cameraInfo).removeSessionCaptureCallback(cameraCaptureCallback);
        }
    }

    public void onSuccess(Void void_) {
        this.this$0.mFlowFuture = null;
    }
}
