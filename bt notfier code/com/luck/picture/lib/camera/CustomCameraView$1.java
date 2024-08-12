/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.camera.CustomCameraView
 */
package com.luck.picture.lib.camera;

import android.view.View;
import com.luck.picture.lib.camera.CustomCameraView;

class CustomCameraView.1
implements View.OnClickListener {
    final CustomCameraView this$0;

    CustomCameraView.1(CustomCameraView customCameraView) {
        this.this$0 = customCameraView;
    }

    public void onClick(View view) {
        this.this$0.toggleCamera();
    }
}
