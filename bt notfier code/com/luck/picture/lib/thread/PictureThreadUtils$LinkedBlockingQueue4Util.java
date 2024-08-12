/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.thread.PictureThreadUtils$ThreadPoolExecutor4Util
 */
package com.luck.picture.lib.thread;

import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.concurrent.LinkedBlockingQueue;

private static final class PictureThreadUtils.LinkedBlockingQueue4Util
extends LinkedBlockingQueue<Runnable> {
    private int mCapacity = Integer.MAX_VALUE;
    private volatile PictureThreadUtils.ThreadPoolExecutor4Util mPool;

    PictureThreadUtils.LinkedBlockingQueue4Util() {
    }

    PictureThreadUtils.LinkedBlockingQueue4Util(int n) {
        this.mCapacity = n;
    }

    PictureThreadUtils.LinkedBlockingQueue4Util(boolean bl) {
        if (!bl) return;
        this.mCapacity = 0;
    }

    static /* synthetic */ PictureThreadUtils.ThreadPoolExecutor4Util access$302(PictureThreadUtils.LinkedBlockingQueue4Util linkedBlockingQueue4Util, PictureThreadUtils.ThreadPoolExecutor4Util threadPoolExecutor4Util) {
        linkedBlockingQueue4Util.mPool = threadPoolExecutor4Util;
        return threadPoolExecutor4Util;
    }

    @Override
    public boolean offer(Runnable runnable) {
        if (this.mCapacity > this.size()) return super.offer(runnable);
        if (this.mPool == null) return super.offer(runnable);
        if (this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) return super.offer(runnable);
        return false;
    }
}
