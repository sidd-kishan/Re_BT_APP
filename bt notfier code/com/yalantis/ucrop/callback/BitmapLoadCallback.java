/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.yalantis.ucrop.model.ExifInfo
 */
package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;
import com.yalantis.ucrop.model.ExifInfo;

public interface BitmapLoadCallback {
    public void onBitmapLoaded(Bitmap var1, ExifInfo var2, String var3, String var4);

    public void onFailure(Exception var1);
}
