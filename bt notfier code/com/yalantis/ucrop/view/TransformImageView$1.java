/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Log
 *  com.yalantis.ucrop.callback.BitmapLoadCallback
 *  com.yalantis.ucrop.model.ExifInfo
 *  com.yalantis.ucrop.view.TransformImageView
 */
package com.yalantis.ucrop.view;

import android.graphics.Bitmap;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.view.TransformImageView;

/*
 * Exception performing whole class analysis ignored.
 */
class TransformImageView.1
implements BitmapLoadCallback {
    final TransformImageView this$0;

    TransformImageView.1(TransformImageView transformImageView) {
        this.this$0 = transformImageView;
    }

    public void onBitmapLoaded(Bitmap bitmap, ExifInfo exifInfo, String string, String string2) {
        TransformImageView.access$002((TransformImageView)this.this$0, (String)string);
        TransformImageView.access$102((TransformImageView)this.this$0, (String)string2);
        TransformImageView.access$202((TransformImageView)this.this$0, (ExifInfo)exifInfo);
        this.this$0.mBitmapDecoded = true;
        this.this$0.setImageBitmap(bitmap);
    }

    public void onFailure(Exception exception) {
        Log.e((String)"TransformImageView", (String)"onFailure: setImageUri", (Throwable)exception);
        if (this.this$0.mTransformImageListener == null) return;
        this.this$0.mTransformImageListener.onLoadFailure(exception);
    }
}
