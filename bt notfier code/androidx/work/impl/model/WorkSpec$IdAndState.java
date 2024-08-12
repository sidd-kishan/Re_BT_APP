/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkInfo$State
 */
package androidx.work.impl.model;

import androidx.work.WorkInfo;

public static class WorkSpec.IdAndState {
    public String id;
    public WorkInfo.State state;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WorkSpec.IdAndState)) {
            return false;
        }
        object = (WorkSpec.IdAndState)object;
        if (this.state == ((WorkSpec.IdAndState)object).state) return this.id.equals(((WorkSpec.IdAndState)object).id);
        return false;
    }

    public int hashCode() {
        return this.id.hashCode() * 31 + this.state.hashCode();
    }
}
