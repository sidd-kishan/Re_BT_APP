/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.work.ListenableWorker
 *  androidx.work.PeriodicWorkRequest
 *  androidx.work.WorkRequest$Builder
 */
package androidx.work;

import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public static final class PeriodicWorkRequest.Builder
extends WorkRequest.Builder<PeriodicWorkRequest.Builder, PeriodicWorkRequest> {
    public PeriodicWorkRequest.Builder(Class<? extends ListenableWorker> clazz, long l, TimeUnit timeUnit) {
        super(clazz);
        this.mWorkSpec.setPeriodic(timeUnit.toMillis(l));
    }

    public PeriodicWorkRequest.Builder(Class<? extends ListenableWorker> clazz, long l, TimeUnit timeUnit, long l2, TimeUnit timeUnit2) {
        super(clazz);
        this.mWorkSpec.setPeriodic(timeUnit.toMillis(l), timeUnit2.toMillis(l2));
    }

    public PeriodicWorkRequest.Builder(Class<? extends ListenableWorker> clazz, Duration duration) {
        super(clazz);
        this.mWorkSpec.setPeriodic(duration.toMillis());
    }

    public PeriodicWorkRequest.Builder(Class<? extends ListenableWorker> clazz, Duration duration, Duration duration2) {
        super(clazz);
        this.mWorkSpec.setPeriodic(duration.toMillis(), duration2.toMillis());
    }

    PeriodicWorkRequest buildInternal() {
        if (!this.mBackoffCriteriaSet) return new PeriodicWorkRequest(this);
        if (Build.VERSION.SDK_INT < 23) return new PeriodicWorkRequest(this);
        if (this.mWorkSpec.constraints.requiresDeviceIdle()) throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        return new PeriodicWorkRequest(this);
    }

    PeriodicWorkRequest.Builder getThis() {
        return this;
    }
}
