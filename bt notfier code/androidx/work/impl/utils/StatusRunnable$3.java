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

class StatusRunnable.3
extends StatusRunnable<List<WorkInfo>> {
    final String val$tag;
    final WorkManagerImpl val$workManager;

    StatusRunnable.3(WorkManagerImpl workManagerImpl, String string) {
        this.val$workManager = workManagerImpl;
        this.val$tag = string;
    }

    List<WorkInfo> runInternal() {
        List list = this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForTag(this.val$tag);
        return (List)WorkSpec.WORK_INFO_MAPPER.apply((Object)list);
    }
}
