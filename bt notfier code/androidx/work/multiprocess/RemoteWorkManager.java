/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Data
 *  androidx.work.ExistingPeriodicWorkPolicy
 *  androidx.work.ExistingWorkPolicy
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.PeriodicWorkRequest
 *  androidx.work.WorkContinuation
 *  androidx.work.WorkInfo
 *  androidx.work.WorkQuery
 *  androidx.work.WorkRequest
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.multiprocess.RemoteWorkContinuation
 */
package androidx.work.multiprocess;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.multiprocess.RemoteWorkContinuation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class RemoteWorkManager {
    protected RemoteWorkManager() {
    }

    public static RemoteWorkManager getInstance(Context object) {
        if ((object = WorkManagerImpl.getInstance((Context)object).getRemoteWorkManager()) == null) throw new IllegalStateException("Unable to initialize RemoteWorkManager");
        return object;
    }

    public final RemoteWorkContinuation beginUniqueWork(String string, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return this.beginUniqueWork(string, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation beginUniqueWork(String var1, ExistingWorkPolicy var2, List<OneTimeWorkRequest> var3);

    public final RemoteWorkContinuation beginWith(OneTimeWorkRequest oneTimeWorkRequest) {
        return this.beginWith(Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation beginWith(List<OneTimeWorkRequest> var1);

    public abstract ListenableFuture<Void> cancelAllWork();

    public abstract ListenableFuture<Void> cancelAllWorkByTag(String var1);

    public abstract ListenableFuture<Void> cancelUniqueWork(String var1);

    public abstract ListenableFuture<Void> cancelWorkById(UUID var1);

    public abstract ListenableFuture<Void> enqueue(WorkContinuation var1);

    public abstract ListenableFuture<Void> enqueue(WorkRequest var1);

    public abstract ListenableFuture<Void> enqueue(List<WorkRequest> var1);

    public abstract ListenableFuture<Void> enqueueUniquePeriodicWork(String var1, ExistingPeriodicWorkPolicy var2, PeriodicWorkRequest var3);

    public final ListenableFuture<Void> enqueueUniqueWork(String string, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return this.enqueueUniqueWork(string, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract ListenableFuture<Void> enqueueUniqueWork(String var1, ExistingWorkPolicy var2, List<OneTimeWorkRequest> var3);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery var1);

    public abstract ListenableFuture<Void> setProgress(UUID var1, Data var2);
}
