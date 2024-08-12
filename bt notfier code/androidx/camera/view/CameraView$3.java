/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.FocusMeteringResult
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.view.CameraView
 */
package androidx.camera.view;

import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.CameraView;

class CameraView.3
implements FutureCallback<FocusMeteringResult> {
    final CameraView this$0;

    CameraView.3(CameraView cameraView) {
        this.this$0 = cameraView;
    }

    public void onFailure(Throwable throwable) {
        throw new RuntimeException(throwable);
    }

    public void onSuccess(FocusMeteringResult focusMeteringResult) {
    }
}
