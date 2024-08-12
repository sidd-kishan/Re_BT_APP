/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.TextureView$SurfaceTextureListener
 *  com.luck.picture.lib.camera.CustomCameraView
 */
package com.luck.picture.lib.camera;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.luck.picture.lib.camera.CustomCameraView;
import java.io.File;

/*
 * Exception performing whole class analysis ignored.
 */
class CustomCameraView.5
implements TextureView.SurfaceTextureListener {
    final CustomCameraView this$0;

    CustomCameraView.5(CustomCameraView customCameraView) {
        this.this$0 = customCameraView;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n, int n2) {
        surfaceTexture = this.this$0;
        CustomCameraView.access$1200((CustomCameraView)surfaceTexture, (File)CustomCameraView.access$000((CustomCameraView)surfaceTexture));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n, int n2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
