/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkInfo
 *  androidx.work.WorkQuery
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.RawQueries
 *  androidx.work.impl.utils.StatusRunnable
 */
package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StatusRunnable;
import java.util.List;

class StatusRunnable.5
extends StatusRunnable<List<WorkInfo>> {
    final WorkQuery val$querySpec;
    final WorkManagerImpl val$workManager;

    StatusRunnable.5(WorkManagerImpl workManagerImpl, WorkQuery workQuery) {
        this.val$workManager = workManagerImpl;
        this.val$querySpec = workQuery;
    }

    List<WorkInfo> runInternal() {
        List list = this.val$workManager.getWorkDatabase().rawWorkInfoDao().getWorkInfoPojos(RawQueries.workQueryToRawQuery((WorkQuery)this.val$querySpec));
        return (List)WorkSpec.WORK_INFO_MAPPER.apply((Object)list);
    }
}
