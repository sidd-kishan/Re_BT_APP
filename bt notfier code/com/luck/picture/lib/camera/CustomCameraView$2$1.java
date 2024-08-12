/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.video.OnVideoSavedCallback
 *  androidx.camera.view.video.OutputFileResults
 *  com.luck.picture.lib.camera.CustomCameraView
 *  com.luck.picture.lib.camera.CustomCameraView$2
 */
package com.luck.picture.lib.camera;

import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileResults;
import com.luck.picture.lib.camera.CustomCameraView;
import java.io.File;

/*
 * Exception performing whole class analysis ignored.
 */
class CustomCameraView.1
implements OnVideoSavedCallback {
    final CustomCameraView.2 this$1;

    CustomCameraView.1(CustomCameraView.2 var1_1) {
        this.this$1 = var1_1;
    }

    public void onError(int n, String string, Throwable throwable) {
        if (CustomCameraView.access$700((CustomCameraView)this.this$1.this$0) == null) return;
        CustomCameraView.access$700((CustomCameraView)this.this$1.this$0).onError(n, string, throwable);
    }

    public void onVideoSaved(OutputFileResults outputFileResults) {
        long l = CustomCameraView.access$800((CustomCameraView)this.this$1.this$0).recordVideoMinSecond <= 0 ? 1500L : (long)(CustomCameraView.access$800((CustomCameraView)this.this$1.this$0).recordVideoMinSecond * 1000);
        if (CustomCameraView.access$900((CustomCameraView)this.this$1.this$0) < l && CustomCameraView.access$000((CustomCameraView)this.this$1.this$0).exists() && CustomCameraView.access$000((CustomCameraView)this.this$1.this$0).delete()) {
            return;
        }
        CustomCameraView.access$1000((CustomCameraView)this.this$1.this$0).setVisibility(0);
        CustomCameraView.access$1100((CustomCameraView)this.this$1.this$0).setVisibility(4);
        if (CustomCameraView.access$1000((CustomCameraView)this.this$1.this$0).isAvailable()) {
            CustomCameraView.access$1200((CustomCameraView)this.this$1.this$0, (File)CustomCameraView.access$000((CustomCameraView)this.this$1.this$0));
        } else {
            CustomCameraView.access$1000((CustomCameraView)this.this$1.this$0).setSurfaceTextureListener(CustomCameraView.access$1300((CustomCameraView)this.this$1.this$0));
        }
    }
}
