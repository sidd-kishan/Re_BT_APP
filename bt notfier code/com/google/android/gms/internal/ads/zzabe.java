/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzabg
 *  com.google.android.gms.internal.ads.zzabh
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzabh;

final class zzabe
implements zzabg {
    final Activity zza;
    final Bundle zzb;

    zzabe(zzabh zzabh2, Activity activity, Bundle bundle) {
        this.zza = activity;
        this.zzb = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.zza, this.zzb);
    }
}
