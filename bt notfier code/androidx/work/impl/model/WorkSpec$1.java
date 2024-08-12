/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.work.WorkInfo
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 */
package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

class WorkSpec.1
implements Function<List<WorkSpec.WorkInfoPojo>, List<WorkInfo>> {
    WorkSpec.1() {
    }

    public List<WorkInfo> apply(List<WorkSpec.WorkInfoPojo> object) {
        if (object == null) {
            return null;
        }
        ArrayList<WorkInfo> arrayList = new ArrayList<WorkInfo>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(((WorkSpec.WorkInfoPojo)object.next()).toWorkInfo());
        }
        return arrayList;
    }
}
