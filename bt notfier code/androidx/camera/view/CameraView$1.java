/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.display.DisplayManager$DisplayListener
 *  androidx.camera.view.CameraView
 */
package androidx.camera.view;

import android.hardware.display.DisplayManager;
import androidx.camera.view.CameraView;

class CameraView.1
implements DisplayManager.DisplayListener {
    final CameraView this$0;

    CameraView.1(CameraView cameraView) {
        this.this$0 = cameraView;
    }

    public void onDisplayAdded(int n) {
    }

    public void onDisplayChanged(int n) {
        this.this$0.mCameraModule.invalidateView();
    }

    public void onDisplayRemoved(int n) {
    }
}
