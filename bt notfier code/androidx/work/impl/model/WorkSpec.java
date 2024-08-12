/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.work.BackoffPolicy
 *  androidx.work.Constraints
 *  androidx.work.Data
 *  androidx.work.Logger
 *  androidx.work.OutOfQuotaPolicy
 *  androidx.work.WorkInfo
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 */
package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

public final class WorkSpec {
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1L;
    private static final String TAG = Logger.tagWithPrefix((String)"WorkSpec");
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new /* Unavailable Anonymous Inner Class!! */;
    public long backoffDelayDuration = 30000L;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    public String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long minimumRetentionDuration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    public long periodStartTime;
    public int runAttemptCount;
    public long scheduleRequestedAt = -1L;
    public WorkInfo.State state = WorkInfo.State.ENQUEUED;
    public String workerClassName;

    public WorkSpec(WorkSpec workSpec) {
        this.input = Data.EMPTY;
        this.output = Data.EMPTY;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.id = workSpec.id;
        this.workerClassName = workSpec.workerClassName;
        this.state = workSpec.state;
        this.inputMergerClassName = workSpec.inputMergerClassName;
        this.input = new Data(workSpec.input);
        this.output = new Data(workSpec.output);
        this.initialDelay = workSpec.initialDelay;
        this.intervalDuration = workSpec.intervalDuration;
        this.flexDuration = workSpec.flexDuration;
        this.constraints = new Constraints(workSpec.constraints);
        this.runAttemptCount = workSpec.runAttemptCount;
        this.backoffPolicy = workSpec.backoffPolicy;
        this.backoffDelayDuration = workSpec.backoffDelayDuration;
        this.periodStartTime = workSpec.periodStartTime;
        this.minimumRetentionDuration = workSpec.minimumRetentionDuration;
        this.scheduleRequestedAt = workSpec.scheduleRequestedAt;
        this.expedited = workSpec.expedited;
        this.outOfQuotaPolicy = workSpec.outOfQuotaPolicy;
    }

    public WorkSpec(String string, String string2) {
        this.input = Data.EMPTY;
        this.output = Data.EMPTY;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.id = string;
        this.workerClassName = string2;
    }

