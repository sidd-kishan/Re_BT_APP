/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcelable
 *  android.util.Log
 *  com.luck.picture.lib.PictureCustomCameraActivity
 *  com.luck.picture.lib.camera.listener.CameraListener
 *  com.luck.picture.lib.config.PictureMimeType
 */
package com.luck.picture.lib;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import com.luck.picture.lib.PictureCustomCameraActivity;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureCustomCameraActivity.1
implements CameraListener {
    final PictureCustomCameraActivity this$0;

    PictureCustomCameraActivity.1(PictureCustomCameraActivity pictureCustomCameraActivity) {
        this.this$0 = pictureCustomCameraActivity;
    }

    public void onError(int n, String string, Throwable serializable) {
        String string2 = PictureCustomCameraActivity.access$000();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("onError: ");
        ((StringBuilder)serializable).append(string);
        Log.i((String)string2, (String)((StringBuilder)serializable).toString());
    }

    public void onPictureSuccess(File file) {
        this.this$0.config.cameraMimeType = PictureMimeType.ofImage();
        Intent intent = new Intent();
        intent.putExtra("mediaPath", file.getAbsolutePath());
        intent.putExtra("PictureSelectorConfig", (Parcelable)this.this$0.config);
        if (this.this$0.config.camera) {
            this.this$0.dispatchHandleCamera(intent);
        } else {
            this.this$0.setResult(-1, intent);
            this.this$0.onBackPressed();
        }
    }

    public void onRecordSuccess(File file) {
        this.this$0.config.cameraMimeType = PictureMimeType.ofVideo();
        Intent intent = new Intent();
        intent.putExtra("mediaPath", file.getAbsolutePath());
        intent.putExtra("PictureSelectorConfig", (Parcelable)this.this$0.config);
        if (this.this$0.config.camera) {
            this.this$0.dispatchHandleCamera(intent);
        } else {
            this.this$0.setResult(-1, intent);
            this.this$0.onBackPressed();
        }
    }
}
