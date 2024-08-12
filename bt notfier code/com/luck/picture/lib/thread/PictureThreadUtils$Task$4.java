/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;

class PictureThreadUtils.Task.4
implements Runnable {
    final PictureThreadUtils.Task this$0;
    final Throwable val$throwable;

    PictureThreadUtils.Task.4(PictureThreadUtils.Task task, Throwable throwable) {
        this.this$0 = task;
        this.val$throwable = throwable;
    }

    @Override
    public void run() {
        this.this$0.onFail(this.val$throwable);
        this.this$0.onDone();
    }
}
