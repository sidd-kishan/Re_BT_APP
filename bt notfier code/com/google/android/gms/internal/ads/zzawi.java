/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzawp
 *  com.google.android.gms.internal.ads.zzawq
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzawp;
import com.google.android.gms.internal.ads.zzawq;

final class zzawi
implements zzawp {
    final Activity zza;
    final Bundle zzb;

    zzawi(zzawq zzawq2, Activity activity, Bundle bundle) {
        this.zza = activity;
        this.zzb = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.zza, this.zzb);
    }
}
