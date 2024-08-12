/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;

public static interface GifDecoder.BitmapProvider {
    public Bitmap obtain(int var1, int var2, Bitmap.Config var3);

    public byte[] obtainByteArray(int var1);

    public int[] obtainIntArray(int var1);

    public void release(Bitmap var1);

    public void release(byte[] var1);

    public void release(int[] var1);
}
