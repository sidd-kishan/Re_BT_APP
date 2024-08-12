/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 */
package com.luck.picture.lib.thread;

import android.util.Log;
import com.luck.picture.lib.thread.PictureThreadUtils;

public static abstract class PictureThreadUtils.SimpleTask<T>
extends PictureThreadUtils.Task<T> {
    public void onCancel() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCancel: ");
        stringBuilder.append(Thread.currentThread());
        Log.e((String)"ThreadUtils", (String)stringBuilder.toString());
    }

    public void onFail(Throwable throwable) {
        Log.e((String)"ThreadUtils", (String)"onFail: ", (Throwable)throwable);
    }
}
