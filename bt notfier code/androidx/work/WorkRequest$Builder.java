/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.work.BackoffPolicy
 *  androidx.work.Constraints
 *  androidx.work.Data
 *  androidx.work.ListenableWorker
 *  androidx.work.OutOfQuotaPolicy
 *  androidx.work.WorkInfo$State
 *  androidx.work.WorkRequest
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public static abstract class WorkRequest.Builder<B extends WorkRequest.Builder<?, ?>, W extends WorkRequest> {
    boolean mBackoffCriteriaSet = false;
    UUID mId;
    Set<String> mTags = new HashSet<String>();
    WorkSpec mWorkSpec;
    Class<? extends ListenableWorker> mWorkerClass;

    WorkRequest.Builder(Class<? extends ListenableWorker> clazz) {
        this.mId = UUID.randomUUID();
        this.mWorkerClass = clazz;
        this.mWorkSpec = new WorkSpec(this.mId.toString(), clazz.getName());
        this.addTag(clazz.getName());
    }

    public final B addTag(String string) {
        this.mTags.add(string);
        return this.getThis();
    }

    public final W build() {
        W w = this.buildInternal();
        Constraints constraints = this.mWorkSpec.constraints;
        boolean bl = Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers() || constraints.requiresBatteryNotLow() || constraints.requiresCharging() || Build.VERSION.SDK_INT >= 23 && constraints.requiresDeviceIdle();
        if (this.mWorkSpec.expedited) {
            if (bl) throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        }
        this.mId = UUID.randomUUID();
        constraints = new WorkSpec(this.mWorkSpec);
        this.mWorkSpec = constraints;
        constraints.id = this.mId.toString();
        return w;
    }

    abstract W buildInternal();

    abstract B getThis();

    public final B keepResultsForAtLeast(long l, TimeUnit timeUnit) {
        this.mWorkSpec.minimumRetentionDuration = timeUnit.toMillis(l);
        return this.getThis();
    }

    public final B keepResultsForAtLeast(Duration duration) {
        this.mWorkSpec.minimumRetentionDuration = duration.toMillis();
        return this.getThis();
    }

    public final B setBackoffCriteria(BackoffPolicy backoffPolicy, long l, TimeUnit timeUnit) {
        this.mBackoffCriteriaSet = true;
        this.mWorkSpec.backoffPolicy = backoffPolicy;
        this.mWorkSpec.setBackoffDelayDuration(timeUnit.toMillis(l));
        return this.getThis();
    }

    public final B setBackoffCriteria(BackoffPolicy backoffPolicy, Duration duration) {
        this.mBackoffCriteriaSet = true;
        this.mWorkSpec.backoffPolicy = backoffPolicy;
        this.mWorkSpec.setBackoffDelayDuration(duration.toMillis());
        return this.getThis();
    }

    public final B setConstraints(Constraints constraints) {
        this.mWorkSpec.constraints = constraints;
        return this.getThis();
    }

    public B setExpedited(OutOfQuotaPolicy outOfQuotaPolicy) {
        this.mWorkSpec.expedited = true;
        this.mWorkSpec.outOfQuotaPolicy = outOfQuotaPolicy;
        return this.getThis();
    }

    public B setInitialDelay(long l, TimeUnit timeUnit) {
        this.mWorkSpec.initialDelay = timeUnit.toMillis(l);
        if (Long.MAX_VALUE - System.currentTimeMillis() <= this.mWorkSpec.initialDelay) throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        return this.getThis();
    }

    public B setInitialDelay(Duration duration) {
        this.mWorkSpec.initialDelay = duration.toMillis();
        if (Long.MAX_VALUE - System.currentTimeMillis() <= this.mWorkSpec.initialDelay) throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        return this.getThis();
    }

    public final B setInitialRunAttemptCount(int n) {
        this.mWorkSpec.runAttemptCount = n;
        return this.getThis();
    }

    public final B setInitialState(WorkInfo.State state) {
        this.mWorkSpec.state = state;
        return this.getThis();
    }

    public final B setInputData(Data data) {
        this.mWorkSpec.input = data;
        return this.getThis();
    }

    public final B setPeriodStartTime(long l, TimeUnit timeUnit) {
        this.mWorkSpec.periodStartTime = timeUnit.toMillis(l);
        return this.getThis();
    }

    public final B setScheduleRequestedAt(long l, TimeUnit timeUnit) {
        this.mWorkSpec.scheduleRequestedAt = timeUnit.toMillis(l);
        return this.getThis();
    }
}
