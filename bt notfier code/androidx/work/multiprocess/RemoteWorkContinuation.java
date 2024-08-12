/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.OneTimeWorkRequest
 */
package androidx.work.multiprocess;

import androidx.work.OneTimeWorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public abstract class RemoteWorkContinuation {
    protected RemoteWorkContinuation() {
    }

    public static RemoteWorkContinuation combine(List<RemoteWorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }

    protected abstract RemoteWorkContinuation combineInternal(List<RemoteWorkContinuation> var1);

    public abstract ListenableFuture<Void> enqueue();

    public final RemoteWorkContinuation then(OneTimeWorkRequest oneTimeWorkRequest) {
        return this.then(Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation then(List<OneTimeWorkRequest> var1);
}
