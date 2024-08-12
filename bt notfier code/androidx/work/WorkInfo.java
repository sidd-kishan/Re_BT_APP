/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.WorkInfo$State
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.WorkInfo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo {
    private UUID mId;
    private Data mOutputData;
    private Data mProgress;
    private int mRunAttemptCount;
    private State mState;
    private Set<String> mTags;

    public WorkInfo(UUID uUID, State state, Data data, List<String> list, Data data2, int n) {
        this.mId = uUID;
        this.mState = state;
        this.mOutputData = data;
        this.mTags = new HashSet<String>(list);
        this.mProgress = data2;
        this.mRunAttemptCount = n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (WorkInfo)object;
        if (this.mRunAttemptCount != ((WorkInfo)object).mRunAttemptCount) {
            return false;
        }
        if (!this.mId.equals(((WorkInfo)object).mId)) {
            return false;
        }
        if (this.mState != ((WorkInfo)object).mState) {
            return false;
        }
        if (!this.mOutputData.equals((Object)((WorkInfo)object).mOutputData)) {
            return false;
        }
        if (this.mTags.equals(((WorkInfo)object).mTags)) return this.mProgress.equals((Object)((WorkInfo)object).mProgress);
        return false;
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getOutputData() {
        return this.mOutputData;
    }

    public Data getProgress() {
        return this.mProgress;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    public State getState() {
        return this.mState;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public int hashCode() {
        return ((((this.mId.hashCode() * 31 + this.mState.hashCode()) * 31 + this.mOutputData.hashCode()) * 31 + this.mTags.hashCode()) * 31 + this.mProgress.hashCode()) * 31 + this.mRunAttemptCount;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkInfo{mId='");
        stringBuilder.append(this.mId);
        stringBuilder.append('\'');
        stringBuilder.append(", mState=");
        stringBuilder.append(this.mState);
        stringBuilder.append(", mOutputData=");
        stringBuilder.append(this.mOutputData);
        stringBuilder.append(", mTags=");
        stringBuilder.append(this.mTags);
        stringBuilder.append(", mProgress=");
        stringBuilder.append(this.mProgress);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
