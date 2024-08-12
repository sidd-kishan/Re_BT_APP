/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.BackoffPolicy
 *  androidx.work.NetworkType
 *  androidx.work.OutOfQuotaPolicy
 *  androidx.work.WorkInfo$State
 */
package androidx.work.impl.model;

import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;

static class WorkTypeConverters.1 {
    static final int[] $SwitchMap$androidx$work$BackoffPolicy;
    static final int[] $SwitchMap$androidx$work$NetworkType;
    static final int[] $SwitchMap$androidx$work$OutOfQuotaPolicy;
    static final int[] $SwitchMap$androidx$work$WorkInfo$State;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[OutOfQuotaPolicy.values().length];
        $SwitchMap$androidx$work$OutOfQuotaPolicy = nArray;
        try {
            nArray[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$OutOfQuotaPolicy[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[NetworkType.values().length];
        $SwitchMap$androidx$work$NetworkType = nArray;
        try {
            nArray[NetworkType.NOT_REQUIRED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[BackoffPolicy.values().length];
        $SwitchMap$androidx$work$BackoffPolicy = nArray;
        try {
            nArray[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$BackoffPolicy[BackoffPolicy.LINEAR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[WorkInfo.State.values().length];
        $SwitchMap$androidx$work$WorkInfo$State = nArray;
        try {
            nArray[WorkInfo.State.ENQUEUED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.RUNNING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.FAILED.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.BLOCKED.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            WorkTypeConverters.1.$SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.CANCELLED.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
