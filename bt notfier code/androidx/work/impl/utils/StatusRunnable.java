/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkInfo
 *  androidx.work.WorkQuery
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;

public abstract class StatusRunnable<T>
implements Runnable {
    private final SettableFuture<T> mFuture = SettableFuture.create();

    public static StatusRunnable<List<WorkInfo>> forStringIds(WorkManagerImpl workManagerImpl, List<String> list) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static StatusRunnable<List<WorkInfo>> forTag(WorkManagerImpl workManagerImpl, String string) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static StatusRunnable<WorkInfo> forUUID(WorkManagerImpl workManagerImpl, UUID uUID) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static StatusRunnable<List<WorkInfo>> forUniqueWork(WorkManagerImpl workManagerImpl, String string) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(WorkManagerImpl workManagerImpl, WorkQuery workQuery) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ListenableFuture<T> getFuture() {
        return this.mFuture;
    }

    @Override
    public void run() {
        try {
            T t = this.runInternal();
            this.mFuture.set(t);
        }
        catch (Throwable throwable) {
            this.mFuture.setException(throwable);
        }
    }

    abstract T runInternal();
}
