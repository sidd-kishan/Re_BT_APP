/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.work.WorkInfo
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 */
package androidx.work.impl;

import androidx.arch.core.util.Function;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

class WorkManagerImpl.2
implements Function<List<WorkSpec.WorkInfoPojo>, WorkInfo> {
    final WorkManagerImpl this$0;

    WorkManagerImpl.2(WorkManagerImpl workManagerImpl) {
        this.this$0 = workManagerImpl;
    }

    public WorkInfo apply(List<WorkSpec.WorkInfoPojo> object) {
        object = object != null && object.size() > 0 ? object.get(0).toWorkInfo() : null;
        return object;
    }
}
