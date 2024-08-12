/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

static final class PictureThreadUtils.1
extends TimerTask {
    final ExecutorService val$pool;
    final PictureThreadUtils.Task val$task;

    PictureThreadUtils.1(ExecutorService executorService, PictureThreadUtils.Task task) {
        this.val$pool = executorService;
        this.val$task = task;
    }

    @Override
    public void run() {
        this.val$pool.execute((Runnable)this.val$task);
    }
}
