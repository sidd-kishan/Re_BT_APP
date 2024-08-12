/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.camera.CustomCameraView
 *  com.luck.picture.lib.camera.listener.ClickListener
 */
package com.luck.picture.lib.camera;

import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.listener.ClickListener;

/*
 * Exception performing whole class analysis ignored.
 */
class CustomCameraView.4
implements ClickListener {
    final CustomCameraView this$0;

    CustomCameraView.4(CustomCameraView customCameraView) {
        this.this$0 = customCameraView;
    }

    public void onClick() {
        if (CustomCameraView.access$1600((CustomCameraView)this.this$0) == null) return;
        CustomCameraView.access$1600((CustomCameraView)this.this$0).onClick();
    }
}
