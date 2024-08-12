/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.TimerTask;

/*
 * Exception performing whole class analysis ignored.
 */
class PictureThreadUtils.Task.1
extends TimerTask {
    final PictureThreadUtils.Task this$0;

    PictureThreadUtils.Task.1(PictureThreadUtils.Task task) {
        this.this$0 = task;
    }

    @Override
    public void run() {
        if (this.this$0.isDone()) return;
        if (PictureThreadUtils.Task.access$400((PictureThreadUtils.Task)this.this$0) == null) return;
        PictureThreadUtils.Task.access$500((PictureThreadUtils.Task)this.this$0);
        PictureThreadUtils.Task.access$400((PictureThreadUtils.Task)this.this$0).onTimeout();
        this.this$0.onDone();
    }
}
