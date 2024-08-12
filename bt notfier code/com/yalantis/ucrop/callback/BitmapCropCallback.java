/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.yalantis.ucrop.callback;

import android.net.Uri;

public interface BitmapCropCallback {
    public void onBitmapCropped(Uri var1, int var2, int var3, int var4, int var5);

    public void onCropFailure(Throwable var1);
}
