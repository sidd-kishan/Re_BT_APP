/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.google.android.gms.internal.consent_sdk.zzat
 *  com.google.android.gms.internal.consent_sdk.zzk
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.consent_sdk.zzat;
import com.google.android.gms.internal.consent_sdk.zzk;

final class zzay
implements Application.ActivityLifecycleCallbacks {
    private final Activity zza;
    private final zzat zzb;

    public zzay(zzat zzat2, Activity activity) {
        this.zzb = zzat2;
        this.zza = activity;
    }

    private final void zza() {
        zzat.zza((zzat)this.zzb).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }

    static /* synthetic */ void zza(zzay zzay2) {
        zzay2.zza();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity != this.zza) {
            return;
        }
        this.zzb.zzb(new zzk(3, "Activity is destroyed."));
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
