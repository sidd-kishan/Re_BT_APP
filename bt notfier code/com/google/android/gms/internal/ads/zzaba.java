/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  com.google.android.gms.internal.ads.zzabg
 *  com.google.android.gms.internal.ads.zzabh
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzabh;

final class zzaba
implements zzabg {
    final Activity zza;

    zzaba(zzabh zzabh2, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.zza);
    }
}