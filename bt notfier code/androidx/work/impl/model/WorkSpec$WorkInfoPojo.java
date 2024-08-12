/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.WorkInfo
 *  androidx.work.WorkInfo$State
 */
package androidx.work.impl.model;

import androidx.work.Data;
import androidx.work.WorkInfo;
import java.util.List;
import java.util.UUID;

public static class WorkSpec.WorkInfoPojo {
    public String id;
    public Data output;
    public List<Data> progress;
    public int runAttemptCount;
    public WorkInfo.State state;
    public List<String> tags;

    public boolean equals(Object list) {
        boolean bl = true;
        if (this == list) {
            return true;
        }
        if (!(list instanceof WorkSpec.WorkInfoPojo)) {
            return false;
        }
        list = (WorkSpec.WorkInfoPojo)((Object)list);
        if (this.runAttemptCount != ((WorkSpec.WorkInfoPojo)((Object)list)).runAttemptCount) {
            return false;
        }
        List<String> list2 = this.id;
        if (list2 != null ? !((String)((Object)list2)).equals(((WorkSpec.WorkInfoPojo)((Object)list)).id) : ((WorkSpec.WorkInfoPojo)((Object)list)).id != null) {
            return false;
        }
        if (this.state != ((WorkSpec.WorkInfoPojo)((Object)list)).state) {
            return false;
        }
        list2 = this.output;
        if (list2 != null ? !list2.equals(((WorkSpec.WorkInfoPojo)((Object)list)).output) : ((WorkSpec.WorkInfoPojo)((Object)list)).output != null) {
            return false;
        }
        list2 = this.tags;
        if (list2 != null ? !list2.equals(((WorkSpec.WorkInfoPojo)((Object)list)).tags) : ((WorkSpec.WorkInfoPojo)((Object)list)).tags != null) {
            return false;
        }
        list2 = this.progress;
        list = ((WorkSpec.WorkInfoPojo)((Object)list)).progress;
        if (list2 != null) {
            bl = list2.equals(list);
        } else {
            if (list == null) return bl;
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        List<Data> list = this.id;
        int n = 0;
        int n2 = list != null ? ((String)((Object)list)).hashCode() : 0;
        list = this.state;
        int n3 = list != null ? list.hashCode() : 0;
        list = this.output;
        int n4 = list != null ? list.hashCode() : 0;
        int n5 = this.runAttemptCount;
        list = this.tags;
        int n6 = list != null ? list.hashCode() : 0;
        list = this.progress;
        if (list == null) return ((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n;
        n = list.hashCode();
        return ((((n2 * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n;
    }

    public WorkInfo toWorkInfo() {
        Data data = this.progress;
        data = data != null && !data.isEmpty() ? this.progress.get(0) : Data.EMPTY;
        return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, data, this.runAttemptCount);
    }
}
