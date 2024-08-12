/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.view.CameraController
 *  androidx.camera.view.SensorRotationListener
 */
package androidx.camera.view;

import android.content.Context;
import androidx.camera.view.CameraController;
import androidx.camera.view.SensorRotationListener;

class CameraController.1
extends SensorRotationListener {
    final CameraController this$0;

    CameraController.1(CameraController cameraController, Context context) {
        this.this$0 = cameraController;
        super(context);
    }

    public void onRotationChanged(int n) {
        this.this$0.mImageCapture.setTargetRotation(n);
        this.this$0.mVideoCapture.setTargetRotation(n);
    }
}
