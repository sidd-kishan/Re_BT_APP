/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkInfo
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.utils.StatusRunnable
 */
package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.StatusRunnable;
import java.util.UUID;

class StatusRunnable.2
extends StatusRunnable<WorkInfo> {
    final UUID val$id;
    final WorkManagerImpl val$workManager;

    StatusRunnable.2(WorkManagerImpl workManagerImpl, UUID uUID) {
        this.val$workManager = workManagerImpl;
        this.val$id = uUID;
    }

    WorkInfo runInternal() {
        Object object = this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForId(this.val$id.toString());
        object = object != null ? object.toWorkInfo() : null;
        return object;
    }
}
