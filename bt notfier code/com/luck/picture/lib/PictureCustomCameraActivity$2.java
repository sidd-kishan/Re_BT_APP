/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.camera.listener.ClickListener
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.camera.listener.ClickListener;

class PictureCustomCameraActivity.2
implements ClickListener {
    final PictureCustomCameraActivity this$0;

    PictureCustomCameraActivity.2(PictureCustomCameraActivity pictureCustomCameraActivity) {
        this.this$0 = pictureCustomCameraActivity;
    }

    public void onClick() {
        this.this$0.onBackPressed();
    }
}
