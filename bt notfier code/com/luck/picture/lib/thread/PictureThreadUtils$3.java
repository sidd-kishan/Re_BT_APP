/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
static final class PictureThreadUtils.3
implements Executor {
    PictureThreadUtils.3() {
    }

    @Override
    public void execute(Runnable runnable) {
        PictureThreadUtils.runOnUiThread((Runnable)runnable);
    }
}
