/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;

class PictureThreadUtils.Task.5
implements Runnable {
    final PictureThreadUtils.Task this$0;

    PictureThreadUtils.Task.5(PictureThreadUtils.Task task) {
        this.this$0 = task;
    }

    @Override
    public void run() {
        this.this$0.onCancel();
        this.this$0.onDone();
    }
}
