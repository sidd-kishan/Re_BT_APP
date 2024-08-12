/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.yalantis.ucrop.model.ExifInfo
 */
package com.yalantis.ucrop.task;

import android.graphics.Bitmap;
import com.yalantis.ucrop.model.ExifInfo;

public static class BitmapLoadTask.BitmapWorkerResult {
    Bitmap mBitmapResult;
    Exception mBitmapWorkerException;
    ExifInfo mExifInfo;

    public BitmapLoadTask.BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
        this.mBitmapResult = bitmap;
        this.mExifInfo = exifInfo;
    }

    public BitmapLoadTask.BitmapWorkerResult(Exception exception) {
        this.mBitmapWorkerException = exception;
    }
}
