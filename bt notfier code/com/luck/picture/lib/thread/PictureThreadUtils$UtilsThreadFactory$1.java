/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.luck.picture.lib.thread.PictureThreadUtils$UtilsThreadFactory
 */
package com.luck.picture.lib.thread;

import android.util.Log;
import com.luck.picture.lib.thread.PictureThreadUtils;

class PictureThreadUtils.UtilsThreadFactory.1
extends Thread {
    final PictureThreadUtils.UtilsThreadFactory this$0;

    PictureThreadUtils.UtilsThreadFactory.1(PictureThreadUtils.UtilsThreadFactory utilsThreadFactory, Runnable runnable, String string) {
        this.this$0 = utilsThreadFactory;
        super(runnable, string);
    }

    @Override
    public void run() {
        try {
            super.run();
        }
        catch (Throwable throwable) {
            Log.e((String)"ThreadUtils", (String)"Request threw uncaught throwable", (Throwable)throwable);
        }
    }
}
