/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  androidx.lifecycle.LiveData
 *  androidx.work.ArrayCreatingInputMerger
 *  androidx.work.ExistingWorkPolicy
 *  androidx.work.Logger
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.OneTimeWorkRequest$Builder
 *  androidx.work.Operation
 *  androidx.work.WorkContinuation
 *  androidx.work.WorkInfo
 *  androidx.work.WorkRequest
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.utils.EnqueueRunnable
 *  androidx.work.impl.utils.StatusRunnable
 *  androidx.work.impl.workers.CombineContinuationsWorker
 */
package androidx.work.impl;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.workers.CombineContinuationsWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WorkContinuationImpl
extends WorkContinuation {
    private static final String TAG = Logger.tagWithPrefix((String)"WorkContinuationImpl");
    private final List<String> mAllIds;
    private boolean mEnqueued;
    private final ExistingWorkPolicy mExistingWorkPolicy;
    private final List<String> mIds;
    private final String mName;
    private Operation mOperation;
    private final List<WorkContinuationImpl> mParents;
    private final List<? extends WorkRequest> mWork;
    private final WorkManagerImpl mWorkManagerImpl;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String string, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list) {
        this(workManagerImpl, string, existingWorkPolicy, list, null);
    }

    /*
     * WARNING - void declaration
     */
    public WorkContinuationImpl(WorkManagerImpl object3, String object2, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list, List<WorkContinuationImpl> list2) {
        void var5_9;
        void var4_8;
        void var3_7;
        Iterator iterator;
        this.mWorkManagerImpl = object3;
        this.mName = iterator;
        this.mExistingWorkPolicy = var3_7;
        this.mWork = var4_8;
        this.mParents = var5_9;
        this.mIds = new ArrayList<String>(this.mWork.size());
        this.mAllIds = new ArrayList<String>();
        if (var5_9 != null) {
            for (WorkContinuationImpl workContinuationImpl : var5_9) {
                this.mAllIds.addAll(workContinuationImpl.mAllIds);
            }
        }
        int n = 0;
        while (n < var4_8.size()) {
            String string = ((WorkRequest)var4_8.get(n)).getStringId();
            this.mIds.add(string);
            this.mAllIds.add(string);
            ++n;
        }
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> list) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, list, null);
    }

    private static boolean hasCycles(WorkContinuationImpl workContinuationImpl, Set<String> set) {
        set.addAll(workContinuationImpl.getIds());
        Set<String> set2 = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
        Object object = set.iterator();
        while (object.hasNext()) {
            if (!set2.contains(object.next())) continue;
            return true;
        }
        object = workContinuationImpl.getParents();
        if (object != null && !object.isEmpty()) {
            object = object.iterator();
            while (object.hasNext()) {
                if (!WorkContinuationImpl.hasCycles((WorkContinuationImpl)((Object)object.next()), set)) continue;
                return true;
            }
        }
        set.removeAll(workContinuationImpl.getIds());
        return false;
    }

    public static Set<String> prerequisitesFor(WorkContinuationImpl object) {
        HashSet<String> hashSet = new HashSet<String>();
        if ((object = ((WorkContinuationImpl)((Object)object)).getParents()) == null) return hashSet;
        if (object.isEmpty()) return hashSet;
        object = object.iterator();
        while (object.hasNext()) {
            hashSet.addAll(((WorkContinuationImpl)((Object)object.next())).getIds());
        }
        return hashSet;
    }

    protected WorkContinuation combineInternal(List<WorkContinuation> object) {
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest)new OneTimeWorkRequest.Builder(CombineContinuationsWorker.class).setInputMerger(ArrayCreatingInputMerger.class).build();
        ArrayList<WorkContinuationImpl> arrayList = new ArrayList<WorkContinuationImpl>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add((WorkContinuationImpl)((WorkContinuation)object.next()));
        }
        return new WorkContinuationImpl(this.mWorkManagerImpl, null, ExistingWorkPolicy.KEEP, Collections.singletonList(oneTimeWorkRequest), arrayList);
    }

    public Operation enqueue() {
        if (!this.mEnqueued) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.mWorkManagerImpl.getWorkTaskExecutor().executeOnBackgroundThread((Runnable)enqueueRunnable);
            this.mOperation = enqueueRunnable.getOperation();
        } else {
            Logger.get().warning(TAG, String.format("Already enqueued work ids (%s)", TextUtils.join((CharSequence)", ", this.mIds)), new Throwable[0]);
        }
        return this.mOperation;
    }

    public List<String> getAllIds() {
        return this.mAllIds;
    }

    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.mExistingWorkPolicy;
    }

    public List<String> getIds() {
        return this.mIds;
    }

    public String getName() {
        return this.mName;
    }

    public List<WorkContinuationImpl> getParents() {
        return this.mParents;
    }

    public List<? extends WorkRequest> getWork() {
        return this.mWork;
    }

    public ListenableFuture<List<WorkInfo>> getWorkInfos() {
        StatusRunnable statusRunnable = StatusRunnable.forStringIds((WorkManagerImpl)this.mWorkManagerImpl, this.mAllIds);
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnBackgroundThread((Runnable)statusRunnable);
        return statusRunnable.getFuture();
    }

    public LiveData<List<WorkInfo>> getWorkInfosLiveData() {
        return this.mWorkManagerImpl.getWorkInfosById(this.mAllIds);
    }

    public WorkManagerImpl getWorkManagerImpl() {
        return this.mWorkManagerImpl;
    }

    public boolean hasCycles() {
        return WorkContinuationImpl.hasCycles(this, new HashSet<String>());
    }

    public boolean isEnqueued() {
        return this.mEnqueued;
    }

    public void markEnqueued() {
        this.mEnqueued = true;
    }

    public WorkContinuation then(List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) return new WorkContinuationImpl(this.mWorkManagerImpl, this.mName, ExistingWorkPolicy.KEEP, list, Collections.singletonList(this));
        return this;
    }
}
