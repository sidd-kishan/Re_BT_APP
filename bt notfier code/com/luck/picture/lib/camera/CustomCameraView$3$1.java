/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.luck.picture.lib.camera.CustomCameraView
 *  com.luck.picture.lib.camera.CustomCameraView$3
 *  com.luck.picture.lib.thread.PictureThreadUtils$SimpleTask
 *  com.luck.picture.lib.tools.AndroidQTransformUtils
 */
package com.luck.picture.lib.camera;

import android.content.Context;
import android.net.Uri;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import java.io.File;

/*
 * Exception performing whole class analysis ignored.
 */
class CustomCameraView.1
extends PictureThreadUtils.SimpleTask<Boolean> {
    final CustomCameraView.3 this$1;

    CustomCameraView.1(CustomCameraView.3 var1_1) {
        this.this$1 = var1_1;
    }

    public Boolean doInBackground() {
        return AndroidQTransformUtils.copyPathToDCIM((Context)this.this$1.this$0.getContext(), (File)CustomCameraView.access$000((CustomCameraView)this.this$1.this$0), (Uri)Uri.parse((String)CustomCameraView.access$800((CustomCameraView)this.this$1.this$0).cameraPath));
    }

    public void onSuccess(Boolean bl) {
        if (CustomCameraView.access$400((CustomCameraView)this.this$1.this$0).isImageCaptureEnabled()) {
            CustomCameraView.access$500((CustomCameraView)this.this$1.this$0).setVisibility(4);
            if (CustomCameraView.access$700((CustomCameraView)this.this$1.this$0) == null) return;
            CustomCameraView.access$700((CustomCameraView)this.this$1.this$0).onPictureSuccess(CustomCameraView.access$000((CustomCameraView)this.this$1.this$0));
        } else {
            CustomCameraView.access$1400((CustomCameraView)this.this$1.this$0);
            if (CustomCameraView.access$700((CustomCameraView)this.this$1.this$0) == null) {
                if (CustomCameraView.access$000((CustomCameraView)this.this$1.this$0).exists()) return;
            }
            CustomCameraView.access$700((CustomCameraView)this.this$1.this$0).onRecordSuccess(CustomCameraView.access$000((CustomCameraView)this.this$1.this$0));
        }
    }
}
