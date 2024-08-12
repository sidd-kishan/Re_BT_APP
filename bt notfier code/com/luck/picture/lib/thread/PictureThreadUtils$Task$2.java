/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;

class PictureThreadUtils.Task.2
implements Runnable {
    final PictureThreadUtils.Task this$0;
    final Object val$result;

    PictureThreadUtils.Task.2(PictureThreadUtils.Task task, Object object) {
        this.this$0 = task;
        this.val$result = object;
    }

    @Override
    public void run() {
        this.this$0.onSuccess(this.val$result);
    }
}
