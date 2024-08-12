/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.provider.RequestExecutor$DefaultThreadFactory$ProcessPriorityThread
 */
package androidx.core.provider;

import androidx.core.provider.RequestExecutor;
import java.util.concurrent.ThreadFactory;

private static class RequestExecutor.DefaultThreadFactory
implements ThreadFactory {
    private int mPriority;
    private String mThreadName;

    RequestExecutor.DefaultThreadFactory(String string, int n) {
        this.mThreadName = string;
        this.mPriority = n;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
    }
}
