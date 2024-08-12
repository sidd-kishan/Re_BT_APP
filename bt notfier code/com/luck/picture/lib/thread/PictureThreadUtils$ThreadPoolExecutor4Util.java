/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$LinkedBlockingQueue4Util
 *  com.luck.picture.lib.thread.PictureThreadUtils$UtilsThreadFactory
 */
package com.luck.picture.lib.thread;

import android.util.Log;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis ignored.
 */
static final class PictureThreadUtils.ThreadPoolExecutor4Util
extends ThreadPoolExecutor {
    private final AtomicInteger mSubmittedCount = new AtomicInteger();
    private final PictureThreadUtils.LinkedBlockingQueue4Util mWorkQueue;

    PictureThreadUtils.ThreadPoolExecutor4Util(int n, int n2, long l, TimeUnit timeUnit, PictureThreadUtils.LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
        super(n, n2, l, timeUnit, (BlockingQueue<Runnable>)linkedBlockingQueue4Util, threadFactory);
        PictureThreadUtils.LinkedBlockingQueue4Util.access$302((PictureThreadUtils.LinkedBlockingQueue4Util)linkedBlockingQueue4Util, (PictureThreadUtils.ThreadPoolExecutor4Util)this);
        this.mWorkQueue = linkedBlockingQueue4Util;
    }

    static /* synthetic */ ExecutorService access$100(int n, int n2) {
        return PictureThreadUtils.ThreadPoolExecutor4Util.createPool(n, n2);
    }

    private static ExecutorService createPool(int n, int n2) {
        if (n == -8) return new PictureThreadUtils.ThreadPoolExecutor4Util(PictureThreadUtils.access$200() + 1, PictureThreadUtils.access$200() * 2 + 1, 30L, TimeUnit.SECONDS, new PictureThreadUtils.LinkedBlockingQueue4Util(true), (ThreadFactory)new PictureThreadUtils.UtilsThreadFactory("cpu", n2));
        if (n == -4) return new PictureThreadUtils.ThreadPoolExecutor4Util(PictureThreadUtils.access$200() * 2 + 1, PictureThreadUtils.access$200() * 2 + 1, 30L, TimeUnit.SECONDS, new PictureThreadUtils.LinkedBlockingQueue4Util(), (ThreadFactory)new PictureThreadUtils.UtilsThreadFactory("io", n2));
        if (n == -2) return new PictureThreadUtils.ThreadPoolExecutor4Util(0, 128, 60L, TimeUnit.SECONDS, new PictureThreadUtils.LinkedBlockingQueue4Util(true), (ThreadFactory)new PictureThreadUtils.UtilsThreadFactory("cached", n2));
        if (n == -1) return new PictureThreadUtils.ThreadPoolExecutor4Util(1, 1, 0L, TimeUnit.MILLISECONDS, new PictureThreadUtils.LinkedBlockingQueue4Util(), (ThreadFactory)new PictureThreadUtils.UtilsThreadFactory("single", n2));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        PictureThreadUtils.LinkedBlockingQueue4Util linkedBlockingQueue4Util = new PictureThreadUtils.LinkedBlockingQueue4Util();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fixed(");
        stringBuilder.append(n);
        stringBuilder.append(")");
        return new PictureThreadUtils.ThreadPoolExecutor4Util(n, n, 0L, timeUnit, linkedBlockingQueue4Util, (ThreadFactory)new PictureThreadUtils.UtilsThreadFactory(stringBuilder.toString(), n2));
    }

    private int getSubmittedCount() {
        return this.mSubmittedCount.get();
    }

    @Override
    protected void afterExecute(Runnable runnable, Throwable throwable) {
        this.mSubmittedCount.decrementAndGet();
        super.afterExecute(runnable, throwable);
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown()) {
            return;
        }
        this.mSubmittedCount.incrementAndGet();
        try {
            super.execute(runnable);
        }
        catch (Throwable throwable) {
            this.mSubmittedCount.decrementAndGet();
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Log.e((String)"ThreadUtils", (String)"This will not happen!");
            this.mWorkQueue.offer(runnable);
        }
    }
}
