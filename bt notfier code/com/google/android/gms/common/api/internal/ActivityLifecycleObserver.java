/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.google.android.gms.common.api.internal.zaa
 *  com.google.android.gms.common.api.internal.zab
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.internal.zaa;
import com.google.android.gms.common.api.internal.zab;

public abstract class ActivityLifecycleObserver {
    public static final ActivityLifecycleObserver of(Activity activity) {
        return new zab(zaa.zaa((Activity)activity));
    }

    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable var1);
}
