/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.work.InputMerger
 *  androidx.work.ListenableWorker
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.OverwritingInputMerger
 *  androidx.work.WorkRequest$Builder
 */
package androidx.work;

import android.os.Build;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkRequest;

public static final class OneTimeWorkRequest.Builder
extends WorkRequest.Builder<OneTimeWorkRequest.Builder, OneTimeWorkRequest> {
    public OneTimeWorkRequest.Builder(Class<? extends ListenableWorker> clazz) {
        super(clazz);
        this.mWorkSpec.inputMergerClassName = OverwritingInputMerger.class.getName();
    }

    OneTimeWorkRequest buildInternal() {
        if (!this.mBackoffCriteriaSet) return new OneTimeWorkRequest(this);
        if (Build.VERSION.SDK_INT < 23) return new OneTimeWorkRequest(this);
        if (this.mWorkSpec.constraints.requiresDeviceIdle()) throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        return new OneTimeWorkRequest(this);
    }

    OneTimeWorkRequest.Builder getThis() {
        return this;
    }

    public OneTimeWorkRequest.Builder setInputMerger(Class<? extends InputMerger> clazz) {
        this.mWorkSpec.inputMergerClassName = clazz.getName();
        return this;
    }
}
