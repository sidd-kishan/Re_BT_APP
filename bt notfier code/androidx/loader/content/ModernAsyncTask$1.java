/*
 * Decompiled with CFR 0.152.
 */
package androidx.loader.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

static final class ModernAsyncTask.1
implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);

    ModernAsyncTask.1() {
    }

    @Override
    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ModernAsyncTask #");
        stringBuilder.append(this.mCount.getAndIncrement());
        return new Thread(runnable, stringBuilder.toString());
    }
}
