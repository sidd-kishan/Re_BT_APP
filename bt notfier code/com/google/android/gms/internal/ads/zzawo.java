/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  com.google.android.gms.internal.ads.zzawp
 *  com.google.android.gms.internal.ads.zzawq
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import com.google.android.gms.internal.ads.zzawp;
import com.google.android.gms.internal.ads.zzawq;

final class zzawo
implements zzawp {
    final Activity zza;

    zzawo(zzawq zzawq2, Activity activity) {
        this.zza = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.zza);
    }
}
