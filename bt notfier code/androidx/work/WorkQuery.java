/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkInfo$State
 *  androidx.work.WorkQuery$Builder
 */
package androidx.work;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import java.util.List;
import java.util.UUID;

public final class WorkQuery {
    private final List<UUID> mIds;
    private final List<WorkInfo.State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    WorkQuery(Builder builder) {
        this.mIds = builder.mIds;
        this.mUniqueWorkNames = builder.mUniqueWorkNames;
        this.mTags = builder.mTags;
        this.mStates = builder.mStates;
    }

    public List<UUID> getIds() {
        return this.mIds;
    }

    public List<WorkInfo.State> getStates() {
        return this.mStates;
    }

    public List<String> getTags() {
        return this.mTags;
    }

    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }
}
