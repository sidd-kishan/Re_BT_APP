/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.listener.OnPermissionDialogOptionCallback
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.listener.OnPermissionDialogOptionCallback;

class PictureSelectorActivity.7
implements OnPermissionDialogOptionCallback {
    final PictureSelectorActivity this$0;

    PictureSelectorActivity.7(PictureSelectorActivity pictureSelectorActivity) {
        this.this$0 = pictureSelectorActivity;
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