    public long calculateNextRunTime() {
        long l;
        boolean bl = this.isBackedOff();
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl) {
            bl2 = bl3;
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                bl2 = true;
            }
            long l2 = bl2 ? this.backoffDelayDuration * (long)this.runAttemptCount : (long)Math.scalb(this.backoffDelayDuration, this.runAttemptCount - 1);
            return this.periodStartTime + Math.min(18000000L, l2);
        }
        bl = this.isPeriodic();
        long l3 = 0L;
        if (!bl) {
            long l4 = l3 = this.periodStartTime;
            if (l3 != 0L) return l4 + this.initialDelay;
            l4 = System.currentTimeMillis();
            return l4 + this.initialDelay;
        }
        long l5 = System.currentTimeMillis();
        long l6 = l = this.periodStartTime;
        if (l == 0L) {
            l6 = this.initialDelay + l5;
        }
        if (this.flexDuration != this.intervalDuration) {
            bl2 = true;
        }
        if (bl2) {
            if (this.periodStartTime != 0L) return l6 + this.intervalDuration + l3;
            l3 = this.flexDuration * -1L;
            return l6 + this.intervalDuration + l3;
        }
        if (this.periodStartTime == 0L) return l6 + l3;
        l3 = this.intervalDuration;
        return l6 + l3;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (WorkSpec)object;
        if (this.initialDelay != ((WorkSpec)object).initialDelay) {
            return false;
        }
        if (this.intervalDuration != ((WorkSpec)object).intervalDuration) {
            return false;
        }
        if (this.flexDuration != ((WorkSpec)object).flexDuration) {
            return false;
        }
        if (this.runAttemptCount != ((WorkSpec)object).runAttemptCount) {
            return false;
        }
        if (this.backoffDelayDuration != ((WorkSpec)object).backoffDelayDuration) {
            return false;
        }
        if (this.periodStartTime != ((WorkSpec)object).periodStartTime) {
            return false;
        }
        if (this.minimumRetentionDuration != ((WorkSpec)object).minimumRetentionDuration) {
            return false;
        }
        if (this.scheduleRequestedAt != ((WorkSpec)object).scheduleRequestedAt) {
            return false;
        }
        if (this.expedited != ((WorkSpec)object).expedited) {
            return false;
        }
        if (!this.id.equals(((WorkSpec)object).id)) {
            return false;
        }
        if (this.state != ((WorkSpec)object).state) {
            return false;
        }
        if (!this.workerClassName.equals(((WorkSpec)object).workerClassName)) {
            return false;
        }
        String string = this.inputMergerClassName;
        if (string != null ? !string.equals(((WorkSpec)object).inputMergerClassName) : ((WorkSpec)object).inputMergerClassName != null) {
            return false;
        }
        if (!this.input.equals((Object)((WorkSpec)object).input)) {
            return false;
        }
        if (!this.output.equals((Object)((WorkSpec)object).output)) {
            return false;
        }
        if (!this.constraints.equals((Object)((WorkSpec)object).constraints)) {
            return false;
        }
        if (this.backoffPolicy != ((WorkSpec)object).backoffPolicy) {
            return false;
        }
        if (this.outOfQuotaPolicy == ((WorkSpec)object).outOfQuotaPolicy) return bl;
        bl = false;
        return bl;
    }

    public boolean hasConstraints() {
        return Constraints.NONE.equals((Object)this.constraints) ^ true;
    }

    public int hashCode() {
        int n = this.id.hashCode();
        int n2 = this.state.hashCode();
        int n3 = this.workerClassName.hashCode();
        String string = this.inputMergerClassName;
        int n4 = string != null ? string.hashCode() : 0;
        int n5 = this.input.hashCode();
        int n6 = this.output.hashCode();
        long l = this.initialDelay;
        int n7 = (int)(l ^ l >>> 32);
        l = this.intervalDuration;
        int n8 = (int)(l ^ l >>> 32);
        l = this.flexDuration;
        int n9 = (int)(l ^ l >>> 32);
        int n10 = this.constraints.hashCode();
        int n11 = this.runAttemptCount;
        int n12 = this.backoffPolicy.hashCode();
        l = this.backoffDelayDuration;
        int n13 = (int)(l ^ l >>> 32);
        l = this.periodStartTime;
        int n14 = (int)(l ^ l >>> 32);
        l = this.minimumRetentionDuration;
        int n15 = (int)(l ^ l >>> 32);
        l = this.scheduleRequestedAt;
        return ((((((((((((((((n * 31 + n2) * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n8) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n12) * 31 + n13) * 31 + n14) * 31 + n15) * 31 + (int)(l ^ l >>> 32)) * 31 + this.expedited) * 31 + this.outOfQuotaPolicy.hashCode();
    }

    public boolean isBackedOff() {
        boolean bl = this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
        return bl;
    }

    public boolean isPeriodic() {
        boolean bl = this.intervalDuration != 0L;
        return bl;
    }

    public void setBackoffDelayDuration(long l) {
        long l2 = l;
        if (l > 18000000L) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            l2 = 18000000L;
        }
        l = l2;
        if (l2 < 10000L) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value", new Throwable[0]);
            l = 10000L;
        }
        this.backoffDelayDuration = l;
    }

    public void setPeriodic(long l) {
        long l2 = l;
        if (l < 900000L) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            l2 = 900000L;
        }
        this.setPeriodic(l2, l2);
    }

    public void setPeriodic(long l, long l2) {
        long l3 = l;
        if (l < 900000L) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            l3 = 900000L;
        }
        l = l2;
        if (l2 < 300000L) {
            Logger.get().warning(TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
            l = 300000L;
        }
        l2 = l;
        if (l > l3) {
            Logger.get().warning(TAG, String.format("Flex duration greater than interval duration; Changed to %s", l3), new Throwable[0]);
            l2 = l3;
        }
        this.intervalDuration = l3;
        this.flexDuration = l2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{WorkSpec: ");
        stringBuilder.append(this.id);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
