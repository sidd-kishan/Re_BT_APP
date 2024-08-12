/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work;

import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;

public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000L;
    public static final long MAX_BACKOFF_MILLIS = 18000000L;
    public static final long MIN_BACKOFF_MILLIS = 10000L;
    private UUID mId;
    private Set<String> mTags;
    private WorkSpec mWorkSpec;

    protected WorkRequest(UUID uUID, WorkSpec workSpec, Set<String> set) {
        this.mId = uUID;
        this.mWorkSpec = workSpec;
        this.mTags = set;
    }

    public UUID getId() {
        return this.mId;
    }

    public String getStringId() {
        return this.mId.toString();
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }
}
