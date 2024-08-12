/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 */
package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

public interface ImageDecoder {
    public Bitmap decode(Context var1, Uri var2) throws Exception;
}
