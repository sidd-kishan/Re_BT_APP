/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.camera.listener.ImageCallbackListener
 */
package com.luck.picture.lib;

import android.widget.ImageView;
import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import java.io.File;

public final class _$$Lambda$PictureCustomCameraActivity$IsPjvXD_XOh7qOaPNJfnKp6ymRg
implements ImageCallbackListener {
    private final PictureCustomCameraActivity f$0;

    public /* synthetic */ _$$Lambda$PictureCustomCameraActivity$IsPjvXD_XOh7qOaPNJfnKp6ymRg(PictureCustomCameraActivity pictureCustomCameraActivity) {
        this.f$0 = pictureCustomCameraActivity;
    }

    public final void onLoadImage(File file, ImageView imageView) {
        this.f$0.lambda$initView$0$PictureCustomCameraActivity(file, imageView);
    }
}
