/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils$UtilsThreadFactory
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;

class PictureThreadUtils.UtilsThreadFactory.2
implements Thread.UncaughtExceptionHandler {
    final PictureThreadUtils.UtilsThreadFactory this$0;

    PictureThreadUtils.UtilsThreadFactory.2(PictureThreadUtils.UtilsThreadFactory utilsThreadFactory) {
        this.this$0 = utilsThreadFactory;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println(throwable);
    }
}
