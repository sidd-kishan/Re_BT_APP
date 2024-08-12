/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.listener.OnPermissionDialogOptionCallback
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.listener.OnPermissionDialogOptionCallback;

class PictureCustomCameraActivity.3
implements OnPermissionDialogOptionCallback {
    final PictureCustomCameraActivity this$0;

    PictureCustomCameraActivity.3(PictureCustomCameraActivity pictureCustomCameraActivity) {
        this.this$0 = pictureCustomCameraActivity;
    }

    public void onCancel() {
        if (PictureSelectionConfig.listener != null) {
            PictureSelectionConfig.listener.onCancel();
        }
        this.this$0.exit();
    }

    public void onSetting() {
        this.this$0.isEnterSetting = true;
    }
}
