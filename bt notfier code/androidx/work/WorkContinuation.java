/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.Operation
 *  androidx.work.WorkInfo
 */
package androidx.work;

import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public abstract class WorkContinuation {
    public static WorkContinuation combine(List<WorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }

    protected abstract WorkContinuation combineInternal(List<WorkContinuation> var1);

    public abstract Operation enqueue();

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos();

    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData();

    public final WorkContinuation then(OneTimeWorkRequest oneTimeWorkRequest) {
        return this.then(Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract WorkContinuation then(List<OneTimeWorkRequest> var1);
}
