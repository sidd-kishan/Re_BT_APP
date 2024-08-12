/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.utils.GlideEngine
 *  com.luck.picture.lib.PictureSelector
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.engine.ImageEngine
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.lianhezhuli.btnotification.base;

import android.app.Activity;
import android.content.Intent;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.utils.GlideEngine;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

public abstract class BasePictureActivity
extends BaseActivity {
    public void camera() {
        PictureSelector.create((Activity)this).openCamera(PictureMimeType.ofImage()).isEnableCrop(true).imageEngine((ImageEngine)GlideEngine.createGlideEngine()).cropImageWideHigh(300, 300).scaleEnabled(true).freeStyleCropEnabled(true).withAspectRatio(1, 1).forResult(188);
    }

    public void gallery() {
        PictureSelector.create((Activity)this).openGallery(PictureMimeType.ofImage()).isCamera(false).isEnableCrop(true).imageEngine((ImageEngine)GlideEngine.createGlideEngine()).rotateEnabled(true).cropImageWideHigh(300, 300).scaleEnabled(true).selectionMode(1).freeStyleCropEnabled(true).withAspectRatio(1, 1).forResult(188);
    }

    public void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n2 != -1) return;
        this.onImageSelect(PictureSelector.obtainMultipleResult((Intent)intent));
    }

    protected abstract void onImageSelect(List<LocalMedia> var1);
}
