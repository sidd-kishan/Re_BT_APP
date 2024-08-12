/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkInfo$State
 *  androidx.work.WorkQuery
 */
package androidx.work;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public static final class WorkQuery.Builder {
    List<UUID> mIds = new ArrayList<UUID>();
    List<WorkInfo.State> mStates;
    List<String> mTags;
    List<String> mUniqueWorkNames = new ArrayList<String>();

    private WorkQuery.Builder() {
        this.mTags = new ArrayList<String>();
        this.mStates = new ArrayList<WorkInfo.State>();
    }

    public static WorkQuery.Builder fromIds(List<UUID> list) {
        WorkQuery.Builder builder = new WorkQuery.Builder();
        builder.addIds(list);
        return builder;
    }

    public static WorkQuery.Builder fromStates(List<WorkInfo.State> list) {
        WorkQuery.Builder builder = new WorkQuery.Builder();
        builder.addStates(list);
        return builder;
    }

    public static WorkQuery.Builder fromTags(List<String> list) {
        WorkQuery.Builder builder = new WorkQuery.Builder();
        builder.addTags(list);
        return builder;
    }

    public static WorkQuery.Builder fromUniqueWorkNames(List<String> list) {
        WorkQuery.Builder builder = new WorkQuery.Builder();
        builder.addUniqueWorkNames(list);
        return builder;
    }

    public WorkQuery.Builder addIds(List<UUID> list) {
        this.mIds.addAll(list);
        return this;
    }

    public WorkQuery.Builder addStates(List<WorkInfo.State> list) {
        this.mStates.addAll(list);
        return this;
    }

    public WorkQuery.Builder addTags(List<String> list) {
        this.mTags.addAll(list);
        return this;
    }

    public WorkQuery.Builder addUniqueWorkNames(List<String> list) {
        this.mUniqueWorkNames.addAll(list);
        return this;
    }

    public WorkQuery build() {
        if (!this.mIds.isEmpty()) return new WorkQuery(this);
        if (!this.mUniqueWorkNames.isEmpty()) return new WorkQuery(this);
        if (!this.mTags.isEmpty()) return new WorkQuery(this);
        if (this.mStates.isEmpty()) throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
        return new WorkQuery(this);
    }
}
