/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.display.DisplayManager$DisplayListener
 *  androidx.camera.view.CameraController
 */
package androidx.camera.view;

import android.hardware.display.DisplayManager;
import androidx.camera.view.CameraController;

class CameraController.DisplayRotationListener
implements DisplayManager.DisplayListener {
    final CameraController this$0;

    CameraController.DisplayRotationListener(CameraController cameraController) {
        this.this$0 = cameraController;
    }

    public void onDisplayAdded(int n) {
    }

    public void onDisplayChanged(int n) {
        if (this.this$0.mPreviewDisplay == null) return;
        if (this.this$0.mPreviewDisplay.getDisplayId() != n) return;
        this.this$0.mPreview.setTargetRotation(this.this$0.mPreviewDisplay.getRotation());
    }

    public void onDisplayRemoved(int n) {
    }
}
