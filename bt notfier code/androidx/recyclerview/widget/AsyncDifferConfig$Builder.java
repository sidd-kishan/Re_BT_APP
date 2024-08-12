/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AsyncDifferConfig
 *  androidx.recyclerview.widget.DiffUtil$ItemCallback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public static final class AsyncDifferConfig.Builder<T> {
    private static Executor sDiffExecutor;
    private static final Object sExecutorLock;
    private Executor mBackgroundThreadExecutor;
    private final DiffUtil.ItemCallback<T> mDiffCallback;
    private Executor mMainThreadExecutor;

    static {
        sExecutorLock = new Object();
        sDiffExecutor = null;
    }

    public AsyncDifferConfig.Builder(DiffUtil.ItemCallback<T> itemCallback) {
        this.mDiffCallback = itemCallback;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public AsyncDifferConfig<T> build() {
        if (this.mBackgroundThreadExecutor != null) return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
        Object object = sExecutorLock;
        synchronized (object) {
            if (sDiffExecutor == null) {
                sDiffExecutor = Executors.newFixedThreadPool(2);
            }
        }
        this.mBackgroundThreadExecutor = sDiffExecutor;
        return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
    }

    public AsyncDifferConfig.Builder<T> setBackgroundThreadExecutor(Executor executor) {
        this.mBackgroundThreadExecutor = executor;
        return this;
    }

    public AsyncDifferConfig.Builder<T> setMainThreadExecutor(Executor executor) {
        this.mMainThreadExecutor = executor;
        return this;
    }
}
