/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.PeriodicWorkRequest$Builder
 *  androidx.work.WorkRequest
 */
package androidx.work;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;

public final class PeriodicWorkRequest
extends WorkRequest {
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000L;
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000L;

    PeriodicWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }
}
