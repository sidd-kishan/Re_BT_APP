/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.ListenableWorker
 *  androidx.work.OneTimeWorkRequest$Builder
 *  androidx.work.WorkRequest
 */
package androidx.work;

import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;

public final class OneTimeWorkRequest
extends WorkRequest {
    OneTimeWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }

    public static OneTimeWorkRequest from(Class<? extends ListenableWorker> clazz) {
        return (OneTimeWorkRequest)new Builder(clazz).build();
    }

    public static List<OneTimeWorkRequest> from(List<Class<? extends ListenableWorker>> object) {
        ArrayList<OneTimeWorkRequest> arrayList = new ArrayList<OneTimeWorkRequest>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add((OneTimeWorkRequest)new Builder((Class)object.next()).build());
        }
        return arrayList;
    }
}
