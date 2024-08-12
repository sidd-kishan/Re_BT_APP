/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.camera.CustomCameraView
 *  com.luck.picture.lib.camera.listener.TypeListener
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 *  com.luck.picture.lib.tools.SdkVersionUtils
 */
package com.luck.picture.lib.camera;

import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.listener.TypeListener;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class CustomCameraView.3
implements TypeListener {
    final CustomCameraView this$0;

    CustomCameraView.3(CustomCameraView customCameraView) {
        this.this$0 = customCameraView;
    }

    public void cancel() {
        CustomCameraView.access$1400((CustomCameraView)this.this$0);
        CustomCameraView.access$1500((CustomCameraView)this.this$0);
    }

    public void confirm() {
        if (CustomCameraView.access$000((CustomCameraView)this.this$0) == null) return;
        if (!CustomCameraView.access$000((CustomCameraView)this.this$0).exists()) return;
        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent((String)CustomCameraView.access$800((CustomCameraView)this.this$0).cameraPath)) {
            PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
        } else if (CustomCameraView.access$400((CustomCameraView)this.this$0).isImageCaptureEnabled()) {
            CustomCameraView.access$500((CustomCameraView)this.this$0).setVisibility(4);
            if (CustomCameraView.access$700((CustomCameraView)this.this$0) == null) return;
            CustomCameraView.access$700((CustomCameraView)this.this$0).onPictureSuccess(CustomCameraView.access$000((CustomCameraView)this.this$0));
        } else {
            CustomCameraView.access$1400((CustomCameraView)this.this$0);
            if (CustomCameraView.access$700((CustomCameraView)this.this$0) == null) {
                if (CustomCameraView.access$000((CustomCameraView)this.this$0).exists()) return;
            }
            CustomCameraView.access$700((CustomCameraView)this.this$0).onRecordSuccess(CustomCameraView.access$000((CustomCameraView)this.this$0));
        }
    }
}
