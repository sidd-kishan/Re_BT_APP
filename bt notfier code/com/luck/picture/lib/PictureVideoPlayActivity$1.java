/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  com.luck.picture.lib.PictureVideoPlayActivity
 */
package com.luck.picture.lib;

import android.content.Context;
import android.content.ContextWrapper;
import com.luck.picture.lib.PictureVideoPlayActivity;

class PictureVideoPlayActivity.1
extends ContextWrapper {
    final PictureVideoPlayActivity this$0;

    PictureVideoPlayActivity.1(PictureVideoPlayActivity pictureVideoPlayActivity, Context context) {
        this.this$0 = pictureVideoPlayActivity;
        super(context);
    }

    public Object getSystemService(String string) {
        if (!"audio".equals(string)) return super.getSystemService(string);
        return this.getApplicationContext().getSystemService(string);
    }
}
