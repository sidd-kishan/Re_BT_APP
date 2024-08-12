/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkInfo
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.StatusRunnable
 */
package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.StatusRunnable;
import java.util.List;

class StatusRunnable.1
extends StatusRunnable<List<WorkInfo>> {
    final List val$ids;
    final WorkManagerImpl val$workManager;

    StatusRunnable.1(WorkManagerImpl workManagerImpl, List list) {
        this.val$workManager = workManagerImpl;
        this.val$ids = list;
    }

    public List<WorkInfo> runInternal() {
        List list = this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForIds(this.val$ids);
        return (List)WorkSpec.WORK_INFO_MAPPER.apply((Object)list);
    }
}
